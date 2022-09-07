package com.bookstore.service.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.dao.impl.UserDaoImpl;
import com.bookstore.pojo.User;
import com.bookstore.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
    userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
    return userDao.queryUserByUserNameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public Boolean existsUsername(String username) {
    if (userDao.queryUserByUsername(username) == null){
        //null表示空，不存在此用户名
       return false;
    }return true;
    }
}
