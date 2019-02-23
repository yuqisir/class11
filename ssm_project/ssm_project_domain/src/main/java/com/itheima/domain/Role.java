package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private String id;
    private String roleName;
    private String roleDesc;
    //角色和权限的关联关系
    private List<Permission> permissions;
    private List<UserInfo> users;
    //红绿灯的标志：1代指当前用户拥有此角色，0代指当前用户未拥有此角色
    private int flag;
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
