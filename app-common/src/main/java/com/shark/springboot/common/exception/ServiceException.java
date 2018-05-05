package com.shark.springboot.common.exception;

import com.shark.springboot.common.enums.ErrorMsgEnum;
import lombok.Getter;

/**
 * 自定义业务处理异常
 * user:zyd.
 * date:2017/8/28.
 * time:14:45.
 * version:1.0.0.
 */
public class ServiceException extends RuntimeException {
    @Getter
    private String errCode;

    @Getter
    private String errMsg;

    @Getter
    private ErrorMsgEnum errorMsgEnum;

    public ServiceException(String errCode) {
        this.errCode = errCode;
    }

    public ServiceException(String errCode, Throwable throwable) {
        super(throwable);
        this.errCode = errCode;
    }

    public ServiceException(String errCode, String message) {
        super(message);
        this.errCode = errCode;
        this.errMsg = message;
    }


    public ServiceException(ErrorMsgEnum errorMsgEnum) {
        super(errorMsgEnum.getMsg());
        this.errorMsgEnum=errorMsgEnum;
        this.errCode = errorMsgEnum.getCode();
        this.errMsg = errorMsgEnum.getMsg();
    }

    public ServiceException(String errCode, String message, Throwable throwable) {
        super(message, throwable);
        this.errCode = errCode;
        this.errMsg = message;
    }
}
