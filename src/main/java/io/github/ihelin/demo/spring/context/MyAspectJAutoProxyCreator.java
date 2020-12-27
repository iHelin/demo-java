package io.github.ihelin.demo.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author iHelin
 * @since 2019-07-18 08:58
 */
@Component
public class MyAspectJAutoProxyCreator implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Calculator) {
            return Proxy.newProxyInstance(getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("开始计算。。。");
                Object result = method.invoke(bean, args);
                System.out.println("结束计算。。。");
                return result;
            });
        }
        return bean;
    }
}
