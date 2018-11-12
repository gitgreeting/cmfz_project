package com.baizhi.controller;

import com.baizhi.dao.Article;
import com.baizhi.entity.Guru;

import com.baizhi.service.ArticleService;
import com.baizhi.service.GuruService;
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
@RequestMapping("/Guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/finAllGuru")
    public  @ResponseBody List<Guru>  finAllGuru(){
        List<Guru> allGuru = guruService.findAllGuru();
        return allGuru;
    }
    @RequestMapping("/insertGuru")
    public  @ResponseBody Map<String,Object> insertGuru(MultipartFile guruFile, HttpServletRequest request,Guru guru){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/back/Guru/guru_image");
            System.out.println("-----realPath--------------"+realPath);
            guruFile.transferTo(new File(realPath,guruFile.getOriginalFilename()));
            guru.setHeadPic("/back/Guru/guru_image/"+guruFile.getOriginalFilename());
            guruService.insertGuru(guru);
            System.out.println("----insert----------guru-------"+guru);
            map.put("insertGuru",true);
        }catch (Exception e){
            map.put("insertGuru",false);
        }
        return map;
    }
    @RequestMapping("/updateGuru")
    public  @ResponseBody Map<String,Object>  updateGuru(MultipartFile guruFileUpd, HttpServletRequest request,Guru guru){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/back/Guru/guru_image");
            guruFileUpd.transferTo(new File(realPath,guruFileUpd.getOriginalFilename()));
            guru.setHeadPic("/back/Guru/guru_image/"+guruFileUpd.getOriginalFilename());
            guruService.updateGuru(guru);
            System.out.println("----update----------guru-------"+guru);
            map.put("updateGuru",true);
        }catch (Exception e){
            map.put("updateGuru",false);
        }
        return map;
    }
    @RequestMapping("/deleteGuru")
    public  @ResponseBody  Map<String,Object>  deleteGuru(String id){
        System.out.println("--------------delete---------------"+id);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            guruService.deleteGuru(id);
            map.put("deleteGuru",true);
        }catch (Exception e){
            map.put("deleteGuru",false);
        }
        return map;
    }
    @RequestMapping("/queryOneGuru")
    public  @ResponseBody Guru  queryOneGuru(String id){
        System.out.println("------------id--------------"+id);
        return  guruService.queryOneGuru(id);
    }
    @RequestMapping("/removeGurus")
    public  @ResponseBody void  removeBanners(String[] ids){
        for (String str : ids){
            guruService.deleteGuru(str);
            System.out.println("--------str----------"+str);
        }
    }
    /*上师文章操作*/
    @RequestMapping("/finAllArticle")
    public  @ResponseBody List<Article>  finAllArticle(){
        List<Article> allArticles = articleService.findAllArticles();
        return allArticles;
    }
   @RequestMapping("/deleteArticle")
    public  @ResponseBody Map<String,Object> deleteArticle(String artID){
       System.out.println("----artID----1-----"+artID);
       Map<String,Object> map = new HashMap<String,Object>();
        try {
            System.out.println("----artID----2-----"+artID);
            articleService.deleteArticle(artID);
            map.put("deleteArticle",true);
        }catch (Exception e){
            map.put("deleteArticle",false);
        }
        return map;
    }
}