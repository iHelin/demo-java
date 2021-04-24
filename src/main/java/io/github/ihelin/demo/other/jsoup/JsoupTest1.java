package io.github.ihelin.demo.other.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * JsoupTest
 *
 * @author iHelin
 * @since 2017/8/12 23:02
 */
public class JsoupTest1 {

    public static void main(String[] args) throws IOException {
        Document doc1 = Jsoup.connect("https://www.toutiao.com/w/i6841661135273017348/")
            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.96 Safari/537.36 Edg/88.0.705.50")
            .get();
        System.out.println(doc1);
    }
}
