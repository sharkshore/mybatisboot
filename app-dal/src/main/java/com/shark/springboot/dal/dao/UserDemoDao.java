package com.shark.springboot.dal.dao;

import com.shark.springboot.dal.model.entity.UserDemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by tuze on 2018/5/5.
 */
public interface UserDemoDao extends JpaRepository<UserDemoEntity,Long>,JpaSpecificationExecutor<UserDemoEntity> {

    UserDemoEntity findByName(String name);
}
