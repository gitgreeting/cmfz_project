package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    public void insertUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setDate(new Date());
        user.setSign("1");
        user.setStatus("1");
        userDao.insert(user);
    }

    @Override
    public User queryOneUser(String id) {
        return userDao.queryOne(id);
    }

    @Override
    public void deleteUser(String id) {
        userDao.delete(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public User userLogins(String phoneNum, String password) {
        return userDao.userLogin(phoneNum,password);
    }
}