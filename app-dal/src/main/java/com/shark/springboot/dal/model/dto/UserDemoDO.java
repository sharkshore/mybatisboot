package com.shark.springboot.dal.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tuze on 2018/5/5.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "UserDemoDO")
public class UserDemoDO implements Serializable{

    private static final long serialVersionUID = -7060297326710553960L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("删除标识")
    private Integer deleteFlag;

    @ApiModelProperty("创建时间")
    private Date createdAt;

    @ApiModelProperty("创建人")
    private String createdBy;

    @ApiModelProperty("创建时间")
    private Date updatedAt;

    @ApiModelProperty("创建人")
    private String updatedBy;

}
