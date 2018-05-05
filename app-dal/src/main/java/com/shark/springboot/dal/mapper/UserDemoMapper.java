package com.shark.springboot.dal.mapper;

import com.shark.springboot.dal.model.dto.UserDemoDO;
import com.shark.springboot.dal.model.query.UserDemoQUERY;

import java.util.List;

/**
 * Created by tuze on 2018/5/5.
 */
public interface UserDemoMapper {

    int insert(UserDemoDO record);

    int update(UserDemoDO record);

    void delete(Integer id);

    UserDemoDO findById(Integer id);

    List<UserDemoDO> findBySelective(UserDemoQUERY query);
}
