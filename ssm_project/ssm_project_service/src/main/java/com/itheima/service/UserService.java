package com.itheima.service;

import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{

    //遍历所有用户
    List<UserInfo> findAll() throws Exception;

    UserInfo findUserById(String uid) throws Exception;

    void updateUserRoles(String userId, String ids)throws Exception;
}
