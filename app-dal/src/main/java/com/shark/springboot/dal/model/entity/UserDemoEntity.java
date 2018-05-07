package com.shark.springboot.dal.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

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
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class UserDemoEntity implements Serializable{

    private static final long serialVersionUID = -7060297326710553960L;

    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty("姓名")
    @Column
    //当属性名与数据库名符合命名规则时,可以不需要指定name
    private String name;

    @ApiModelProperty("手机号码")
    @Column(name = "mobile")
    private String mobile;

    @ApiModelProperty("年龄")
    @Column(name = "age")
    private Integer age;

    @ApiModelProperty("删除标识")
    @Column(name = "delete_flag",insertable = false)
    //设置默认值
    private Integer deleteFlag;

    @ApiModelProperty("创建时间")
    @Column(name = "created_at")
    //设置默认值
    private Date createdAt;

    @ApiModelProperty("创建人")
    @Column
    //当属性名与数据库名符合命名规则时,可以不需要指定name
    private String createdBy;

    @ApiModelProperty("创建时间")
    @Column(name = "updated_at")
    private Date updatedAt;

    @ApiModelProperty("创建人")
    @Column(name = "updated_by")
    private String updatedBy;

}
