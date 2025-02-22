package com.firstTrial.demo.Services;

import com.firstTrial.demo.Entities.Teacher;
import com.firstTrial.demo.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class TeacherService {
    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        logger.info("Fetching all teachers from the database");
        try {
            List<Teacher> teachers = teacherRepository.findAll();
            if (teachers.isEmpty()) {
                logger.error("failed to fetch teachers");
            }
            return teachers;
        } catch (Exception e) {
            logger.error("Error fetching teachers: {}", e.getMessage(), e);
            throw e;
        }
    }

    public Teacher addTeacher(Teacher teacher) {
        logger.info("Attempting to add a new teacher");
        try {
            Teacher savedTeacher = teacherRepository.save(teacher);
            logger.info("Teacher added successfully");
            return savedTeacher;
        } catch (Exception e) {
            logger.error("Error adding teacher: {}", e.getMessage(), e);
            throw e;
        }
    }
}
