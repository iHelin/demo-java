package io.github.ihelin.demo.test.my.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author iHelin
 * @since 2017/8/2 15:02
 */
public class TransactionManager {

    private final DataSource dataSource;

    public TransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void start() throws SQLException {
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);
        connection.setAutoCommit(false);
    }

    public void rollback() {
        Connection connection;
        try {
            connection = SingleThreadConnectionHolder.getConnection(dataSource);
            connection.rollback();
        } catch (SQLException e) {
            System.out.println("数据回滚失败");
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);
        connection.setAutoCommit(true);
        connection.close();
    }

}
