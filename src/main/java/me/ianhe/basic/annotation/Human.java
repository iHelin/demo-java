package me.ianhe.basic.annotation;

import java.lang.annotation.*;

/**
 * 定义一个Human注解
 *
 * @author iHelin
 * @since 2018/4/27 11:44
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Human {

    String studentName() default "anonymity";

    String studentNo() default "20160910";

    int studentAge() default 1;
}
