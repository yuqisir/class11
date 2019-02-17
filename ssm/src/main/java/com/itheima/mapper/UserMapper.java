package com.itheima.mapper;

import com.itheima.domain.User;
import com.itheima.domain.PageBean;

import java.util.List;

public interface UserMapper {

    public User login(User user) throws Exception;

    List<User> findAll(PageBean pageBean) throws Exception;

    void saveUser(User user);
}
