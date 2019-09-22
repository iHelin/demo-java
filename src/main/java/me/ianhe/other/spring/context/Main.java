package me.ianhe.other.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author iHelin
 * @date 2019/9/12 13:56
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("me.ianhe.other.spring.context");
        Calculator calculator = (Calculator) context.getBean("calculatorImpl");
        calculator.add(2, 3);
    }
}
