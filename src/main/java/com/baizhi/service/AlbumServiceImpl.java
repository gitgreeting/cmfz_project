package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Transactional(propagation=Propagation.SUPPORTS)
    public List<Album> finAllAlbum(){
       return  albumDao.findAll();
    }

    @Override
    public void insertAlbum(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setSign(2);
        album.setPublish_date(new Date());
        albumDao.insert(album);
    }

    @Override
    public List<Album> findAllAlbum() {
        return albumDao.findAll();
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public List<Album> showPagesAlbum(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return albumDao.showPages(start,rows);
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Album queryOneAlbum(String id) {
        return albumDao.queryOne(id);
    }
}