package com.example.review;

import com.example.course.Course;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private int rating;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
