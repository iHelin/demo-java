package me.ianhe.test.my.transaction;

import com.google.common.collect.Maps;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * 事物测试
 *
 * @author iHelin
 * @since 2017/8/2 14:53
 */
public class ConnectionHolder {

    private Map<DataSource, Connection> map = Maps.newHashMap();

    public Connection getConnectionByDataSource(DataSource dataSource) throws SQLException {
        Connection connection = map.get(dataSource);
        if (connection == null || connection.isClosed()) {
            connection = dataSource.getConnection();
            map.put(dataSource, connection);
        }
        return connection;
    }
}
