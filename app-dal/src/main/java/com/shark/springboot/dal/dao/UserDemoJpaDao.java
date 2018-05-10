package com.shark.springboot.dal.dao;

import com.shark.springboot.dal.model.entity.UserDemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * spring dta jpa示例
 * Created by tuze on 2018/5/5.
 */
@RepositoryRestResource(collectionResourceRel = "people",path="people")
public interface UserDemoJpaDao extends JpaRepository<UserDemoEntity,Long>,JpaSpecificationExecutor<UserDemoEntity> {

    UserDemoEntity findByName(@Param("name") String name);
}
