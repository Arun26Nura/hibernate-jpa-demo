package com.example;

import com.example.course.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest
class HibernateJpaDemoApplicationTests {

    @Autowired
    EntityManager entity;

    @Test
    void contextLoads() {


    }

    @Test
    public void getAllCourses() {
        CriteriaBuilder cb = entity.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> from = cq.from(Course.class);
        List<Course> course = entity.createQuery(cq.select(from)).getResultList();
        System.out.println("Course  : " + course);
    }


    @Test
    public void getAllCourseslike() {

        CriteriaBuilder cb = entity.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> criteriaRoot = cq.from(Course.class);
        Predicate like = cb.like(criteriaRoot.get("name"), "Java");
        cq.where(like);
        List<Course> course = entity.createQuery(cq.select(criteriaRoot)).getResultList();
        System.out.println("Course with Java : " + course);


    }


    @Test
    public void getAllCoursesIsEmpty() {
        CriteriaBuilder cb = entity.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Predicate isEmptyPredicate = cb.isEmpty(courseRoot.get("students"));
        cq.where(isEmptyPredicate);
        List<Course> course = entity.createQuery(cq.select(courseRoot)).getResultList();
        System.out.println("Course with No students : " + course);
    }


    @Test
    public void getAllCoursesJoin() {
        CriteriaBuilder cb = entity.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
      courseRoot.join("students", JoinType.LEFT);
        List<Course> course = entity.createQuery(cq.select(courseRoot)).getResultList();
        System.out.println("Course with JOIN : " + course);
    }

    /*
    @Test
    public void getAllCoursesWithoutStudents(){
        List<Course> course= entity.createQuery("select c from Course c where c.students is empty").getResultList();
        System.out.println("Course with No students"+course);

    }

    @Test
    public void getAllCoursesWithAtleastStudents(){
        List<Course> course= entity.createQuery("select c from Course c where size(c.students) >= 2").getResultList();
        System.out.println("Course with more than 2 students" + course);

    }
    @Test
    public void getAllCoursesWithStudentsOrdered(){
        List<Course> course= entity.createQuery("select c from Course c order by size(c.students) desc ",Course.class).getResultList();
        System.out.println("Course with more order" + course);

    }
    */


}
