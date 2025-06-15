package com.airtribe.learner_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;

    @OneToMany(mappedBy = "course")
    private List<Cohort> cohorts;


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public Course() {
        // Default constructor
    }

    public Course(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;

    }
}
