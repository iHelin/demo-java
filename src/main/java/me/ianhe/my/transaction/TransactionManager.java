package me.ianhe.my.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author iHelin
 * @since 2017/8/2 15:02
 */
public class TransactionManager {

    private DataSource dataSource;

    public TransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws SQLException {
        return SingleThreadConnectionHolder.getConnection(dataSource);
    }

    public void start() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }

    public void rollback() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(true);
        connection.close();
    }

}
