package com.shark.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by tuze on 2017/12/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@Slf4j
public class DemoControllerTest {

    @Autowired
    private MockMvc mvc;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void helloWithMvc() throws Exception {
        mvc.perform(get("/hello").contentType(MediaType.ALL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("tuze")));

    }

    @Test
    public void helloWithRestTemplate() throws Exception {
        String forObject = this.restTemplate.getForObject("http://localhost:" + port + "/mybatisboot/hello", String.class);
        assertTrue(forObject.contains("hello,world"));
    }

    @Test
    public void helloWithRelativePath() throws Exception {
        String forObject = this.restTemplate.getForObject( "/hello", String.class);
        assertTrue(forObject.contains("hello,world"));
    }

    @Test
    public void testparam() throws Exception {

    }

    @Test
    public void queryMemberName() throws Exception {

    }

    @Test
    public void querySqlModel() throws Exception {

    }

}