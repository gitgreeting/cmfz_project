package com.baizhi.service;

import com.baizhi.dao.Article;
import com.baizhi.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements  ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    public void deleteArticle(String aid) {
        articleDao.delete(aid);
    }
    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public List<Article> findAllArticles() {
        return articleDao.findAll();
    }
}