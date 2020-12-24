package io.github.ihelin.demo.spring.action;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author iHelin
 * @since 2018/8/29 12:45
 */
@Profile("dev")
@Component
public class DevPeppers implements CompactDisc, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    private final String title = "Dev";

    private final String artist = "The Beatles";


    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        CompactDisc bean = beanFactory.getBean(CompactDisc.class);
        System.out.println(bean == this);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CompactDisc bean = applicationContext.getBean(CompactDisc.class);
        System.out.println(bean == this);
    }
}
