package com.baizhi;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class TestAlbum extends BaseTest {
    @Autowired
    private AlbumService albumService;
    @Test
    public void test1(){
        List<Album> albums = albumService.finAllAlbum();
        for(Album album : albums){
            System.out.println("-----------"+album);
        }
    }
    @Test
    public void test2(){
        Album album = new Album();
        album.setAuthor("郑傻子");
        album.setCoverImg("1.jpg");
        album.setBrief("我是大傻子，啦啦啦啦啦啦啦啦");
        album.setScore("9.8");
        album.setTitle("关于傻子的论坛");
        album.setBroadCast("法师");
        album.setCount(0);
      albumService.insertAlbum(album);
    }
    @Test
    public void  test3(){
        List<Album> albums = albumService.showPagesAlbum(1,40);
        for(Album a : albums){
            System.out.println("---------a----"+a);
        }
    }
    @Test
    public void  test4(){
        Album album = albumService.queryOneAlbum("201");
        System.out.println(album);
    }
}
