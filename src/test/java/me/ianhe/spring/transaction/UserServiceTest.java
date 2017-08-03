package me.ianhe.spring.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import me.ianhe.my.transaction.UserService;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**
 * @author iHelin
 * @since 2017/8/2 15:14
 */
public class UserServiceTest {
    public static final String jdbcDriver = "com.mysql.jdbc.Driver";
    public static final String jdbcURL = "jdbc:mysql://120.27.100.98:3306/seven";
    public static final String jdbcUserName = "ihelin";
    public static final String jdbcPassword = "246260";

    @Test
    public void action() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcURL);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        final UserService userService = new UserService(dataSource);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> userService.action()).start();
        }
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void action2() throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcURL);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        final UserService userService = new UserService(dataSource);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> userService.action()).start();
        }
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}