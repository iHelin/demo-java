package io.github.ihelin.demo.spring.ioc.config.context;

import org.springframework.stereotype.Component;

/**
 * @author iHelin
 * @since 2019-07-18 08:57
 */
@Component
public class CalculatorImpl implements Calculator {

    @Override
    public void add(int a, int b) {
        System.out.println(a + b);
    }
}
