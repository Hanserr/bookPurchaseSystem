package com.bookstore.dao;

import com.bookstore.pojo.User;

public interface UserDao {
    //根据用户名查询用户信息，返回null则未查到该用户
    public User queryUserByUsername(String name);
    //根据用户名和密码查询
    public User queryUserByUserNameAndPassword(String name,String password);
    //保存用户信息
    public int saveUser(User user);
}
