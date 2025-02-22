package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Course;
import com.firstTrial.demo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;

    @GetMapping("")
    public List<Course> getAllCourses(){
    	logger.info("Received request to fetch all courses");
        return courseService.getAllCourses();
    }
    @PostMapping("")
    public Course addCourse(@RequestBody Course course){
    	logger.info("Received request to add a new course");
        return courseService.addCourse(course);
    }
}
