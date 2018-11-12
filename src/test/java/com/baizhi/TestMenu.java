package com.baizhi;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMenu extends  BaseTest{
    @Autowired
    private MenuService menuService;

    @Test
    public void test1(){
        List<Menu> allMenus = menuService.findAllMenus();
        for(Menu m : allMenus){
             System.out.println("--------------"+m);
        }
    }
}
