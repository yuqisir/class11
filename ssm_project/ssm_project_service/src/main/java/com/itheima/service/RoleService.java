package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleService {
    //根据用户Id查询当前用户所拥有的角色
    List<Role> findRolesByUserId(String uid) throws Exception;

    List<Role> findAll()throws Exception;;
}
