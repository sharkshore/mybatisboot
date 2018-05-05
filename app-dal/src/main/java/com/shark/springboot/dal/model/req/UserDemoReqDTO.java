package com.shark.springboot.dal.model.req;

import com.shark.springboot.common.model.PageParams;
import com.shark.springboot.dal.model.query.UserDemoQUERY;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * Created by tuze on 2018/5/5.
 */
@Slf4j
@Data
@ApiModel(value = "UserDemoReqDTO")
public class UserDemoReqDTO extends UserDemoQUERY{

    Set<Integer> deleteIds;

    PageParams pageParams;
}
