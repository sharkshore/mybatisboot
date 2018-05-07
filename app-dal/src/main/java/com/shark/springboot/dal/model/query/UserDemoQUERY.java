package com.shark.springboot.dal.model.query;

import com.shark.springboot.dal.model.dto.UserDemoDO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by tuze on 2018/5/5.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "UserDemoQUERY")
public class UserDemoQUERY extends UserDemoDO{

    private Integer minAge;
    private Integer maxAge;

    private Date beginCreatedAt;
    private Date endCreatedAt;

    private Date beginUpdatedAt;
    private Date endUpdatedAt;

}
