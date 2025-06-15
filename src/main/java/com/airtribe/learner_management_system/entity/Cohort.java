package com.airtribe.learner_management_system.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cohort {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long cohortId;

    private String cohortName;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Learner> learners;

    @ManyToOne
    private Course course;

    public Long getCohortId() {
        return cohortId;
    }

    public void setCohortId(Long cohortId) {
        this.cohortId = cohortId;
    }

    public String getCohortName() {
        return cohortName;
    }

    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }

    public Cohort() {
        // Default constructor
    }

    public Cohort(Long cohortId, String cohortName,List<Learner> learners) {
        this.cohortId = cohortId;
        this.cohortName = cohortName;
        this.learners = learners;
    }

    public List<Learner> getLearners() {
        return learners;
    }

    public void setLearners(List<Learner> learners) {
        this.learners = learners;
    }
}
