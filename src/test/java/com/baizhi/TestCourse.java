package com.baizhi;

import com.baizhi.entity.Course;
import com.baizhi.entity.User;
import com.baizhi.service.CourseService;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestCourse extends BaseTest {
    @Autowired
    private CourseService courseService;
    @Test
    public void test1(){
        List<Course> allCourse = courseService.findAllCourse();
        for(Course c :allCourse){
            System.out.println(c);
        }
    }
    @Test
    public void test2(){
        Course course = new Course();
        course.setTitle("王傻子");
        course.setMarking("1123");
       courseService.insertCourse(course);
    }
    @Test
    public void test3(){
        courseService.deleteCourse("3bfc9440-7841-45be-8956-62ae2ad433cc");
    }
}