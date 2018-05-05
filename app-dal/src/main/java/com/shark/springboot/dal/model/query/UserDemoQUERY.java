package com.shark.springboot.dal.model.query;

import com.shark.springboot.dal.model.dto.UserDemoDO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * Created by tuze on 2018/5/5.
 */
@Data
@ApiModel(value = "UserDemoQUERY")
public class UserDemoQUERY extends UserDemoDO{

    private Date beginCreatedAt;
    private Date endCreatedAt;

    private Date beginUpdatedAt;
    private Date endUpdatedAt;

}
