package me.ianhe.io;

import org.junit.Test;

/**
 * 编码测试
 *
 * @author iHelin
 * @since 2017/8/3 15:02
 */
public class EncodeTest {

    @Test
    public void test() throws Exception {
        String str = "慕课ABC";
        // 转换成字节序列用的是项目默认的编码（utf-8）
        byte[] bytes1 = str.getBytes();
        //utf-8编码：中文占3个字节，英文一个字节
        for (byte b : bytes1) {
            // 把字节（转换成了int）以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        byte[] bytes2 = str.getBytes("gbk");
        //gbk编码中文占两个字节，英文一个字节
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        //java是双字节编码 utf-16be编码
        byte[] bytes3 = str.getBytes("utf-16be");
        //utf-16be:中文和英文都占两字节
        for (byte b : bytes3) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        /*
         * 当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要这种编码方式，否则会出现乱码
		 */
        String str1 = new String(bytes3);
        System.out.println(str1);//乱码
        String str2 = new String(bytes3, "utf-16be");//指定编码方式
        System.out.println(str2);
        /*
         * 文本文件 就是字节序列
		 * 可以是任意编码的字节序列
		 * 如果在中文机器上直接创建文本文件，那么该文本文件只认识ansi编码
		 * 联通、联这是一种巧合，他们正好符合了utf-8编码的规则。
		 */
    }

    @Test
    public void unicodeTest() {
        String c = "\u5bf9\u8c61";
        System.out.println(c);
    }

}