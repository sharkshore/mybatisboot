package com.shark.springboot.dal.dao;

import com.shark.springboot.dal.model.entity.UserDemoEntity;
import com.shark.springboot.dal.model.resultset.GroupCreatedBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

/**
 * spring dta jpa示例
 * Created by tuze on 2018/5/5.
 */

//该注解用于直接生成REST接口,如果不需要该接口,可以直接关闭
@RepositoryRestResource(collectionResourceRel = "people",path="people")
public interface UserDemoJpaDao extends JpaRepository<UserDemoEntity,Long>,JpaSpecificationExecutor<UserDemoEntity> {

    UserDemoEntity findByName( String name);

    @Query(value = "SELECT count(u) as groupCount, u.createdBy as createdBy from UserDemoEntity u  GROUP BY u.createdBy")
    List<GroupCreatedBy> groupByCreatedBy();

    @Query("SELECT u from UserDemoEntity u WHERE u.createdAt between :beginCreatedAt and :endCreatedAt")
    Page<UserDemoEntity> findByCreatedAt(@Param("beginCreatedAt") Date beginCreatedAt ,@Param("endCreatedAt") Date endCreatedAt,Pageable pageable);

    Page<UserDemoEntity> findByCreatedBy(String createdBy, Pageable pageable);


}
