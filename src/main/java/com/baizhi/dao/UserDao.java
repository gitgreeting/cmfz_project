package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.util.BaseDao;

public interface UserDao extends BaseDao<User> {
    User userLogin(String username,String password);
}
