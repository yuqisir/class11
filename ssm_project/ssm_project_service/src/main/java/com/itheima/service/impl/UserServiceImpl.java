package com.itheima.service.impl;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
           userInfo=userMapper.findUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),
                userInfo.getStatus()==1?true:false,true,true,true,getRoles(userInfo.getRoles()));
        return user;
    }
    public List<GrantedAuthority> getRoles(List<Role> roles){
        List<GrantedAuthority>  roleList=new ArrayList();

        for (Role role:roles){
            SimpleGrantedAuthority sg=new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            roleList.add(sg);
        }
        System.out.println("roleList:"+roleList);
        return roleList;
    }
    //遍历所有用户
    public List<UserInfo> findAll() throws Exception{
        return userMapper.findAll();
    }
    //根据Id查询当前用户信息
    public UserInfo findUserById(String uid) throws Exception{
        return userMapper.findUserById(uid);
    }

    @Override
    public void updateUserRoles(String userId, String ids) throws Exception{
        //先删，后保存
        userMapper.deleteUserRoles(userId);
        if(ids!=null&&ids.length()>0){
            String[] roles = ids.split(",");
            for (String roleId:roles){
                userMapper.saveUserRoles(userId,roleId);
            }
        }
    }
}
