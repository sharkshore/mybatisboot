package com.shark.springboot.dal.dao;

import com.shark.springboot.web.BootApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by tuze on 2017/12/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@Slf4j
public class DemoJdbcDaoTest {

    @Autowired
    DemoJdbcDao demoJdbcDao;

    @Test
    public void querySqlModel() throws Exception {
        List<Map<String, Object>> maps = demoJdbcDao.querySqlModel();
        log.info("{}", maps);
    }

}