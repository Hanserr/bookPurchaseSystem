package com.bookstore.service;

import com.bookstore.pojo.User;

public interface UserService {
    public void registUser(User user);
    public User login(User user);
    public Boolean existsUsername(String username);
}
