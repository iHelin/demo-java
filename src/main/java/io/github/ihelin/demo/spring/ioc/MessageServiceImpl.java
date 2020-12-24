package io.github.ihelin.demo.spring.ioc;

/**
 * @author iHelin
 * @since 2018/5/8 14:25
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage() {
        return "hello world";
    }

}
