package io.github.ihelin.demo.test.my.datasource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author iHelin
 * @since 2017/8/2 18:20
 */
public class TestMain {

    public static IMyPool myPool = MyPoolFactory.getInstance();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                MyPooledConnection myPooledConnection = myPool.getMyPooledConnection();
                ResultSet query = myPooledConnection.query("select * from user");
                try {
                    while (query.next()) {
                        System.out.println(query.getString("name") + "，" + query.getString("login_id")
                                + "，使用管道：" + myPooledConnection.getConnection().hashCode());
                    }
                    myPooledConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
