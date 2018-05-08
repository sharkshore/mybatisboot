package com.shark.springboot.dal.dao;

import com.shark.springboot.common.utils.DateUtil;
import com.shark.springboot.dal.model.dto.UserDemoDO;
import com.shark.springboot.dal.model.entity.UserDemoEntity;
import com.shark.springboot.dal.model.query.UserDemoQUERY;
import com.shark.springboot.dal.specific.UserDemoSpecification;
import com.shark.springboot.web.BootApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
        userDemoEntity.setMobile("15853269431");
        userDemoEntity.setAge(33);
        userDemoEntity.setCreatedBy("李凤");
        userDemoDao.save(userDemoEntity);
    }

    @Test
    public void update() throws Exception {

        //必须要整体插入才行, @DynamicUpdate注解对save方法不管用
        UserDemoEntity userDemoEntity = new UserDemoEntity();
        userDemoEntity.setId(24L);
        userDemoEntity.setName("王凯文22");
        userDemoEntity.setAge(35);
        userDemoDao.save(userDemoEntity);
    }


    @Test
    public void findOne() throws Exception {
        UserDemoEntity entity = userDemoDao.findOne(6L);
        log.info(entity.toString());
    }

    @Test
    public void exist() throws Exception{
        boolean exists = userDemoDao.exists(8L);

        log.info(String.valueOf(exists));
    }

    @Test
    public void count() throws Exception{
        long count = userDemoDao.count();
        log.info(String.valueOf(count));

    }


    @Test
    public void delete() throws Exception{
        userDemoDao.delete(15L);
    }


    @Test
    public void findAll() throws Exception {
        List<UserDemoEntity> all = userDemoDao.findAll();
        log.info(all.toString());
    }

    @Test
    public void findAllBySortAndPage() throws Exception {
        PageRequest pageRequest = new PageRequest(2,8, Sort.Direction.ASC,"age");
        Page<UserDemoEntity> all = userDemoDao.findAll(pageRequest);
        all.getContent().stream()
           .map(UserDemoEntity::getName)
           .forEach(System.out::println);

    }

    @Test
    public void findBySelective() throws Exception {
        UserDemoQUERY query = new UserDemoQUERY();
        query.setCreatedBy("李凤");
        query.setMinAge(30);
        Specification<UserDemoEntity> spec = UserDemoSpecification.getSpec(query);
        List<UserDemoEntity> all = userDemoDao.findAll(spec);
        all.stream()
           .map(UserDemoEntity::getId)
           .forEach(System.out::println);
    }


    @Test
    public void findBySelective2() throws Exception {
        UserDemoQUERY query = new UserDemoQUERY();

        Date bDate = DateUtil.parse("2018-04-06 08:40:00", DateUtil.settlePattern);
        Date eDate = DateUtil.parse("2018-05-08 09:40:00", DateUtil.settlePattern);
        query.setBeginCreatedAt(bDate);
        query.setEndCreatedAt(eDate);

        PageRequest pageRequest = new PageRequest(2, 3);

        Specification<UserDemoEntity> spec = UserDemoSpecification.getSpec(query);
        Page<UserDemoEntity> all = userDemoDao.findAll(spec, pageRequest);
        all.getContent().stream()
           .map(UserDemoEntity::getId)
           .forEach(System.out::println);
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