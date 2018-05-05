package com.shark.springboot.common.exception;

import com.shark.springboot.common.enums.ErrorMsgEnum;
import lombok.Getter;

/**
 * 自定义Manager异常
 * user:zyd.
 * date:2017/8/28.
 * time:14:45.
 * version:1.0.0.
 */
public class ManagerException extends RuntimeException {
    @Getter
    private String errCode;

    @Getter
    private String errMsg;

    @Getter
    private ErrorMsgEnum errorMsgEnum;

    public ManagerException(String errCode) {
        this.errCode = errCode;
    }


    public ManagerException(String errCode, Throwable throwable) {
        super(throwable);
        this.errCode = errCode;
    }

    public ManagerException(String errCode, String message) {
        super(message);
        this.errCode = errCode;
        this.errMsg = message;
    }

    public ManagerException(ErrorMsgEnum errorMsgEnum) {
        super(errorMsgEnum.getMsg());
        this.errorMsgEnum=errorMsgEnum;
        this.errCode = errorMsgEnum.getCode();
        this.errMsg = errorMsgEnum.getMsg();
    }

    public ManagerException(String errCode, String message, Throwable throwable) {
        super(message, throwable);
        this.errCode = errCode;
        this.errMsg = message;
    }
}
