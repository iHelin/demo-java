package me.ianhe.test.my.tomcat;

import java.io.IOException;

/**
 * @author iHelin
 * @since 2017/8/18 13:31
 */
public class FindGirlServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get girl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post girl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
