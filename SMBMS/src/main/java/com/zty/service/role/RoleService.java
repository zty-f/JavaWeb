/**
 * @author: zty
 * @program: SMBMS
 * @description:
 * @create: 2021-08-29 15:33
 * @Version 1.0
 **/
package com.zty.service.role;

import com.zty.pojo.Role;

import java.util.List;

public interface RoleService {
    //获取角色列表
    public List<Role> getRoleList();

}
