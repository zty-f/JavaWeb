/**
 * @author: zty
 * @program: javaweb-jdbc
 * @ClassName TestJdbc2
 * @description:
 * @create: 2021-08-17 15:31
 * @Version 1.0
 **/
package com.zty.jdbc;

import java.sql.*;

public class TestJdbc2{
    public static void main(String[] args) throws Exception{
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
       //编写SQL
        String sql = "insert into users(id, name, password, email, birthday) VALUES (?,?,?,?,?)";
                //预编译
        PreparedStatement prepareStatement = connection.prepareStatement(sql);

        prepareStatement.setInt(1,3);
        prepareStatement.setString(2,"彭于晏");
        prepareStatement.setString(3,"123456");
        prepareStatement.setString(4,"222@qq.com");
        prepareStatement.setDate(5,new Date(new java.util.Date().getTime()));

        int i = prepareStatement.executeUpdate();
        if(i>0){
            System.out.println("插入数据成功！");
        }

        prepareStatement.close();
        connection.close();
    }
}
