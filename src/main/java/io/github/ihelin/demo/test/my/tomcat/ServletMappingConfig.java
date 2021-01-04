package io.github.ihelin.demo.test.my.tomcat;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author iHelin
 * @since 2017/8/18 13:35
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = Lists.newArrayList();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "io.github.ihelin.demo.test.my.tomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld", "/world", "io.github.ihelin.demo.test.my.tomcat.HelloWorldServlet"));
    }
}
