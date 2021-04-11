package com.example.passport;



import com.example.student.Student;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Passport(String number) {
        this.number = number;
    }

    public Passport() {
    }

    @Override
    public String toString() {
        return "Passport{" + number + '\'' +
                '}';
    }
}
