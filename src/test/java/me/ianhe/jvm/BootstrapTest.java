package me.ianhe.jvm;

import java.net.URL;

/**
 * Bootstrap ClassLoader 所加载的核心类库
 *
 * @author iHelin
 * @since 2018/3/12 11:24
 */
public class BootstrapTest {

    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }
}
