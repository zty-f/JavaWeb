/**
 * @author: zty
 * @program: javaweb-jdbc
 * @ClassName TestJdbc
 * @description:
 * @create: 2021-08-17 15:04
 * @Version 1.0
 **/
package com.zty.jdbc;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.向数据库发送sql的对象
        Statement statement = connection.createStatement();
        //4.编写sql
        //String sql = "select * from users";
        String sql = "delete from users where id=3";
        //5.执行sql  返回一个结果集
        //ResultSet resultSet = statement.executeQuery(sql);
        int i = statement.executeUpdate(sql);

        //while (resultSet.next())
        //{
        //    System.out.println("id="+resultSet.getObject("id"));
        //    System.out.println("name="+resultSet.getObject("name"));
        //    System.out.println("password="+resultSet.getObject("password"));
        //    System.out.println("email="+resultSet.getObject("email"));
        //    System.out.println("birthday="+resultSet.getObject("birthday"));
        //}
        //6.关闭连接
        //resultSet.close();
        statement.close();
        connection.close();


    }
}
