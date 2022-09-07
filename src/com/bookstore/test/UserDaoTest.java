package com.bookstore.test;

import com.bookstore.dao.UserDao;
import com.bookstore.dao.impl.UserDaoImpl;
import com.bookstore.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao user = new UserDaoImpl();
        if(user.queryUserByUsername("admin123") != null){
            System.out.println("用户已存在");
        }else{
            System.out.println("未查到");
        }
    }

    @Test
    public void queryUserByUserNameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryUserByUserNameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误");
        }else {
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null,"test","123123","asdad","asdad")));
    }
}