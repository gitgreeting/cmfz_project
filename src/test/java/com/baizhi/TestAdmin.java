package com.baizhi;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestAdmin extends BaseTest {
    @Autowired
    private AdminService adminService;
    @Test
    public void test1(){
        Admin admin = adminService.loginAdmin("小凳子", "123123");
        System.out.println("-------------"+admin);
    }
    @Test
    public void test2(){
        Admin admin = new Admin();
        admin.setAdmin_id("10086");
        admin.setPassword("123456");
        adminService.updatePwd(admin);
        System.out.println(adminService.loginAdmin("小凳子", "123456"));
    }
    @Test
    public void test3(){
        Admin admin = adminService.queryOneAdmin("10086");
        System.out.println("----------------"+admin);
    }
}
