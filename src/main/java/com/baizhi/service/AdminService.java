package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    Admin loginAdmin(String name,String password);
    void updatePwd(Admin admin);
    Admin queryOneAdmin(String admin_id);
}
