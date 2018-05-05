package com.shark.springboot.manager.help;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;


/**
 * redis 缓存帮助类
 * @author lijing
 * @date 2017/12/13 0013.
 */
@Slf4j
@Component
public class RedisCacheHelper {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /** 默认超时时间 3day */
    private static Long DEFAULT_TIME_OUT = 259200L;

    /**
     * redis新增记录(默认超时时间 72小时)
     * @param key 新增key
     * @param obj 新增对象
     */
    public void insertObject(String key,Object obj){
       insertObject(key,obj,DEFAULT_TIME_OUT);
    }

    /**
     * redis新增记录
     * @param key 新增key
     * @param obj 新增对象
     * @param timeOut 超时时间(单位:s 负数表示永不过期)
     */
    public void insertObject(String key,Object obj,Long timeOut){
        String jsonValue = JSON.toJSONString(obj);
        if(timeOut>0) {
            redisTemplate.opsForValue().set(key, jsonValue, timeOut, TimeUnit.SECONDS);
            return;
        }
        redisTemplate.opsForValue().set(key, jsonValue);
    }


    /**
     * 获取redis记录
     * @param key 查询key
     * @param beanClass 需要转换对象的class
     * @param <T> 泛型class
     * @return 查询结果
     */
    public <T> T queryObject(String key,Class<T> beanClass ){
        String jsonValue = null;
        try {
            jsonValue = redisTemplate.opsForValue().get(key);
            if(StringUtils.isEmpty(jsonValue)){
                 return null;
            }
            return JSON.parseObject(jsonValue,beanClass);
        }catch (Exception e){
            log.error("redis 获取数据异常，获取到结果:{},转换对象:{}",jsonValue,beanClass);
            return null;
        }
    }

    /**
     * 获取redis记录
     * @param key 查询key
     * @return 查询结果
     */
    public String queryString(String key){
        String jsonValue = null;
        try {
            jsonValue = redisTemplate.opsForValue().get(key);
            if(StringUtils.isEmpty(jsonValue)){
                return null;
            }
            return jsonValue;
        }catch (Exception e){
            log.error("redis 获取数据异常，获取到结果:{}",jsonValue);
            return null;
        }
    }

    /**
     * 删除redis key
     * @param key redis key
     */
    public void deleteKey(String key){
        try {
            redisTemplate.delete(key);
        }catch (Exception e){
            log.error("redis key:{},删除异常",key);
        }
    }

    /**
     *入栈redis
     * @param key redis key
     * @param msg redis msg
     */
    public void pushObject(String key,String msg){
        try {
            redisTemplate.opsForList().leftPush(key,msg);
        }catch (Exception e){
            log.error("redis key:{},删除异常",key);
        }
    }

    /**
     *出栈redis
     * @param key redis key
     */
    public String popObject(String key){
        try {
            return redisTemplate.opsForList().rightPop(key,2, TimeUnit.SECONDS);
        }catch (Exception e){
            log.error("redis key:{},删除异常",key);
        }
        return null;
    }
}
