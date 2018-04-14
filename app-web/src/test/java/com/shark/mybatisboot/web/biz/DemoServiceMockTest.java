package com.shark.mybatisboot.web.biz;

import com.shark.mybatisboot.dal.dao.DemoDao;
import com.shark.mybatisboot.dal.mapper.DemoMapper;
import com.shark.mybatisboot.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Mock测试
 * Created by tuze on 2017/11/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoServiceMockTest {


    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public DemoService demoService() {
            return new DemoService();
        }
    }

    /**
     * DemoService中所有依赖的Bean都mock出来
     */
    @MockBean
    DemoMapper demoMapper;


    /**
     * DemoService中所有依赖的Bean都mock出来
     */
    @MockBean
    DemoDao demoDao;

    @Before
    public void setUp() {

        //定义第一种行为
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        when(demoMapper.queryMemberName()).thenReturn(list);

        //定义第二种行为
        List<Map<String, Object>> list1 = new ArrayList<>();
        Map<String, Object> map = new HashMap();
        map.put("key", "value");
        list1.add(map);
        when(demoDao.querySqlModel()).thenReturn(list1);
//      when(demoDao.querySqlModel()).thenThrow(new Exception(("查询异常")));
    }


    @Autowired
    private DemoService demoService;


    @Test
    public void queryMemberName() throws Exception {
        log.info("{}", demoService.queryMemberName());
    }


}