package com.shark.springboot.web;


import com.shark.springboot.web.controller.DemoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
//@AutoConfigureRestDocs(outputDir = "target/snippets")
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {

        //参数示例
        // MockMvcRequestBuilders.put("/user").param("id", "3").param("name", "更新333")

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = post("/hello").
                contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content("{name:22}");
        this.mockMvc.perform(mockHttpServletRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("world")))
                .andDo(document("home"));

    }

    @Test
    public void test() throws Exception {
        String actual = "{\"orderNumber\": \"4955\",\"orderVersion\": \"1\"}";
        String expect = "{\"orderNumber\": \"4956\",\"orderVersion\": \"1\"}";

       this.mockMvc
            .perform(post("/jsonCompare")
                     .accept(MediaType.APPLICATION_JSON)
               .param("actual", actual)
               .param("expect", expect))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$", hasSize(1)))
               .andExpect(jsonPath("$[0].field").value("orderNumber"))
               .andExpect(jsonPath("$[0].actual").value("4955"))
               .andExpect(jsonPath("$[0].expected").value("4956"));
    }



}
