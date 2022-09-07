package com.bookstore.dao.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String name) {
        String sql = "select `id`,`username`,`phone_num`,`password`,`email` from user_information where `username` = ?";
        return  queryForOne(User.class,sql,name);
    }

    @Override
    public User queryUserByUserNameAndPassword(String name, String password) {
        String sql = "select `id`,`username`,`phone_num`,`password`,`email` from user_information where username = ? and password = ? ";
        return queryForOne(User.class,sql,name,password);
    }

    @Override
    public int saveUser(User user) {
    String sql = "insert into user_information(`username`,`phone_num`,`password`,`email`) values (?,?,?,?)";
        return update(sql,user.getUsername(),user.getPhone(),user.getPassword(),user.getEmail());
    }


}
