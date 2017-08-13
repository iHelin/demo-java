package me.ianhe.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * @author iHelin
 * @since 2017/8/12 23:02
 */
public class JsoupTest {

    @Test
    public void test() throws Exception {
        String html = "<html><head><title>开源中国社区</title></head>"
                + "<body><p>这里是jsoup 项目的相关文章</p></body></html>";
        Document doc = Jsoup.parse(html);
//        System.out.println(doc.body().text());
        Document doc1 =Jsoup.connect("http://music.163.com/#/discover/playlist/?order=hot&cat=%E5%85%A8%E9%83%A8&limit=35&offset=0").get();
        System.out.println(doc1.body().text());
    }
}
