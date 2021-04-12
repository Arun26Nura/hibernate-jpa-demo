package com.example;

import com.example.course.CourseRepository;

import com.example.employee.Employee;
import com.example.employee.EmployeeRepository;
import com.example.employee.PartTimeEmployee;
import com.example.employee.PermanentEmployee;
import com.example.review.Review;
import com.example.student.Student;
import com.example.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class HibernateJpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CourseRepository courseRepo;
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    EmployeeRepository employeeRepo;



    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

      // studentRepo.getStudentByIDWithPassport(20001L);

      //  studentRepo.findPassportFirst(30001L);

    /*    List<Review> reviews  = new ArrayList<>();
        Review review1= new Review(4,"It's okay");
        Review review2= new Review(3,"Not bad, its Also not okay");
        reviews.add(review1);
        reviews.add(review2);*/

      // courseRepo.addReviewsforCourse(10003L);

      //  courseRepo.addListOfReviews(10003L,reviews);

        //courseRepo.getCoursewithReview(10001L);
       // courseRepo.getReviewWithCourse(40001L);
       // studentRepo.getStudentsWithCourses(20001L);
        //studentRepo.createnewStudentsWithCourse();

      /*  Employee partTime= new PartTimeEmployee("Arun",new BigDecimal(50));
        Employee fullTime= new PermanentEmployee("Jai",new BigDecimal(20000));
        employeeRepo.saveEmployee(partTime);
        employeeRepo.saveEmployee(fullTime);

        System.out.println(employeeRepo.getAllEmployees());*/


    }



}
