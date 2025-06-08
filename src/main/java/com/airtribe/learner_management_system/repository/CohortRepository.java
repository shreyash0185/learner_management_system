package com.airtribe.learner_management_system.repository;


import com.airtribe.learner_management_system.entity.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Long> {
    // Additional query methods can be defined here if needed
    // For example, you can add methods to find cohorts by name or other attributes
}
