package com.shark.springboot.common.utils.copy;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * 对象拷贝工具类
 * <p>
 * 1、基于Dozer转换对象的类型
 * 2、基于Dozer将对象A的值拷贝到对象B中
 * 3、List集合转换其他对象集合
 * </p>
 * @author xiewenda Date: 2016/3/22 ProjectName: commons Version: 1.0
 */
public class BeanCopyUtil {

    /**
     * 持有Dozer单例
     */
    private static volatile DozerBeanMapper dozer = null;

    static {
        if (dozer == null) {
            synchronized (BeanCopyUtil.class) {
                if (dozer == null) {
                    List<String> mappingFileList = new ArrayList<>();
                    mappingFileList.add("dozerBeanMapping.xml");
                    dozer = new DozerBeanMapper(mappingFileList);
                }
            }
        }
    }

    /**
     * 基于Dozer转换对象的类型
     *
     * @param obj   需要转换的对象
     * @param toObj 转换后的类型
     * @param <T>   返回对象类型泛型
     * @return 返回对象
     */
    public static <T> T objConvert(Object obj, Class<T> toObj) {
        if (null == obj) {
            return null;
        }
        return dozer.map(obj, toObj);
    }

    /**
     * 基于Dozer将对象A的值拷贝到对象B中
     *
     * @param source 需要转换的对象
     * @param toObj  转换后对象类型
     */
    public static void copy(Object source, Object toObj) {
        if (null != source) {
            dozer.map(source, toObj);
        }
    }

    /**
     * List集合转换其他对象集合
     *
     * @param collection 需要转换List集合
     * @param toObj      转换后的对象类型
     * @param <T>        转换后的对象类型
     * @return 转换后的List集合
     */
    public static <T> List<T> convertList(Collection<?> collection, Class<T> toObj) {
        if (collection == null) {
            return null;
        }
        if (toObj == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        for (Object obj : collection) {
            list.add(dozer.map(obj, toObj));
        }
        return list;
    }

    /**
     * 对象带值转换
     *
     * @param sourceList            需要转换的集合
     * @param toObj                 转换后对象类型
     * @param injectObjectInterface 在copy过程中需要对原集合内目标对象额外赋值的实现
     * @return 返回对象
     */
    public static <T> List<T> mapList(Collection sourceList, Class<T> toObj, InjectObjectInterface injectObjectInterface) {
        if (null == sourceList) {
            return new ArrayList<T>();
        }
        List<T> destinationList = new ArrayList<T>();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, toObj);
            injectObjectInterface.execute(destinationObject);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * @param sourceList             需要转换的集合
     * @param toObj                  转换后的对象类型
     * @param injectObjectsInterface 在copy过程中，需要集合内对源对象和目标对象额外赋值的实现
     * @param <T>
     * @return
     */
    public static <T> List<T> mapList(Collection sourceList, Class<T> toObj, InjectObjectsInterface injectObjectsInterface) {
        if (null == sourceList) {
            return new ArrayList<T>();
        }
        List<T> destinationList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, toObj);
            injectObjectsInterface.execute(sourceObject, destinationObject);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

}