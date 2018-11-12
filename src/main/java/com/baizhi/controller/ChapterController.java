package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.FileParm;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import com.baizhi.util.UploadUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private AlbumService albumService;
    @RequestMapping("uploadChapter")
    public @ResponseBody void addChapter(HttpServletRequest request,String id,MultipartFile addFile,Chapter chapter)throws IOException{
       FileParm uploadFile = UploadUtil.uploadFile(addFile, request, UploadUtil.FILE);
        Album album = albumService.queryOneAlbum(id);    /*获取专辑*/
        System.out.println("----------------album---------------"+album);
        album.setCount(album.getCount()+1);           /*专辑集数加1*/
        System.out.println("---------album.getCount()---------------"+album.getCount());
        chapter.setAlbum_id(id);
        chapter.setDownPath(uploadFile.getUrl());
        chapterService.insertChapter(chapter);
        System.out.println("----chapter-------------"+chapter);
        System.out.println("-----uploadFile.getOldName()----"+uploadFile.getOldName());
        System.out.println("-----uploadFile.getUrl()----"+uploadFile.getUrl());
    }
    @RequestMapping("downloadChapter")
    public @ResponseBody void downloadChapter(String url, String chapterFile, HttpServletRequest request, HttpServletResponse response)throws IOException {

        //1.根据接收的文件名去服务中指定目录读取文件
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //2.以文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, chapterFile));
        //2.1 设置响应头
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(chapterFile, "UTF-8"));
        //3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //4.使用IOUtils工具类
        IOUtils.copy(is, os);
        //5.关流
        IOUtils.closeQuietly(is);//安静关流
        IOUtils.closeQuietly(os);

    }
   @RequestMapping("insertChapter")
    public @ResponseBody Map<String,Object> insertChapter(MultipartFile file, HttpServletRequest request, Chapter chapter){
        System.out.println("原始文件名---------------: "+file.getOriginalFilename());
        System.out.println("----insert----------Chapter-------"+chapter);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/back/Chapter/music");
            System.out.println("-----realPath--------------"+realPath);
            file.transferTo(new File(realPath,file.getOriginalFilename()));
            System.out.println("----insert-----123-----chapter-------"+chapter);
            chapter.setDownPath("/back/Chapter/music/"+file.getOriginalFilename());
            chapterService.insertChapter(chapter);
            map.put("insertChapter",true);
        }catch (Exception e){
            map.put("insertChapter",false);
        }
        return map;
    }
}