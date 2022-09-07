package com.bookstore.dao;

import com.bookstore.pojo.Manager;

public interface ManagerDao {
    public Manager queryManagerByNameAndPassword(String name, String password);
}
