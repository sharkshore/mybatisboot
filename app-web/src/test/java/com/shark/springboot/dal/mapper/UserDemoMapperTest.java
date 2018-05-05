package com.shark.springboot.dal.mapper;

import com.shark.springboot.dal.model.dto.UserDemoDO;
import com.shark.springboot.dal.model.query.UserDemoQUERY;
import com.shark.springboot.web.BootApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by tuze on 2018/5/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
@Slf4j
public class UserDemoMapperTest {

    @Autowired
    UserDemoMapper mapper;

    @Test
    public void insert() throws Exception {
        UserDemoDO userDemoDO = new UserDemoDO();
        userDemoDO.setName("胡明");
        userDemoDO.setAge(22);
        userDemoDO.setMobile("15659452889");
        userDemoDO.setCreatedBy("王敏");
        mapper.insert(userDemoDO);
        log.info(userDemoDO.getId().toString());

    }

    @Test
    public void update() throws Exception {
        UserDemoDO userDemoDO = new UserDemoDO();
        userDemoDO.setId(2);
        userDemoDO.setAge(20);
        mapper.update(userDemoDO);
    }

    @Test
    public void delete() throws Exception {
        mapper.delete(2);
    }

    @Test
    public void findById() throws Exception {
        UserDemoDO demoDO = mapper.findById(2);
        log.info(demoDO.toString());

    }

    @Test
    public void findBySelective() throws Exception {
        UserDemoQUERY query = new UserDemoQUERY();
        query.setName("李晓军");
        List<UserDemoDO> bySelective = mapper.findBySelective(query);
        log.info(bySelective.toString());

    }

}