package com.example;

import com.example.course.CourseRepository;

import com.example.student.Student;
import com.example.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class HibernateJpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CourseRepository courseRepo;
    @Autowired
    StudentRepository studentRepo;



    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       //logger.info(courseRepo.findById(1).toString());
       // courseRepo.deleteById(1);
        //System.out.println("Course size: "+ courseRepo.findAllQuery().size());
    // studentRepo.saveStudentWithPassport();
      //  System.out.println(students);
       // System.out.println(students.getPassport());
       studentRepo.getStudentByIDWithPassport(20001L);
       //System.out.println(student);
      // System.out.println(student.getPassport());
        studentRepo.findPassportFirst(30001L);
    }
}
