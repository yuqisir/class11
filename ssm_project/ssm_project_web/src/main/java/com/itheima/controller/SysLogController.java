package com.itheima.controller;

import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import com.itheima.utils.ExcelFileGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception {
        List<SysLog> list = sysLogService.findAll();
        model.addAttribute("sysLogs",list);
        return "syslog-list";
    }
    @RequestMapping("/excelPoi")
    public void excelPoi(HttpServletResponse response) throws Exception {
            //1.组装表头的信息ArrayList
            ArrayList nameList=new ArrayList();
            nameList.add("id");
            nameList.add("a");
            nameList.add("b");
            nameList.add("c");
            nameList.add("d");
            nameList.add("e");
            nameList.add("f");

            //2.组装excel表格内容数据ArrayList
            List<SysLog> list = sysLogService.findAll();
            ArrayList dataList=new ArrayList();
            for (SysLog sl:list){
                ArrayList arrayList=new ArrayList();
                arrayList.add(sl.getId());
                arrayList.add(sl.getVisitTimeStr());
                arrayList.add(sl.getUsername());
                arrayList.add(sl.getIp());
                arrayList.add(sl.getUrl());
                arrayList.add(sl.getExecutionTime());
                arrayList.add(sl.getMethod());

                dataList.add(arrayList);
            }

            //使用输出流去完成导出excel的操作
            OutputStream out = response.getOutputStream();
            response.reset();//重新设置
            response.setContentType("application/vnd.ms-excel");//设置生成的格式
            ExcelFileGenerator excelFileGenerator = new ExcelFileGenerator(nameList,dataList);
            excelFileGenerator.expordExcel(out);
            //做excel导出的时候，必须执行的代码
            System.setOut(new PrintStream(out));
            out.flush();
            if(out!=null){
                out.close();
            }

    }
}
