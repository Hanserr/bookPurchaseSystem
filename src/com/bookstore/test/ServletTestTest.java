package com.bookstore.test;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ServletTestTest {

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
    }

    @Test
    public void test4() {
    }

    @Test
    public void test5() {
    }

    @Test
    public void check() {
        Method method = null;
        try {
            method = ServletTest.class.getDeclaredMethod("test1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(method);
    }
}