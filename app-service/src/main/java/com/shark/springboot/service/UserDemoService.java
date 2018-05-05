package com.shark.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shark.springboot.common.enums.ErrorMsgEnum;
import com.shark.springboot.common.exception.ServiceException;
import com.shark.springboot.common.utils.copy.BeanCopyUtil;
import com.shark.springboot.dal.model.dto.UserDemoDO;
import com.shark.springboot.dal.model.req.UserDemoReqDTO;
import com.shark.springboot.dal.model.res.UserDemoResDTO;
import com.shark.springboot.manager.UserDemoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by tuze on 2018/5/5.
 */
@Service
@Slf4j
public class UserDemoService {

    @Autowired
    private UserDemoManager manager;


    public int insert(UserDemoDO userDemoDO) {
        try {
            //省略一系列字段封装和转换
            return manager.insert(userDemoDO);
        } catch (Exception e) {
            log.error("参数:{}", userDemoDO, e);
            throw new ServiceException(ErrorMsgEnum.E0001);
        }
    }

    public void update(UserDemoDO userDemoDO) {
        try {
            //省略一系列字段封装和转换
            manager.update(userDemoDO);
        } catch (Exception e) {
            log.error("参数:{}", userDemoDO, e);
            throw new ServiceException(ErrorMsgEnum.E0001);
        }
    }

    /**
     * 支持批量删除
     */
    public void delete(UserDemoReqDTO reqDTO) {
        try {
            Set<Integer> deleteIds = reqDTO.getDeleteIds();
            if (deleteIds != null && deleteIds.size() > 0) {
                deleteIds.forEach(id -> {
                    manager.delete(id);
                });
            }
        } catch (Exception e) {
            log.error("参数:{}", reqDTO, e);
            throw new ServiceException(ErrorMsgEnum.E0001);
        }
    }

    /**
     * 查询结果封装
     * @param id
     * @return
     */
    public UserDemoResDTO findById(Integer id) {
        try {
            UserDemoDO demoDO = manager.findById(id);
            UserDemoResDTO userDemoResDTO = BeanCopyUtil.objConvert(demoDO, UserDemoResDTO.class);
            return userDemoResDTO;
        } catch (Exception e) {
            log.error("参数:{}", id, e);
            throw new ServiceException(ErrorMsgEnum.E0001);
        }
    }

    /**
     * 分页动态查询
     *
     * @param reqDTO
     * @return
     */
    public PageInfo<UserDemoResDTO> findPageBySelective(UserDemoReqDTO reqDTO) {
        try {
            if(reqDTO.getPageParams() !=null){
                PageHelper.startPage(reqDTO.getPageParams());
            }
            List<UserDemoDO> userDemoDOS = manager.findBySelective(reqDTO);
            List<UserDemoResDTO> userDemoResDTOS = userDemoDOS.stream()
                    .map(demo -> BeanCopyUtil.objConvert(demo, UserDemoResDTO.class))
                    .collect(Collectors.toList());
            return new PageInfo(userDemoResDTOS);
        } catch (Exception e) {
            log.error("参数:{}", reqDTO, e);
            throw new ServiceException(ErrorMsgEnum.E0001);
        }
    }

}
