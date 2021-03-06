package io.github.ihelin.demo.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StreamTokenizer;

/**
 * @author iHelin
 * @since 2017/8/12 11:35
 */
public class StreamTokenizerTest {

    /**
     * 统计字符数
     *
     * @author iHelin
     * @since 2017/8/12 11:35
     */
    public static void main(String[] args) {
        String fileName = "demo/fileWriter.txt";

        try (FileReader fileReader = new FileReader(fileName)) {
            //创建分析给定字符流的标记生成器
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(fileReader));
            //ordinaryChar方法指定字符参数在此标记生成器中是“普通”字符。
            //下面指定单引号、双引号和注释符号是普通字符
            st.ordinaryChar('\'');
            st.ordinaryChar('\"');
            st.ordinaryChar('/');

            String s;
            int numberSum = 0;
            int wordSum = 0;
            int symbolSum = 0;
            int total;
            //nextToken方法读取下一个Token.
            //TT_EOF指示已读到流末尾的常量。
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                //在调用 nextToken 方法之后，ttype字段将包含刚读取的标记的类型
                switch (st.ttype) {
                    //TT_EOL指示已读到行末尾的常量。
                    case StreamTokenizer.TT_EOL:
                        break;
                    //TT_NUMBER指示已读到一个数字标记的常量
                    case StreamTokenizer.TT_NUMBER:
                        //如果当前标记是一个数字，nval字段将包含该数字的值
                        s = String.valueOf((st.nval));
                        System.out.println("数字有：" + s);
                        numberSum++;
                        break;
                    //TT_WORD指示已读到一个文字标记的常量
                    case StreamTokenizer.TT_WORD:
                        //如果当前标记是一个文字标记，sval字段包含一个给出该文字标记的字符的字符串
                        s = st.sval;
                        System.out.println("单词有： " + s);
                        wordSum++;
                        break;
                    default:
                        //如果以上3中类型都不是，则为英文的标点符号
                        s = String.valueOf((char) st.ttype);
                        System.out.println("标点有： " + s);
                        symbolSum++;
                }
            }
            System.out.println("数字有 " + numberSum + "个");
            System.out.println("单词有 " + wordSum + "个");
            System.out.println("标点符号有： " + symbolSum + "个");
            total = symbolSum + numberSum + wordSum;
            System.out.println("Total = " + total);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
