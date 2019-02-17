package com.itheima.controller;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //设置允许上传的文件类型
    private String[] allowType={"image/jpeg","image/png"};

    @Autowired
    private UserService service;

    @RequestMapping("/login")
    public String login(User user, HttpSession session, Integer ck, HttpServletResponse response) throws Exception {
        System.out.println("登陆");
        User u = service.login(user);
        if(u==null){//输入用户名和密码在数据库中不存在，登陆失败
            return "loginError";
        }
        //ck有值且为1则表示记住，否则没有选择记住
        //记住用户名和密码，将用户名和密码存在cookie中
        //1.创建cookie
        Cookie cookieName=new Cookie("username",user.getUsername());
        Cookie cookiePwd=new Cookie("pwd",user.getPwd());
        if(ck!=null&&ck==1){
            //2.设置cookie存活时间
            cookieName.setMaxAge(7*24*60*60);
            cookiePwd.setMaxAge(7*24*60*60);
        }else {
            cookieName.setMaxAge(0);
            cookiePwd.setMaxAge(0);
        }
        //3.设置cookie存储路径
        cookieName.setPath("/");
        cookiePwd.setPath("/");
        response.addCookie(cookieName);
        response.addCookie(cookiePwd);

        session.setAttribute("user",u);
        return "index1";
    }

    @RequestMapping("/findAll")
    public String findAll(@RequestParam(name="pageNum",required = false,defaultValue = "1") Integer pageNum,
                          @RequestParam(name="pageSize",required = false,defaultValue = "5")Integer pageSize,Model model) throws Exception {
        PageBean pageBean=new PageBean();
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);
        List<User> list=service.findAll(pageBean);
        model.addAttribute("userList",list);
        model.addAttribute("pages",pageBean);
        return "list";
    }

    @RequestMapping("/saveUser")
    public String saveUser(HttpServletRequest req,MultipartFile picName,User user) throws Exception {

        System.out.println("文件的类型："+picName.getContentType());
            if (!Arrays.asList(allowType).contains(picName.getContentType())){
                throw new RuntimeException("你上传的文档类型不符合要求");
            }
       //  System.out.println("----:"+user.getPic());
//        String path = req.getSession().getServletContext().getRealPath("/pics/");
//        File file=new File(path);
//        if(!file.exists()){
//            file.mkdirs();
//        }
   //     String fileName=picName.getOriginalFilename();
      //  picName.transferTo(new File(path,fileName));
       // user.setPic(fileName);
        //调用service
      //  service.saveUser(user);
       return "redirect:/user/findAll";
    }
}
