package com.baizhi.service;

import com.baizhi.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse();
    void deleteCourse(String cid);
    void insertCourse(Course course);

}
