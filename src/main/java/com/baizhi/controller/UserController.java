package com.baizhi.controller;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Counter;
import com.baizhi.entity.User;
import com.baizhi.service.CounterService;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CounterService counterService;
    @RequestMapping("/findAllUsers")
    public @ResponseBody List<User> findAllUsers(){
        return  userService.findAllUsers();
    }
    @RequestMapping("/deleteUser")
    public @ResponseBody Map<String,Object> deleteUser(String deleteId){
        System.out.println("------deleteId----------"+deleteId);
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            userService.deleteUser(deleteId);
            System.out.println("------success----------");
            map.put("deleteUser",true);
        }catch (Exception e){
            map.put("deleteUser",false);
        }
        return  map;
    }
    @RequestMapping("/insertUserBack")
    public @ResponseBody Map<String,Object> insertUserBack(MultipartFile userfile, HttpServletRequest request, User user){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            String realPath = request.getSession().getServletContext().getRealPath("/back/User/user_image");
            userfile.transferTo(new File(realPath,userfile.getOriginalFilename()));
            user.setHeadPic("/back/User/user_image/"+userfile.getOriginalFilename());
            userService.insertUser(user);
            System.out.println("------user----------"+user);
            map.put("insertUserBack",true);
        }catch (Exception e){
            map.put("insertUserBack",false);
        }
        return map;
    }
    @RequestMapping("/insertUser")
    public String insertUser(MultipartFile userfile, HttpServletRequest request, User user){
        System.out.println("------user----------"+user);
        try{
            String realPath = request.getSession().getServletContext().getRealPath("/back/User/user_image");
            userfile.transferTo(new File(realPath,userfile.getOriginalFilename()));
            user.setHeadPic("/back/User/user_image/"+userfile.getOriginalFilename());
            userService.insertUser(user);
            System.out.println("------user----------"+user);
            return  "/User";
        }catch (Exception e){
            return  "/user_register";
        }
    }
    @RequestMapping("/updateUser")
    public @ResponseBody Map<String,Object> updateUser(User user){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            userService.updateUser(user);
            map.put("updateUser",true);
        }catch (Exception e){
            map.put("updateUser",false);
        }
        return  map;
    }

    @RequestMapping("/queryOneUser")
    public @ResponseBody User queryOneUser(String userId){
         return  userService.queryOneUser(userId);
    }
    /*计数器方法*/
    @RequestMapping("/deleteCounter")
    public @ResponseBody  Map<String,Object> deleteCounter(String delcounterId){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            counterService.deleteCounter(delcounterId);
            map.put("deleteCounter",true);
        }catch (Exception e){
            map.put("deleteCounter",false);
        }
        return  map;
    }
    @RequestMapping("/queryOneCounter")
    public @ResponseBody  Counter queryOneCounter(String counterId){
        return  counterService.queryOneCounter(counterId);
    }
    @RequestMapping("/updateCounter")
    public @ResponseBody Map<String,Object> updateCounter(Counter counter){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
           counterService.updateCounter(counter);
            map.put("updateCounter",true);
        }catch (Exception e){
            map.put("updateCounter",false);
        }
        return  map;
    }
    @RequestMapping("/addCounter")
    public @ResponseBody Map<String,Object> addCounter(Counter counter){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            counterService.addCounter(counter);
            map.put("addCounter",true);
        }catch (Exception e){
            map.put("addCounter",false);
        }
        return  map;
    }
    @RequestMapping("/queryUser")
    public String queryUserLogin(String phoneNum, String password, HttpSession session){
        User user = userService.userLogins(phoneNum, password);
        if(user!=null){
            session.setAttribute("user",user);
            return "/loginSuc";
        }
        return "/User";
    }
}