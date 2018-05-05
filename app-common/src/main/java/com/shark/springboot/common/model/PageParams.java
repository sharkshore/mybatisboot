package com.shark.springboot.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by tuze on 2017/11/24.
 */
@ApiModel(value = "分页参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParams implements Serializable{

    /** 串行版本ID*/
    private static final long serialVersionUID = -120953557496316923L;

    @ApiModelProperty(value = "第几页")
    private int pageNum;

    @ApiModelProperty(value = "每页显示几行")
    private int pageSize;

}
