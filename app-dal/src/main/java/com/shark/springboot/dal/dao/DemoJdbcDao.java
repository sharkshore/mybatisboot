package com.shark.springboot.dal.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by tuze on 2017/8/23.
 */
@Repository
@Slf4j
public class DemoJdbcDao {

    @Resource
    private JdbcTemplate jdbcTemplate;


    public  List<Map<String, Object>>   querySqlModel(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from SQL_MODEL");
        log.info(String.valueOf(maps));
        return maps;

    }

}
