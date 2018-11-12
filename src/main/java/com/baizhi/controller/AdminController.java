package com.baizhi.controller;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/adminLogin")
    public  @ResponseBody Map<String,Object> adminLogin(String code, String name, String password, HttpSession session){
        System.out.println("--------code-----------"+code);
        Map<String,Object> map = new HashMap<String,Object>();
        String yzm = (String)session.getAttribute("validationCode");

        System.out.println("--------yzm-----------"+yzm);
        if(code.equals(yzm)){
            map.put("code",true);
            Admin admin = adminService.loginAdmin(name,password);
            System.out.println("--------admin-----------"+admin);
            if(admin!=null){
                map.put("name",true);
                session.setAttribute("admin",admin);
                return map;
            }else{
                map.put("name",false);
                System.out.println("---------fail-----用户名或密码输入错误-----");
                return map;
            }
        }else{
            map.put("code",false);
            System.out.println("---------fail-----请输入正确的验证码---");
            return map;
        }
    }

   /*
 public String adminLogin(String code, String name, String password, HttpSession session){
        String yzm = (String)session.getAttribute("validationCode");
        if(yzm.equals(code)){
            Admin admin = adminDao.login(name, password);
            if(admin!=null){
                session.setAttribute("adminName",admin.getName());
                return "forward:/back/main/main.jsp";
            }else{
                return "redirect:/login.jsp";
            }
        }
        return "redirect:/login.jsp";
    }




    */

    @RequestMapping("/main")
    public  String loginMain(){
        return "forward:/back/main/main.jsp";
    }
    @RequestMapping("/queryOne")
    public @ResponseBody Admin queryOne(String admin_id){
        System.out.println("------admin_id-------"+admin_id);
        Admin admin = adminService.queryOneAdmin(admin_id);
        return admin;
    }
    @RequestMapping("/updatePwd")
    public @ResponseBody Map<String,Object> updatePwd(Admin admin,String oldPwd,String newPwd){
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println("-------oldPwd---------"+oldPwd);
        System.out.println("-------newPwd---------"+newPwd);
        System.out.println("------admin_id-------"+admin.getAdmin_id()+"--"+admin.getName()+"---"+admin.getPassword());
        System.out.println("-------------------admin.getPassword()----------------"+admin.getPassword());
        if(admin.getPassword().equals(oldPwd)){
            System.out.println("-------");
            Admin ad = new Admin();
            ad.setAdmin_id(admin.getAdmin_id());
            ad.setPassword(newPwd);
            adminService.updatePwd(ad);
            map.put("updateSuc",true);
            return map;
        }
        map.put("updateSuc",false);
        return map;
    }
    @RequestMapping("loginOut")
    public String  loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/back/login.jsp";
    }
}
