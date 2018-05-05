package com.shark.springboot.web;

import com.shark.springboot.dal.dao.DemoJdbcDao;
import com.shark.springboot.model.Demo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

    @Autowired
    DemoJdbcDao demoJdbcDao;

    @Autowired
    @Qualifier("appleDemo")
	Demo demo;

	@Test
	public void contextLoads() {
		List<Map<String, Object>> maps = demoJdbcDao.querySqlModel();
		log.info(String.valueOf(maps));
	}

	@Test
	public void testBean(){
		log.info("{}", demo);
	}

}
