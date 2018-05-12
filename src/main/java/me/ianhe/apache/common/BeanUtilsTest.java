package me.ianhe.apache.common;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author iHelin
 * @since 2018/5/9 09:31
 */
public class BeanUtilsTest {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException, NoSuchFieldException {
        System.out.println(BeanUtils.describe(new Date()));
        Class cla = Class.forName("org.apache.commons.io.Java7Support");
        Method method = cla.getDeclaredMethod("isAtLeastJava7");
        Field field = cla.getDeclaredField("IS_JAVA7");
        field.setAccessible(true);
        method.setAccessible(true);
        System.out.println(field.getBoolean(null));
        System.out.println(method.invoke(null));
    }
}
