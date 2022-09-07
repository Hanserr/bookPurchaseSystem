package com.bookstore.test;

import java.lang.reflect.Method;

public class ServletTest {
    public void test1(){}
    public void test2(){}
    public void test3(){}
    public void test4(){}
    public void test5(){}
public void check(){
    Method method = null;
    try {
        method = ServletTest.class.getDeclaredMethod("test1");
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println(method);
}
}
