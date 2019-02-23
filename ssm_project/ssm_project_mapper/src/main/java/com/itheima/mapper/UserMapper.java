package com.itheima.mapper;

import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //根据用户查询
    UserInfo findUserByName(String username) throws Exception;
    //遍历所有用户
    List<UserInfo> findAll() throws Exception;
    //根据Id查询当前用户信息
    UserInfo findUserById(String uid)throws Exception;

    void deleteUserRoles(String userId)throws Exception;

    void saveUserRoles(@Param("userId") String userId, @Param("roleId")String roleId)throws Exception;
}
