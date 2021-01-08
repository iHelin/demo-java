package io.github.ihelin.demo.spring.aop.config;

import org.springframework.stereotype.Service;

/**
 * @author iHelin
 * @since 2021/1/8 17:56
 */
@Service
public class UserService {

    public void add() {
        System.out.println("add");
    }
}
