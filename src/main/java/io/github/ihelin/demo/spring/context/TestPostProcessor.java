package io.github.ihelin.demo.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author iHelin
 * @date 2019-07-18 09:00
 */
public class TestPostProcessor {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("=======================");
        Calculator bean = applicationContext.getBean(Calculator.class);
        bean.add(1, 2);
    }
}
