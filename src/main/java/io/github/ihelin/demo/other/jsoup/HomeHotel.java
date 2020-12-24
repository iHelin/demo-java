package io.github.ihelin.demo.other.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author iHelin
 * @date 2019-03-21 11:37
 */
public class HomeHotel {

    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("http://www.bthhotels.com/HotelAct/HotelRomList");
        connect.data("ArrDate", "2019/03/21");
        connect.data("DepDate", "2019/03/22");
        connect.data("hotelCd", "010014");
        connect.data("PriceType", "");
        connect.data("memberNo", "");
        Document document = connect.post();
        Elements rows = document.getElementsByClass("list_room_tj_row");
        for (Element row : rows) {
            Elements yfButton = row.getElementsByClass("yf_button");
            if (yfButton.size() > 0) {
                Element listRoomIntro = row.getElementsByClass("list_room_intro").get(0);
                System.out.println(listRoomIntro.getElementsByTag("dt").get(0).text());
            }
        }
//        System.out.println(list_room_yd);
    }
}
