package com.bookstore.test;

import com.bookstore.pojo.User;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(123,"qwe","qwe","qwe","qweqw"));
    }

    @Test
    public void login() {
        User user = new User(null,"\"admin\"",null,"\"admin\"",null);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        String ad = "admin";
        String password = "admin";
        System.out.println(password);
        System.out.println(userService.login(new User(null,ad,null,password,null)));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("admin")
        );  }
}