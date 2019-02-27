package me.ianhe.test.my.tomcat;

import java.io.IOException;

/**
 * @author iHelin
 * @since 2017/8/18 13:32
 */
public class HelloWorldServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
