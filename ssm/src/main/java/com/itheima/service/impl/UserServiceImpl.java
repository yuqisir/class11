package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import com.itheima.domain.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) throws Exception {
        return userMapper.login(user);
    }

    @Override
    public List<User> findAll(PageBean pageBean) throws Exception {
        pageBean.setPageStart((pageBean.getPageNum()-1)*pageBean.getPageSize());
        return userMapper.findAll(pageBean);
    }

    @Override
    public void saveUser(User user) throws Exception {
        userMapper.saveUser(user);
    }
}
