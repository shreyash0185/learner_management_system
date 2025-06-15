package com.airtribe.learner_management_system.controller;

import com.airtribe.learner_management_system.entity.Course;
import com.airtribe.learner_management_system.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseConstroller {

    @Autowired
    private LearnerService learnerService;;

    @PostMapping
    public Course createCourse(Course course) {
        return learnerService.createCourse(course);
    }
}
