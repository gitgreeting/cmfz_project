package com.baizhi;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestChapter extends BaseTest{
    @Autowired
    private ChapterService chapterService;
    @Test
    public void test1(){
        Chapter chapter = new Chapter();
        chapter.setTitle("密乐日巴道哥集 01");
        chapter.setDuration("4:55");
        chapter.setDownPath("haha -道哥集 01 .mp3");
        chapter.setAlbum_id("203");
        chapterService.insertChapter(chapter);
    }
}
