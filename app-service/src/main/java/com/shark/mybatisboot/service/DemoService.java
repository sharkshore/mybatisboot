package com.shark.mybatisboot.service;

import com.shark.mybatisboot.dal.dao.DemoDao;
import com.shark.mybatisboot.dal.mapper.DemoMapper;
import com.shark.mybatisboot.dal.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by tuze on 2017/8/23.
 */
@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private DemoDao demoDao;

    public List<String> queryMemberName(){
        return demoMapper.queryMemberName();
    }

    public  List<Map<String, Object>>   selectBySelective(Demo demo){
        return demoDao.querySqlModel();
    }

}
