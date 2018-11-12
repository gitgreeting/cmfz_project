package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> findAllBanner();
    void insertBanner(Banner banner);
    void deleteBanner(String id);
    void updateBanner(Banner banner);
    Banner queryOneBanner(String id);
}