package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Transactional(propagation=Propagation.SUPPORTS)
    public List<Banner> findAllBanner(){
        List<Banner> banners = bannerDao.findAll();
        return banners;
    }

    @Override
    public void insertBanner(Banner banner) {
        banner.setId(UUID.randomUUID().toString());
        banner.setCreateDate(new Date());
        bannerDao.insert(banner);
    }

    @Override
    public void deleteBanner(String id) {
        bannerDao.delete(id);
    }

    @Override
    public void updateBanner(Banner banner) {
        banner.setCreateDate(new Date());
        bannerDao.update(banner);
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Banner queryOneBanner(String id) {
        return bannerDao.queryOne(id);
    }
}