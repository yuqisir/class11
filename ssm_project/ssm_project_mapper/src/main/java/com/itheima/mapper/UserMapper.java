package com.itheima.mapper;

import com.itheima.domain.UserInfo;

public interface UserMapper {
    UserInfo findUserByName(String username) throws Exception;
}
