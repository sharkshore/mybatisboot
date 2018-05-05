package com.shark.springboot.dal.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by tuze on 2018/5/5.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "UserDemoDO")
@Entity
@Table(name = "user_demo")
public class UserDemoEntity implements Serializable{

    private static final long serialVersionUID = -7060297326710553960L;

    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty("姓名")
    @Column(name = "name")
    private String name;

    @ApiModelProperty("手机号码")
    @Column(name = "mobile")
    private String mobile;

    @ApiModelProperty("年龄")
    @Column(name = "age")
    private Integer age;

    @ApiModelProperty("删除标识")
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    @ApiModelProperty("创建时间")
    @Column(name = "created_at")
    private Date createdAt;

    @ApiModelProperty("创建人")
    @Column(name = "created_by")
    private String createdBy;

    @ApiModelProperty("创建时间")
    @Column(name = "updated_at")
    private Date updatedAt;

    @ApiModelProperty("创建人")
    @Column(name = "updated_by")
    private String updatedBy;

}
