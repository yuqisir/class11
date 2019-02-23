package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception {
        List<UserInfo> list = userService.findAll();
        model.addAttribute("userList",list);
        return "user-list";
    }
    //根据Id查询当前用户信息
    @RequestMapping("/findUserById")
    public String findUserById(String uid,Model model)throws Exception{
        UserInfo userInfo=userService.findUserById(uid);
        model.addAttribute("user",userInfo);
        return "user-show";
    }
    //根据用户Id查询当前用户所拥有的角色
    @RequestMapping("/findRolesByUserId/{uid}")
    public String findRolesByUserId(@PathVariable String uid, Model model) throws Exception {
        //当前用户所拥有的角色
        List<Role> userRolesList=roleService.findRolesByUserId(uid); //bc
        //所有的角色
        List<Role> roleList=roleService.findAll();//abcde
        for (Role role:roleList){
            for (Role userRole:userRolesList){
                if((role.getId()).equals(userRole.getId())){
                    role.setFlag(1);
                }
            }
        }
        model.addAttribute("roleList",roleList);
        model.addAttribute("uid",uid);
        return "user-role-add";
    }
    //更改用户角色
    @RequestMapping("/updateUserRoles")
    public String updateUserRoles(String userId,String ids)throws Exception{
        userService.updateUserRoles(userId,ids);
        return "redirect:/user/findAll";
    }
}
