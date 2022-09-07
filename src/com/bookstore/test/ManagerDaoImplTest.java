package com.bookstore.test;

import com.bookstore.dao.ManagerDao;
import com.bookstore.dao.impl.ManagerDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerDaoImplTest {
ManagerDao managerDao = new ManagerDaoImpl();
    @Test
    public void queryManagerByNameAndPassword() {
        System.out.println(managerDao.queryManagerByNameAndPassword("管理员1","testadmin"));
    }
}