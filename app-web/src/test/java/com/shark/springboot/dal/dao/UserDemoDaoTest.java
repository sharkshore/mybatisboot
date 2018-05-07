package com.shark.springboot.dal.dao;

import com.shark.springboot.dal.model.dto.UserDemoDO;
import com.shark.springboot.dal.model.entity.UserDemoEntity;
import com.shark.springboot.web.BootApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;


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
    public void save() throws Exception {

        UserDemoEntity userDemoEntity = new UserDemoEntity();
        userDemoEntity.setName("王凯文");
        userDemoEntity.setMobile("17853269431");
        userDemoEntity.setAge(33);
        userDemoEntity.setCreatedBy("李凤");
        userDemoEntity.setCreatedAt(new Date());
        userDemoEntity.setDeleteFlag(0);
        userDemoDao.save(userDemoEntity);

    }

    @Test
    public void findAll() throws Exception {
        List<UserDemoEntity> all = userDemoDao.findAll();
        log.info(all.toString());
    }


    @Test
    public void findByName() throws Exception {

        UserDemoEntity demoEntity = userDemoDao.findByName("孔景行");
        log.info(demoEntity.toString());

    }

    @Test
    public void test() throws Exception {
        Function<Integer, Integer> f = m -> m + 1;

        Integer apply = f.apply(2);
        log.info(apply.toString());


    }

}