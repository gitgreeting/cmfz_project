package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestUser extends BaseTest {
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        List<User> allUsers = userService.findAllUsers();
        for(User u : allUsers){
            System.out.println("---user--------------"+u);
        }
    }
    @Test
    public void test2(){
        User user = new User();
        user.setNickName("小和尚");
        user.setUserName("小小和尚");
        user.setProvince("北京");
        user.setCity("朝阳");
        user.setPassword("123123");
        user.setGender("男");
        user.setHeadPic("1.jpg");
        user.setPhoneNum("18912347834");
       userService.insertUser(user);
    }
    @Test
    public void test3(){
        User user = userService.queryOneUser("1008611");
        System.out.println(user);
    }
    @Test
    public void test4(){
        userService.deleteUser("aa1a85bb-86f1-42ff-9dbe-1e5a3d9aa0ed");
    }
    @Test
    public void test5(){
        User user = new User();
        user.setId("aa1a85bb-86f1-42ff-9dbe-1e5a3d9aa0ed");
        user.setPassword("000000");
        user.setProvince("云南");
        user.setUserName("大和尚");
        userService.updateUser(user);
    }
}