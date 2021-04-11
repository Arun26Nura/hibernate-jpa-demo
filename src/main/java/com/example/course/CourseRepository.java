package com.example.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository{

    @Autowired
    EntityManager entity;

    public Course findById(Long id){
        return entity.find(Course.class,id);
    }

    public void deleteById(Long id){
        System.out.println("Delete by course started");
        Course course= findById(id);
        entity.remove(course);
        System.out.println("Delete by course completed");
    }

    public Course saveCourse(Course course){
        if(course.getId()==null)
            entity.persist(course);
        else
            entity.merge(course);

        return course;
    }

    public List<Course> findAllQuery(){
        List<Course> courses= entity.createNativeQuery("select * from course",Course.class).getResultList();
        return courses;
    }


}
