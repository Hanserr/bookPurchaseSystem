package com.bookstore.test;

import com.bookstore.service.ManagerService;
import com.bookstore.service.impl.ManagerServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerServiceImplTest {
ManagerService managerService = new ManagerServiceImpl();

    @Test
    public void login() {
        System.out.println(managerService.login("管理员1","testadmin"));
    }
}