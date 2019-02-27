package me.ianhe.utils;

import java.io.*;

/**
 * IO流（输入输出流） 字节流、字符流
 * 1.字节流 InputStream、OutputStream
 * InputStream抽象了应用程序读取数据的方式 OutputStream抽象了应用程序写出数据的方式 EOF = End 读到-1就读到结尾
 * 输入流基本方法 int b = in.read();读取一个字节，无符号填充到int的低八位 -1是EOF in.read(byte[] buf)
 * 读取数据填充到字节数组buf in.read(byte[] buf,int start,int size)
 * 读取数据到字节数组buf，从buf的start位置开始，存放size长度的数据 输出流基本方法 out.write(int b);
 * 写出一个byte到流，b的低八位 out.write(byte[] buf) 将buf字节数组都写入到流 out.write(byte[] buf,int
 * start,int size) 字节数组buf从start位置开始写size长度的字节到流
 * FileInputStream--->具体实现了在文件上读取数据
 * FileOutpuStream--->实现了向文件中写出byte数据的方法
 * DataInputStream/DataOutputStream对“流”功能的扩展，可以更加方便的读取int，long，字符等类型数据
 * writeInt()/writeDouble()/writeUTF()
 * BufferedInputStream/BufferedOutputStream
 * 这两个流类为IO提供了带缓冲区的操作，一般打开文件进行写入或读取操作时，都会加上缓冲	，这种流模式提高了IO的性能
 * 从应用程序中把数据放入文件，相当于将一缸水倒入到另一个缸中
 * FileOutputStream--->write()方法相当于一滴一滴的把水转移过去
 * DataOutputStream--->writeXxx()方法会方便一些，相当于一瓢一瓢的转移
 * BufferedOutputStream--->write方法更方便，相当于一瓢一瓢先放入桶中，然后从桶中倒入到另一个缸中
 *
 * @author iHelin
 * @date 2019-02-27 11:20
 */
public class IOSupport {

    /**
     * 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
     */
    public static final byte[] ARRAY_LETTERS = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D,
            0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A};

    /**
     * 打印byte对应的16进制的字符串
     *
     * @param val
     * @return
     */
    public static String byteToHexString(byte val) {
        return Integer.toHexString(val & 0xff);
    }

    /**
     * 打印char对应的16进制的字符串
     *
     * @param val
     * @return
     */
    public static String charToHexString(char val) {
        return Integer.toHexString(val);
    }

    /**
     * 打印short对应的16进制的字符串
     *
     * @param val
     * @return
     */
    public static String shortToHexString(short val) {
        return Integer.toHexString(val & 0xffff);
    }

    public static BufferedReader getBufferedReader() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("demo/read.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        return new BufferedReader(inputStreamReader);
    }

    public static BufferedWriter getBufferedWriter() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("demo/outputStreamWriter.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        return new BufferedWriter(outputStreamWriter);
    }

    /**
     * 读取指定文件的内容，按照16进制输出到控制台 并且每输出10个byte换行 单字节读取不适合大文件，读大文件效率低
     *
     * @param fileName
     * @throws IOException
     */
    public static void printHex(String fileName) throws IOException {
        // 把文件作为字节流进行读操作
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = fileInputStream.read()) != -1) {
            if (b <= 0xf) {
                // 单位数前面补0
                System.out.print('0');
            }
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        fileInputStream.close();
    }

    /**
     * 批量读取，对大文件而言效率高
     *
     * @param fileName
     * @throws IOException
     */
    public static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[8 * 1024];// 20k
        // 从in中批量读取字节，放入到buf这个字节数组中，从第0个位置开始放，最多放buf.length个，返回的是读到的字节的个数
        /*
         * int bytes = in.read(buf, 0, buf.length);// 一次性读完，说明字节数组足够大 int j = 1;
         * for (int i = 0; i < bytes; i++) { if (buf[i] <= 0xf) {
         * System.out.print('0'); } System.out.print(Integer.toHexString(buf[i])
         * + " "); if (j++ % 10 == 0) System.out.println(); }
         */
        int bytes;
        int j = 1;
        while ((bytes = in.read(buf, 0, buf.length)) != -1) {
            for (int i = 0; i < bytes; i++) {
                if (buf[i] <= 0xf) {
                    System.out.print('0');
                }
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
        in.close();
    }

    /**
     * 单字节，不带缓冲进行文件拷贝
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByByte(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件：" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
            out.flush();
        }
        in.close();
        out.close();
    }

    /**
     * 文件拷贝，字节批量读取
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件：" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int numberRead;
        while ((numberRead = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, numberRead);
            out.flush();// 最好加上
        }
        in.close();
        out.close();
    }

    /**
     * 进行文件的拷贝，利用带缓冲的字节流
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffered(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件：" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int c;
        while ((c = bis.read()) != -1) {
            bos.write(c);
            bos.flush();//刷新缓冲区
        }
        bis.close();
        bos.close();
    }

    private IOSupport() {
        throw new UnsupportedOperationException("工具类不允许实例化");
    }
}
