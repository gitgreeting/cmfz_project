package com.baizhi;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TestBanner extends BaseTest {
    @Autowired
    private BannerService bannerService;
    @Test
    public void test1(){
        List<Banner> allBanner = bannerService.findAllBanner();
        for(Banner ban : allBanner){
            System.out.println("--------------------"+ban);
        }
    }
    @Test
    public void test2(){
        Banner banner = new Banner();
        banner.setId("106");
        banner.setTitle("啦啦啦啦");
        banner.setStatus("er");
        banner.setImgPath("123.jpg");
        banner.setCreateDate(new Date());
        bannerService.insertBanner(banner);

    }
    @Test
    public void test3(){
        Banner banner = new Banner();
        banner.setId("106");
        banner.setTitle("hahahaha");
        banner.setStatus("huihui");
        banner.setImgPath("45666.jpg");
        banner.setCreateDate(new Date());
        bannerService.updateBanner(banner);
    }
    @Test
    public void test4(){
        bannerService.deleteBanner("106");
    }
    @Test
    public void test5(){
        Banner banner = bannerService.queryOneBanner("102");
        System.out.println("-------banner-------"+banner);
    }
}
