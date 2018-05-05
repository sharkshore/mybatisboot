package com.shark.springboot.common.utils.copy;

/**
 * <p>源对象和目标对象操作接口</p>
 *
 * @author liuhang
 * @version 1.0.0 Date: 11/30/17 Time: 10:52 AM
 */
@FunctionalInterface
public interface InjectObjectsInterface {

    /**
     * 对源对象和目标对象的操作方法
     * @param sourceObject 源对象
     * @param destinationObject 目标对象
     */
    void execute(Object sourceObject, Object destinationObject);

}
