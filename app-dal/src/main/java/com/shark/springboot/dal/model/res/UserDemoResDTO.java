package com.shark.springboot.dal.model.res;

import com.shark.springboot.dal.model.dto.UserDemoDO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by tuze on 2018/5/5.
 */
@Data
@ApiModel(value = "UserDemoResDTO")
public class UserDemoResDTO extends UserDemoDO{
}
