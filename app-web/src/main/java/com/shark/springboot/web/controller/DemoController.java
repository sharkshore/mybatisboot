package com.shark.springboot.web.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tuze on 2017/8/23.
 */
@CrossOrigin
@RestController
@RequestMapping("/")
@Slf4j
@Api(value = "demo", description = "Demo测试", consumes = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("hello,springboot");
        return "hello,world";
    }

}
