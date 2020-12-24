package io.github.ihelin.demo.test.my.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author iHelin
 * @since 2017/8/2 15:08
 */
public class UserOrderDao {

    private final DataSource dataSource;

    public UserOrderDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void buy() throws SQLException {
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);
        System.out.println("当前用户订单线程：" + Thread.currentThread().getName() + "，使用管道(hashcode)："
                + connection.hashCode());
    }
}
