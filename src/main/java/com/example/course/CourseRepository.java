package com.example.course;

import com.example.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.Callable;

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

    public void addReviewsforCourse(Long id){
        Course course= findById(id);

        Review review1= new Review(4,"It's okay");
        Review review2= new Review(3,"Not bad");

        review1.setCourse(course);
        review2.setCourse(course);

        course.addReview(review1);
        course.addReview(review2);

        entity.persist(review1);
        entity.persist(review2);
    }

    public void addListOfReviews(long id, List<Review> reviews) {
        Course course= findById(id);
        for(Review review:reviews){
            review.setCourse(course);
            course.addReview(review);
            entity.persist(review);
        }
    }

    public void getCoursewithReview(Long id){
        Course course= findById(id);
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    public void getReviewWithCourse(Long id){
        Review review= entity.find(Review.class,id);
        System.out.println(review);
        System.out.println(review.getCourse());

    }


}
