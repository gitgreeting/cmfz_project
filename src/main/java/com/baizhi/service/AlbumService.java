package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> finAllAlbum();
    void insertAlbum(Album album);
    List<Album> findAllAlbum();
    List<Album> showPagesAlbum(Integer page,Integer rows);
    Album queryOneAlbum(String id);
}
