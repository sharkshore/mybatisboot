package com.shark.springboot.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by tuze on 2017/12/7.
 */
@RunWith(SpringRunner.class)
@Transactional(propagation=Propagation.NOT_SUPPORTED)
@JdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class JdbcBootTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT DISTINCT member_name from SQL_MODEL");
        log.info("{}", maps);
    }

}
