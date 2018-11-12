package com.baizhi.service;

import com.baizhi.dao.CourseDao;
import com.baizhi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseServiceImpl implements  CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> findAllCourse() {
        return courseDao.findAll();
    }

    @Override
    public void deleteCourse(String cid) {
        courseDao.delete(cid);
    }

    @Override
    public void insertCourse(Course course) {
        course.setId(UUID.randomUUID().toString());
        course.setCreateDate(new Date());
        course.setC_user_id("d1d90da3-e83d-42c1-b478-e0756a8a08f8");
        courseDao.insert(course);
    }
}