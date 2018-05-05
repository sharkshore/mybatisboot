package com.shark.springboot.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shark.springboot.common.model.PageParams;
import com.shark.springboot.dal.mapper.UserDemoMapper;
import com.shark.springboot.dal.model.dto.UserDemoDO;
import com.shark.springboot.dal.model.query.UserDemoQUERY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tuze on 2018/5/5.
 */
@Component
public class UserDemoManager {

    @Autowired
    UserDemoMapper mapper;

    public int insert(UserDemoDO record) {
        return mapper.insert(record);
    }

    public void update(UserDemoDO record) {
        mapper.update(record);
    }

    public void delete(Integer id) {
        mapper.delete(id);
    }

    public UserDemoDO findById(Integer id) {
        return mapper.findById(id);
    }

    public List<UserDemoDO> findBySelective(UserDemoQUERY query) {
        return mapper.findBySelective(query);
    }

    public PageInfo<UserDemoDO> findPageBySelective(UserDemoQUERY query, PageParams pageParams) {
        PageHelper.startPage(pageParams);
        List<UserDemoDO> bySelective = mapper.findBySelective(query);
        return new PageInfo(bySelective);
    }

}
