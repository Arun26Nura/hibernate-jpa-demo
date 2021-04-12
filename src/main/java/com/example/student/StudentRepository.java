package com.example.student;



import com.example.course.Course;
import com.example.course.CourseRepository;
import com.example.passport.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager entity;

    @Autowired
    CourseRepository repo;


    @Transactional
    public void getStudentByIDWithPassport(Long id){
        Student student= entity.find(Student.class,id);
        System.out.println(student);
        System.out.println(student.getPassport());
    }


    public List<Student> getAllStudents(){
       return entity.createNativeQuery("SELECT * FROM STUDENT").getResultList();
    }

    public Student saveStudent(Student student){
        if(student.getId()==null)
            entity.persist(student);
        else
            entity.merge(student);
        return student;
    }

    public Student saveStudentWithPassport(){
        Student student= new Student("Reva");
        Passport passport= new Passport("E0005");
        entity.persist(passport);
        student.setPassport(passport);
        entity.persist(student);
        student.setName("Revathi");
        return student;
    }

    public void deleteStudentById(Long id){
        Student student=getStudentByID(id);
        entity.remove(student);
    }

    public Student getStudentByID(Long id) {
        return entity.find(Student.class,id);
    }

    public void findPassportFirst(Long id){
        Passport passport= entity.find(Passport.class,id);
        System.out.println(passport.getStudent());
    }

    //Many to Many mapping methods
    public void getStudentsWithCourses(Long id){
        Student student= getStudentByID(id);
        System.out.println(student);
        System.out.println(student.getCourses());
    }

    public void createnewStudentsWithCourse(){
        Student student= new Student("Jai");
        Course course= new Course("MicroServices");
        entity.persist(course);
        entity.persist(student);
        student.addCourse(course);

        List<Course> courses= repo.findAllQuery();
        for(Course course1:courses){
            student.addCourse(course1);

        }

    }


}
