package com.bookstore.utils;

import org.apache.commons.beanutils.BeanUtils;
import java.util.Map;

public class WebUtils {
    public static <T>T CopyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bean;
    }
    public static int ParesInt(String s,int Default) {
        try {
            return Integer.valueOf(s);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return Default;
    }
}
