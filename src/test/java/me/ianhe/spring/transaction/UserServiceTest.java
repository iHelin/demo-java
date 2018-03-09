package me.ianhe.spring.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import me.ianhe.my.transaction.UserService;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 不同的连接池效果不同
 * druid每个线程都有一个connection
 * BasicDataSource则有多个线程共用一个connection的情况
 *
 * @author iHelin
 * @since 2017/8/2 15:14
 */
public class UserServiceTest {

    public static final String jdbcDriver = "com.mysql.jdbc.Driver";
    public static final String jdbcURL = "jdbc:mysql://120.27.100.98:3306/yueju";
    public static final String jdbcUserName = "ihelin";
    public static final String jdbcPassword = "246260";

    @Test
    public void action() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcURL);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        final UserService userService = new UserService(dataSource);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> userService.action(), "用户" + i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void action2() {
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
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}