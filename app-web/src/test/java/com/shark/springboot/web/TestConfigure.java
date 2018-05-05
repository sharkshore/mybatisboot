package com.shark.springboot.web;

import com.shark.springboot.model.Demo;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created by tuze on 2017/12/7.
 */
@TestConfiguration
public class TestConfigure {

    @Bean("testDemo")
    public Demo getDemo(){
        Demo demo = new Demo();
        demo.setAge(33);
        demo.setContent("test美国新闻");
        demo.setName("testnews");
        return demo;
    }

}
