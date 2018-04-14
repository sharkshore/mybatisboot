package com.shark.mybatisboot.common.model;

import com.shark.mybatisboot.common.enums.ErrorMsgEnum;
import io.swagger.annotations.ApiModel;
import lombok.Getter;


@Getter
@ApiModel(value = "返回结果")
public class Result<T> {

    private Boolean success;
    private String errorCode;
    private String errorMsg;
    private T data;
    private Long timeInMillis;

    public Result() {
        this.timeInMillis = System.currentTimeMillis();
    }

    public Result(T data) {
        this.success = true;
        this.data = data;
        this.timeInMillis = System.currentTimeMillis();
    }

    public Result(String errorCode, String errorMsg) {
        this.success=false;
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
        this.timeInMillis =System.currentTimeMillis();
    }

    public Result(ErrorMsgEnum errorMsgEnum) {
        this.success=false;
        this.errorCode=errorMsgEnum.getCode();
        this.errorMsg=errorMsgEnum.getMsg();
        this.timeInMillis =System.currentTimeMillis();
    }


}
