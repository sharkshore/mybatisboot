package com.shark.mybatisboot.controller;

import com.shark.mybatisboot.biz.IDemoService;
import com.shark.mybatisboot.dao.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by tuze on 2017/12/7.
 */
@Controller
@RequestMapping("/html")
public class MvcController {

    @Autowired
    IDemoService iDemoService;


    //返回页面
    @RequestMapping("/model")
    public String hello(Model model){
        List<Map> maps = iDemoService.querySqlModelEntity();
        model.addAttribute("model", maps);
        return "model";
    }


    @RequestMapping("/operation")
    public String operation(Model model){
        List<Map> maps = iDemoService.queryOperation();
        model.addAttribute("operation", maps);
        return "operation";
    }

    @RequestMapping("/member")
    public String memberName(Model model) {
        List<String> strings = iDemoService.queryMemberName();
        model.addAttribute("member", strings);
        return "member";
    }
}
