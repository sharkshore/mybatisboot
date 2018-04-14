package com.shark.mybatisboot.web.controller;

import com.shark.mybatisboot.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by tuze on 2017/12/7.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class SimpleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DemoService simpleService;

    @Test
    public void hello() throws Exception {

        given(simpleService.toString()) .willReturn("hello,shark");
        mockMvc.perform(get("/simple").accept(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("hello,shark"));

    }

}