package com.firstTrial.demo.Services;

import com.firstTrial.demo.Controllers.CourseController;
import com.firstTrial.demo.Entities.Course;
import com.firstTrial.demo.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CourseService {
    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        logger.info("Fetching all courses from the database");
        try {
            List<Course> courses = courseRepository.findAll();
            if (courses.isEmpty()) {
                logger.error("failed to fetch course");
            }
            return courses;
        } catch (Exception e) {
            logger.error("Error fetching courses: {}", e.getMessage(), e);
            throw e;
        }
    }

    public Course addCourse(Course course){
        logger.info("Attempting to add a new course");
        try {
            Course savedCourse = courseRepository.save(course);
            logger.info("Course added successfully with ID: {}", savedCourse);
            return savedCourse;
        } catch (Exception e) {
            logger.error("Error adding course: {}", e.getMessage(), e);
            throw e;
        }
    }
}
