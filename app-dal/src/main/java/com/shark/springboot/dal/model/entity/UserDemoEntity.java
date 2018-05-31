package com.shark.springboot.dal.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@SelectBeforeUpdate
@DynamicInsert
@DynamicUpdate
//逻辑删除
@SQLDelete(sql = "update user_demo set delete_flag=1 where id=?")
//只查询delete_flag=0的
@Where(clause = "delete_flag=0")
public class UserDemoEntity implements Serializable {

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
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @ApiModelProperty("创建人")
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @ApiModelProperty("创建时间")
    @Column(name = "updated_at")
    private Date updatedAt;

    @ApiModelProperty("创建人")
    @Column(name = "updated_by")
    private String updatedBy;

}
