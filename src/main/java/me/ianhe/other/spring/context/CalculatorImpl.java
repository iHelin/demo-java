package me.ianhe.other.spring.context;

import org.springframework.stereotype.Component;

/**
 * @author iHelin
 * @date 2019-07-18 08:57
 */
@Component
public class CalculatorImpl implements Calculator {

    @Override
    public void add(int a, int b) {
        System.out.println(a + b);
    }
}
