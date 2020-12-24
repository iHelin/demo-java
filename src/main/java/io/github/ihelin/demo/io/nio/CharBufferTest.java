package io.github.ihelin.demo.io.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Set;

public class CharBufferTest {

    public static void main(String[] args) throws CharacterCodingException {
        Charset charset1 = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder charsetEncoder = charset1.newEncoder();
        //获取解码器
        CharsetDecoder charsetDecoder = charset1.newDecoder();
        CharBuffer charBuffer1 = CharBuffer.allocate(1024);
        charBuffer1.put("好好学习好好学习好好学习");
        charBuffer1.flip();

        //编码
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer1);
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.println(byteBuffer.get());
        }

        System.out.println("-------------------------------");

        //解码
        byteBuffer.flip();
        CharBuffer charBuffer2 = charsetDecoder.decode(byteBuffer);
        System.out.println(charBuffer2.toString());

        System.out.println("-------------------------------");

        Charset cs2 = Charset.forName("GBK");
        byteBuffer.flip();
        CharBuffer charBuffer3 = cs2.decode(byteBuffer);
        System.out.println(charBuffer3.toString());
    }

    /**
     * 字符集
     *
     * @author iHelin
     * @since 2017/11/30 22:18
     */
    @Test
    public void test() {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entrySet = map.entrySet();

        for (Map.Entry<String, Charset> entry : entrySet) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
