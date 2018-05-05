package com.shark.springboot.common.utils.copy;

/**
 * <p>补充信息接口</p>
 *
 * @author liuhang
 * @version 1.0.0 Date: 11/30/17 Time: 10:41 AM
 */
@FunctionalInterface
public interface InjectObjectInterface {

    /**
     * 对目标对象的操作方法
     * @param destinationObject 目标对象
     */
    void execute(Object destinationObject);
}
