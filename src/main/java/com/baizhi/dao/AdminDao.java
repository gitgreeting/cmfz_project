package com.baizhi.dao;

import com.baizhi.entity.Admin;
import com.baizhi.util.BaseDao;
import org.apache.ibatis.annotations.Param;

public interface AdminDao extends BaseDao<Admin> {
    Admin login(@Param("name") String name, @Param("password") String password);
}
