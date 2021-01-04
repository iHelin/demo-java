package io.github.ihelin.demo.test.my.tomcat;

import java.io.IOException;

/**
 * @author iHelin
 * @since 2017/8/18 13:27
 */
public abstract class MyServlet {

    public abstract void doGet(MyRequest myRequest, MyResponse myResponse);

    public abstract void doPost(MyRequest myRequest, MyResponse myResponse);

    public void service(MyRequest myRequest, MyResponse myResponse) throws IOException {
        if ("POST".equalsIgnoreCase(myRequest.getMethod())) {
            doPost(myRequest, myResponse);
        } else if ("GET".equalsIgnoreCase(myRequest.getMethod())) {
            doGet(myRequest, myResponse);
        } else {
            myResponse.write("Method is not support");
        }
    }
}
