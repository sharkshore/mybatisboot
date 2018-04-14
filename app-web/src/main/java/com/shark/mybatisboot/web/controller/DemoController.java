package com.shark.mybatisboot.web.controller;

import com.github.pagehelper.PageHelper;
import com.shark.mybatisboot.common.enums.ErrorMsgEnum;
import com.shark.mybatisboot.common.exception.ServiceException;
import com.shark.mybatisboot.common.model.JsrGroup;
import com.shark.mybatisboot.dal.model.Demo;
import com.shark.mybatisboot.service.DemoService;
import com.shark.mybatisboot.web.model.PageParams;
import com.shark.mybatisboot.web.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by tuze on 2017/8/23.
 */
@CrossOrigin
@RestController
@RequestMapping("/")
@Slf4j
@Api(value = "/", description = "Demo测试", consumes = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    @Autowired
    public DemoService demoService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("hello,springboot");
        return "hello,world";
    }

    @ApiOperation(value = "查询demo", notes = "查询demo", response = Result.class)
    @RequestMapping(value = "/select", method = {RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Demo> select(@Validated({JsrGroup.Get.class}) @RequestBody Demo demo) {
        try {

            List<Map<String, Object>> maps = demoService.selectBySelective(demo);
            log.info("查询demo,请求信息:{},返回信息:{}", "", maps);
            return new Result(maps);
        } catch (ServiceException se) {
            return new Result(se.getErrorMsgEnum());
        } catch (Exception e) {
            log.error("查询商户的轮播图片,{}", "", e);
            return new Result(ErrorMsgEnum.E0001);
        }
    }

    /**
     * 分页查询
     * http://localhost:9000/mybatisboot/queryMemberName?pageNum=2&pageSize=2
     *
     * @param pageParams
     * @return
     */
    @RequestMapping(value = "/queryMemberName", method = RequestMethod.GET)
    public List<String> queryMemberName(PageParams pageParams) {
        log.info("查询...");
        log.debug("这是一个debug日志");
        //Mybatis
//        PageHelper.startPage(2, 2);
        PageHelper.startPage(pageParams);
        List<String> strings = demoService.queryMemberName();
        return strings;
    }


}
