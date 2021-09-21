/**
 * @author: zty
 * @program: SMBMS
 * @description:
 * @create: 2021-08-27 16:32
 * @Version 1.0
 **/
package com.zty.dao.user;

import com.zty.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode, String userPassword) throws SQLException;

    //修改当前用户密码
    public int updatePwd(Connection connection, int id, String password) throws SQLException;

    //查询用户总数
    public int getUserCount(Connection connection,String username ,int userRole)throws SQLException;

    //通过条件查询-userList
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)throws Exception;

    public int add(Connection connection, User user)throws Exception;

    public int deleteUserById(Connection connection, Integer delId)throws Exception;

    public User getUserById(Connection connection, String id)throws Exception;

    public int modify(Connection connection, User user)throws Exception;

}
