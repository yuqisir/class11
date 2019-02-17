package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    public User login(User user) throws Exception;

    List<User> findAll(PageBean pageBean) throws Exception;

    void saveUser(User user) throws Exception;
}
