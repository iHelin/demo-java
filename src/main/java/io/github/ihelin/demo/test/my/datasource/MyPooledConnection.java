package io.github.ihelin.demo.test.my.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author iHelin
 * @since 2017/8/2 17:45
 */
public class MyPooledConnection {

    private Connection connection;
    private boolean isBusy = false;

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public MyPooledConnection(Connection connection, boolean isBusy) {
        this.connection = connection;
        this.isBusy = isBusy;
    }

    public void close() {
        isBusy = false;
    }

    public ResultSet query(String sql) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
