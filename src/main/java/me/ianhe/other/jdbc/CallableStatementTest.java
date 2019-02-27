package me.ianhe.other.jdbc;

import java.sql.*;

/**
 * @author iHelin
 * @since 2018/3/9 10:23
 */
public class CallableStatementTest {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动异常");
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://112.74.203.130:3306/iHelin", "ihelin", "246260");
            CallableStatement cs = connection.prepareCall("{call getnamebyid(?,?)}");
            cs.setInt(1, 7);  //索引1，第3个id
            //输出参数的话要注册
            cs.registerOutParameter(2, Types.CHAR);
            //注册后要更新
            cs.execute();
            String name = cs.getString(2);  //这个是索引的意思
            cs.executeQuery();
            System.out.println(name);
            /*statement.setInt(1, 4);
            statement.setInt(2, 5);
            statement.registerOutParameter(3, Types.INTEGER);
            statement.execute();
            System.out.println("执行结果是：" + statement.getInt(3));*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}