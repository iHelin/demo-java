package me.ianhe.jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * vm options:-XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m -XX:+PrintGCDetails
 *
 * @author iHelin
 * @date 2019-01-16 16:12
 */
public class MetaspaceOomMock {

    public static void main(String[] args) {
        URL url;
        List<ClassLoader> classLoaderList = new ArrayList<>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true) {
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("me.ianhe.jvm.FinalizeEscapeGC");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
