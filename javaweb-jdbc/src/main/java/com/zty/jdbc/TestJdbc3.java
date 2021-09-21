/**
 * @author: zty
 * @program: javaweb-jdbc
 * @ClassName TestJdbc3
 * @description:
 * @create: 2021-08-17 15:50
 * @Version 1.0
 **/
package com.zty.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc3 {
    @Test
    public void Test() throws SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        //1.加载驱动
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.连接数据库
             connection = DriverManager.getConnection(url, username, password);

            //通知数据库开启事务 false :开启
            connection.setAutoCommit(false);

            String sql = "update accout set money=money-100 where name='A'";

            connection.prepareStatement(sql).executeUpdate();
            //制造错误
            //int i=1/0;

            String sql2 = "update accout set money=money+100 where name='B'";
            connection.prepareStatement(sql2).executeUpdate();

            connection.commit();//以上两条sql都执行成功就提交事务！

            System.out.println("更新数据成功！");
        }catch (Exception e){
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            connection.close();
        }


    }
}
