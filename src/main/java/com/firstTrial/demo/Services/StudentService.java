package com.firstTrial.demo.Services;

import com.firstTrial.demo.Entities.Student;
import com.firstTrial.demo.Repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentService {
	private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
    	logger.info("Fetching all students from the database");
        
        List<Student> students = studentRepository.findAll();
        
        if (students.isEmpty()) {
        	logger.error("Failed to fetch students");
        } else {
        	logger.info("Fetched {} students", students.size());
        }
        
        return students;
    }

    public Student addStudent(Student student){
    	logger.info("Adding new student: {}");
        
        try {
            Student savedStudent = studentRepository.save(student);
            logger.info("Student added successfully with ID: {}", savedStudent);
            return savedStudent;
        } catch (Exception e) {
        	logger.error("Error adding student: {}", e.getMessage(), e);
            throw e;
        }
    }
}
