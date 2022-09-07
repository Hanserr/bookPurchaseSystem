package com.bookstore.service.impl;

import com.bookstore.dao.ManagerDao;
import com.bookstore.dao.impl.ManagerDaoImpl;
import com.bookstore.pojo.Manager;
import com.bookstore.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();
    @Override
    public Manager login(String name, String password) {
        return managerDao.queryManagerByNameAndPassword(name,password);
    }
}
