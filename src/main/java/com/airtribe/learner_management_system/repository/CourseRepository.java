package com.airtribe.learner_management_system.repository;

import com.airtribe.learner_management_system.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // This interface will automatically provide CRUD operations for Course entity
    // Additional custom query methods can be defined here if needed
}
