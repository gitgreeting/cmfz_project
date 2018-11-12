package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("/finAllBanner")
    public  @ResponseBody List<Banner>  findAllBanners(){
        List<Banner> allBanner = bannerService.findAllBanner();
        return allBanner;
    }
    @RequestMapping("/insertBanner")
    public  @ResponseBody Map<String,Object> insertBanner(MultipartFile file, HttpServletRequest request,Banner banner) {
        System.out.println("原始文件名---------------: "+file.getOriginalFilename());
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //获取上传路径  相对路径 files    获取绝对路径
            //String realPath = request.getRealPath("/files");
            String realPath = request.getSession().getServletContext().getRealPath("/back/Banner/banner_image");
            //上传
            System.out.println("-----realPath--------------"+realPath);
            file.transferTo(new File(realPath,file.getOriginalFilename()));
            System.out.println("----insert----------banner-------"+banner);
           banner.setImgPath("/back/Banner/banner_image/"+file.getOriginalFilename());
           bannerService.insertBanner(banner);
           map.put("insertBanner",true);
       }catch (Exception e){
           map.put("insertBanner",e.getMessage());
       }
        return map;
    }
    @RequestMapping("/updateBanner")
    public  @ResponseBody Map<String,Object>  updateBanner(MultipartFile file, HttpServletRequest request,Banner banner){
        System.out.println("原始文件名---------------: "+file.getOriginalFilename());
        System.out.println("----update----------banner-------"+banner);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //获取上传路径  相对路径 files    获取绝对路径
            //String realPath = request.getRealPath("/files");
            String realPath = request.getSession().getServletContext().getRealPath("/back/Banner/banner_image");
            //上传
            System.out.println("-----realPath--------------"+realPath);
            file.transferTo(new File(realPath,file.getOriginalFilename()));
            System.out.println("----insert----------banner-------"+banner);
            banner.setImgPath("/back/Banner/banner_image/"+file.getOriginalFilename());
            bannerService.updateBanner(banner);
            map.put("updateBanner",true);
        }catch (Exception e){
            map.put("updateBanner",false);
        }
        return map;
    }
    @RequestMapping("/deleteBanner")
    public  @ResponseBody  Map<String,Object>  deleteBanner(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            bannerService.deleteBanner(id);
            map.put("deleteBanner",true);
        }catch (Exception e){
            map.put("deleteBanner",false);
        }
        return map;
    }
    @RequestMapping("/queryOneBanner")
    public  @ResponseBody Banner  queryOneBanner(String id){
        System.out.println("------------id--------------"+id);
        Banner banner = bannerService.queryOneBanner(id);
        System.out.println("------banner------"+banner);
        return banner;
    }
    @RequestMapping("/removeBanners")
    public  @ResponseBody void  removeBanners(String[] ids){
        for (String str : ids){
            bannerService.deleteBanner(str);
            System.out.println("--------str----------"+str);
        }
    }
}