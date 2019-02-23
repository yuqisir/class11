package com.itheima.aop;

import com.itheima.controller.SysLogController;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

public class SysLogAop {
    private Date visitTime;
    private Long executionTime;
    private String url;
    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private HttpServletRequest request;
    public void beforeMethod(){
        visitTime=new Date();
    }
    public void afterMethod(JoinPoint obj) throws Exception {
        //1.获取执行controller对象的字节码
        Class objClass = obj.getTarget().getClass();
        //2.获取执行的方法名
        String mthodName = obj.getSignature().getName();
        //3.获取执行方法所带有的参数列表
        Object[] args = obj.getArgs();
        if (!(obj.getTarget() instanceof SysLogController)) {
            //1.判断指定类上是否存在注解
            RequestMapping classAnnotation = (RequestMapping) objClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValues = classAnnotation.value();
                //获取方法上的注解值
                //1.获取方法对象
                Method method = null;
                //1.1没有参数
                if (args == null) {
                    method = objClass.getMethod(mthodName);
                } else {
                    //1.2有参数
                    Class[] classArgs = new Class[args.length];
                    //参数类型转换
                    for (int i = 0; i < args.length; i++) {
                        if (args[i] instanceof BindingAwareModelMap) {
                            classArgs[i] = Model.class;
                        } else {
                            classArgs[i] = args[i].getClass();
                        }
                    }
                    method = objClass.getMethod(mthodName, classArgs);
                }
                //2.获取方法上的注解
                String[] methodValue = null;
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    //3.获取注解的值
                    methodValue = methodAnnotation.value();
                }
                url = classValues[0] + methodValue[0];
            }
            //获取执行的时长
            executionTime = new Date().getTime() - visitTime.getTime();

            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            String ip = request.getRemoteAddr();
            //执行保存日志信息
            SysLog sysLog = new SysLog();
            sysLog.setVisitTime(visitTime);
            sysLog.setUsername(username);
            sysLog.setIp(ip);
            sysLog.setUrl(url);
            sysLog.setExecutionTime(executionTime);
            sysLog.setMethod(mthodName);
            sysLogService.saveSysLog(sysLog);

        }
    }
}
