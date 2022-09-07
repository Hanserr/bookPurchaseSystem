package com.bookstore.dao.impl;

import com.bookstore.dao.ManagerDao;
import com.bookstore.pojo.Manager;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {
    @Override
    public Manager queryManagerByNameAndPassword(String name, String password) {
        String sql = "select `id`,`name` from manager where name = ? and password = ? ";
        return queryForOne(Manager.class,sql,name,password);
    }
}
