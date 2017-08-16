package me.ianhe.my.dataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author iHelin
 * @since 2017/8/2 17:45
 */
public class MyDefaultPool implements IMyPool {
    private Vector<MyPooledConnection> myPooledConnections = new Vector();

//    private static String jdbcDriver;
    private static String jdbcURL;
    private static String jdbcUserName;
    private static String jdbcPassword;

    private static int initCount;
    private static int step;
    private static int maxCount;

    public MyDefaultPool() {
        init();
        try {
            Class.forName(DBConfigXML.jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        createMyPooledConnection(initCount);
    }

    private void init() {
//        jdbcDriver = DBConfigXML.jdbcDriver;
        jdbcURL = DBConfigXML.jdbcURL;
        jdbcUserName = DBConfigXML.jdbcUserName;
        jdbcPassword = DBConfigXML.jdbcPassword;

        initCount = DBConfigXML.initCount;
        step = DBConfigXML.step;
        maxCount = DBConfigXML.maxCount;
    }

    @Override
    public MyPooledConnection getMyPooledConnection() {
        if (myPooledConnections.size() < 1) {
            throw new RuntimeException("连接池初始化错误！");
        }
        MyPooledConnection myPooledConnection = null;
        try {
            myPooledConnection = getRealConnectionFromPool();
            while (myPooledConnection == null) {
                createMyPooledConnection(step);
                myPooledConnection = getRealConnectionFromPool();
                return myPooledConnection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myPooledConnection;
    }

    @Override
    public void createMyPooledConnection(int count) {
        if (myPooledConnections.size() > maxCount || myPooledConnections.size() + count > maxCount) {
            throw new RuntimeException("连接池已满！");
        }
        for (int i = 0; i < count; i++) {
            try {
                Connection connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
                MyPooledConnection myPooledConnection = new MyPooledConnection(connection, false);
                myPooledConnections.add(myPooledConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized MyPooledConnection getRealConnectionFromPool() throws SQLException {
        for (MyPooledConnection myPooledConnection : myPooledConnections) {
            if (!myPooledConnection.isBusy()) {
                if (myPooledConnection.getConnection().isValid(3000)) {
                    myPooledConnection.setBusy(true);
                    return myPooledConnection;
                } else {
                    Connection connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
                    myPooledConnection.setConnection(connection);
                    myPooledConnection.setBusy(true);
                    return myPooledConnection;
                }
            }
        }
        return null;
    }
}
