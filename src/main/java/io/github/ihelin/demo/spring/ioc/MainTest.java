package io.github.ihelin.demo.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author iHelin
 * @since 2018/5/8 14:26
 */
public class MainTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);

    public static void main(String[] args) throws SQLException {
        // 用我们的配置文件来启动一个 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/beans.xml");
        // 从 context 中取出我们的 Bean，而不是用 new User() 这种方式
        User user = context.getBean("user", User.class);
        // 使用 bean
        LOGGER.debug(user.toString());

        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        LOGGER.debug("connection={}", connection);
        PreparedStatement statement = connection.prepareStatement("select version()");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            LOGGER.info("version:{}", resultSet.getString(1));
        }
    }

}
