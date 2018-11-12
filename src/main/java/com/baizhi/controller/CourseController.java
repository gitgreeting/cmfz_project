package com.baizhi.controller;

import com.baizhi.entity.Course;
import com.baizhi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAllCourse")
    public @ResponseBody  List<Course>  findAllCourses(){
      return  courseService.findAllCourse();
    }
    @RequestMapping("/deleteCourse")
    public @ResponseBody  Map<String,Object>  deleteCourse(String courseId){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
         courseService.deleteCourse(courseId);
            map.put("deleteCourse",true);
        }catch (Exception e){
            map.put("deleteCourse",false);
        }
        return map;
    }
    @RequestMapping("/insertCourse")
    public @ResponseBody  Map<String,Object>  insertCourse(Course course){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            courseService.insertCourse(course);
            map.put("insertCourse",true);
        }catch (Exception e){
            map.put("insertCourse",false);
        }
        return map;
    }
}