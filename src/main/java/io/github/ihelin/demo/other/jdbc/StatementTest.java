package io.github.ihelin.demo.other.jdbc;

import java.sql.*;

/**
 * @author iHelin
 * @since 2018/3/9 09:23
 */
public class StatementTest {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动异常");
        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://112.74.203.130:3306/iHelin", "ihelin", "246260");
             Statement statement = c.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM advice")) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
