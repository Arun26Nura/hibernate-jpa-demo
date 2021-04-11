package com.example.course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {

    @Autowired
    CourseRepository repo;

    @Test
    void findById() {
        Course course= repo.findById(10001L);
        assertEquals("Arun",course.getName());
    }
}