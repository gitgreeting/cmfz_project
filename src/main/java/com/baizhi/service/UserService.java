package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    void insertUser(User user);
    User queryOneUser(String id);
    void deleteUser(String id);
    void updateUser(User user);
    User userLogins(String phoneNum,String password);
}