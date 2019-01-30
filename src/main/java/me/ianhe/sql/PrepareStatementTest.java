package me.ianhe.sql;

import java.sql.*;

/**
 * PreparedStatement 预编译 SQL 语句，性能更好
 * PreparedStatement 无须"拼接" SQL 语句，编程更简单
 * PreparedStatement 可以防止 SQL 注入，安全性更好
 *
 * @author iHelin
 * @since 2018/3/9 10:13
 */
public class PrepareStatementTest {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动异常");
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://112.74.203.130:3306/iHelin", "ihelin", "246260");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM advice WHERE id= ? AND name = ?")) {
            statement.setInt(1, 1);
            statement.setString(2, "iHelin");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
