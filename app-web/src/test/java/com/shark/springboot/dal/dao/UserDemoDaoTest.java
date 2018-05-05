package com.shark.springboot.dal.dao;

import com.shark.springboot.dal.model.entity.UserDemoEntity;
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
public class UserDemoDaoTest {

    @Autowired
    private UserDemoDao userDemoDao;


    @Test
    public void findAll(){
        List<UserDemoEntity> all = userDemoDao.findAll();
        log.info(all.toString());
    }


    @Test
    public void findByName(){

        UserDemoEntity demoEntity= userDemoDao.findByName("孔景行");
        log.info(demoEntity.toString());

    }


}