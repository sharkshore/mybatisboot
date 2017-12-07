package com.shark.mybatisboot.biz;

import com.shark.mybatisboot.dao.DemoDao;
import com.shark.mybatisboot.dao.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by tuze on 2017/8/23.
 */
@Service
public class DemoService implements IDemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private DemoDao demoDao;

    public List<String> queryMemberName(){
        return demoMapper.queryMemberName();
    }

    public  List<Map<String, Object>>   querySqlModel(){
        return demoDao.querySqlModel();
    }

    @Override
    public List<Map> queryOperation() {
        return demoMapper.queryOperation();
    }

    @Override
    public List<Map> querySqlModelEntity() {
        return demoMapper.querySqlModelEntity();
    }

}
