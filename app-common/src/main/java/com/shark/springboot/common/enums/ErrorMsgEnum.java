package com.shark.springboot.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMsgEnum {


    /** 显示前端的错误 */
    E0001("E0001", "系统错误"),
    E0002("E0002", "登陆失效,请重新登陆"),
    E0003("E0003", "无法获取您的有效信息"),


    E0011("E0011", "微信服务器验证错误"),
    E0022("E0022", "存储到redis失败"),

    E0041("E0041", "获取商户信息失败"),
    E0042("E0042", "获取用户信息失败"),
    E0043("E0043", "获取商户或者用户信息失败"),


    E0300("E0300", "参数错误"),
    E0301("E0301", "缺少参数"),


    E0400("E0400", "数据错误"),
    E0401("E0401", "数据库存在脏数据"),


    ;

    private String code;
    private String msg;
}
