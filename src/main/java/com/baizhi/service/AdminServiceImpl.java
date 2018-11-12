package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Admin loginAdmin(String name, String password) {
        return adminDao.login(name,password);
    }

    @Override
    public void updatePwd(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public Admin queryOneAdmin(String admin_id) {
        return adminDao.queryOne(admin_id);
    }
}
