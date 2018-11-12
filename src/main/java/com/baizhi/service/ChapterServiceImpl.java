package com.baizhi.service;
import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;

    @Override
    public void insertChapter(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapter.setSign(1);
        chapter.setUploadTime(new Date());
        chapterDao.insert(chapter);
    }
}
