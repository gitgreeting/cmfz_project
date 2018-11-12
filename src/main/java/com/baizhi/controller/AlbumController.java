package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/Album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/showPagesAlbum")
    public  @ResponseBody List<Album>  showPagesAlbum(Integer page,Integer rows){
        List<Album> albums = albumService.showPagesAlbum(page,rows);
        return albums;
    }
    @RequestMapping("/findAllAlbum")
    public  @ResponseBody List<Album>  findAllAlbum(){
        List<Album> albums = albumService.findAllAlbum();
        return albums;
    }
    @RequestMapping("/albumDetails")
    public  @ResponseBody Album  albumDetails(String id){
        System.out.println("---------id----------"+id);
        Album album = albumService.queryOneAlbum(id);
        System.out.println("-----album--------"+album);
        return album;
    }
    @RequestMapping("insertAlbum")
    public @ResponseBody Map<String,Object> insertAlbum(MultipartFile fileAlbum, HttpServletRequest request,Album album){
        System.out.println("原始文件名---------------: "+fileAlbum.getOriginalFilename());
        System.out.println("----insert----1------album-------"+album);
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/back/Album/album_image/");
            System.out.println("-----realPath--------------"+realPath);
            fileAlbum.transferTo(new File(realPath,fileAlbum.getOriginalFilename()));
            album.setCoverImg("/back/Album/album_image/"+fileAlbum.getOriginalFilename());
            albumService.insertAlbum(album);
            System.out.println("----insert----2------album-------"+album);
            List<Album> albums = albumService.showPagesAlbum(1,20);
            System.out.println("-----------albums-----------"+albums);
            map.put("insertAlbum",true);
        }catch (Exception e){
            map.put("insertAlbum",false);
        }
        return map;
    }

}