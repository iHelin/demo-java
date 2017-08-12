package me.ianhe.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

/**
 * PushbackInputStream类继承了FilterInputStream类是InputStream类的修饰者。
 * 提供可以将数据插入到输入流前端的能力(当然也可以做其他操作)。
 * 简而言之PushbackInputStream类的作用就是能够在读取缓冲区的时候提前知道下一个字节是什么，
 * 其实质是读取到下一个字符后回退的做法，这之间可以进行很多操作，
 * 这有点向你把读取缓冲区的过程当成一个数组的遍历，遍历到某个字符的时候可以进行的操作，
 * 当然，如果要插入，能够插入的最大字节数是与推回缓冲区的大小相关的，插入字符肯定不能大于缓冲区吧！
 *
 * @author iHelin
 * @since 2017/8/12 11:20
 */
public class PushBackInputStreamTest {

    @Test
    public void test() throws Exception {
        String str = "hello,iHelin";
        PushbackInputStream push; // 声明回退流对象
        ByteArrayInputStream bat; // 声明字节数组流对象
        bat = new ByteArrayInputStream(str.getBytes());
        push = new PushbackInputStream(bat); // 创建回退流对象，将拆解的字节数组流传入
        int temp;
        while ((temp = push.read()) != -1) { // push.read()逐字节读取存放在temp中，如果读取完成返回-1
            if (temp == ',') { // 判断读取的是否是逗号
                push.unread(temp); //回到temp的位置
                temp = push.read(); //接着读取字节
                System.out.print("(回退" + (char) temp + ") "); // 输出回退的字符
            } else {
                System.out.print((char) temp); // 否则输出字符
            }
        }
    }
}
