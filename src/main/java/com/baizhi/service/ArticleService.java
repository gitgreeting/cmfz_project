package com.baizhi.service;

import com.baizhi.dao.Article;

import java.util.List;

public interface ArticleService {
    void deleteArticle(String aid);
    List<Article> findAllArticles();
}
