package com.shark.springboot.web.controller;

import com.github.pagehelper.PageInfo;
import com.shark.springboot.common.enums.ErrorMsgEnum;
import com.shark.springboot.common.exception.ServiceException;
import com.shark.springboot.common.model.JsrGroup;
import com.shark.springboot.common.model.Result;
import com.shark.springboot.dal.model.dto.UserDemoDO;
import com.shark.springboot.dal.model.req.UserDemoReqDTO;
import com.shark.springboot.dal.model.res.UserDemoResDTO;
import com.shark.springboot.service.UserDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tuze on 2018/5/5.
 */

@CrossOrigin
@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "user", description = "User测试", consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserDemoController {

    @Autowired
    UserDemoService userDemoService;

    @ApiOperation(value = "添加user", notes = "添加user", response = Result.class)
    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Integer> insert(@Validated({JsrGroup.Add.class}) @RequestBody UserDemoDO record) {
        try {
            int id = userDemoService.insert(record);
            log.info("请求参数:{},操作成功", record);
            return new Result<>(id);
        } catch (ServiceException se) {
            return new Result(se.getErrorMsgEnum());
        } catch (Exception e) {
            log.error("请求参数:{}", record, e);
            return new Result(ErrorMsgEnum.E0001);
        }
    }


    @ApiOperation(value = "修改user", notes = "修改user", response = Result.class)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> update(@Validated({JsrGroup.Update.class}) @RequestBody UserDemoDO record) {
        try {
            userDemoService.update(record);
            log.info("请求参数:{},操作成功", record);
            return new Result<>("修改成功");
        } catch (ServiceException se) {
            return new Result(se.getErrorMsgEnum());
        } catch (Exception e) {
            log.error("请求参数:{}", record, e);
            return new Result(ErrorMsgEnum.E0001);
        }
    }


    @ApiOperation(value = "删除user", notes = "删除user", response = Result.class)
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> delete(@Validated({JsrGroup.Delete.class}) @RequestBody UserDemoReqDTO record) {
        try {
            userDemoService.delete(record);
            log.info("请求参数:{},操作成功", record);
            return new Result<>("删除成功");
        } catch (ServiceException se) {
            return new Result(se.getErrorMsgEnum());
        } catch (Exception e) {
            log.error("请求参数:{}", record, e);
            return new Result(ErrorMsgEnum.E0001);
        }
    }


    @ApiOperation(value = "查询user", notes = "查询user", response = Result.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<UserDemoResDTO> select(@PathVariable Integer id) {
        try {
            UserDemoResDTO demoResDTO = userDemoService.findById(id);
            log.info("请求参数:{},操作成功", id);
            return new Result<>(demoResDTO);
        } catch (ServiceException se) {
            return new Result(se.getErrorMsgEnum());
        } catch (Exception e) {
            log.error("请求参数:{}", id, e);
            return new Result(ErrorMsgEnum.E0001);
        }
    }


    @ApiOperation(value = "分页动态查询user", notes = "分页动态查询user", response = Result.class)
    @RequestMapping(value = "/select", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<PageInfo<UserDemoResDTO>> selectByPage(@Validated({JsrGroup.Get.class}) @RequestBody UserDemoReqDTO record) {
        try {
            PageInfo<UserDemoResDTO> pages = userDemoService.findPageBySelective(record);
            log.info("请求参数:{},操作成功", record);
            return new Result<>(pages);
        } catch (ServiceException se) {
            return new Result(se.getErrorMsgEnum());
        } catch (Exception e) {
            log.error("请求参数:{}", record, e);
            return new Result(ErrorMsgEnum.E0001);
        }
    }

}
