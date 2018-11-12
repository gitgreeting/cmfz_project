package com.baizhi;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Guru;
import com.baizhi.service.BannerService;
import com.baizhi.service.GuruService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TestGuru extends BaseTest {
    @Autowired
    private GuruService guruService;
    @Test
    public void test1(){
        Guru guru = new Guru();

        guru.setName("郑傻子");
        guru.setGender("人妖");
        guru.setHeadPic("12.jpg");
        guruService.insertGuru(guru);
    }
    @Test
    public void test2(){
        Guru guru = new Guru();
       /* guru.setHeadPic("666.jpg");*/
        guru.setName("啦啦啦啦");
      /*  guru.setGender("女");*/
        guru.setId("64229c24-1b3a-4434-90f3-fa2347d08fd0");
        guruService.updateGuru(guru);
    }
    @Test
    public void test3(){

        Guru guru = guruService.queryOneGuru("5");
        System.out.println(guru);
    }
    @Test
    public void test4(){
        List<Guru> allGuru = guruService.findAllGuru();
        for (Guru guru : allGuru){
            System.out.println("---------guru----------"+guru);
        }
    }
    @Test
    public void test5(){
        guruService.deleteGuru("522c6b46-a0f9-4245-aba0-a9caedd82f1c");

    }
}
