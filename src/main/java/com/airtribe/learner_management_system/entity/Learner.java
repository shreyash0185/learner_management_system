package com.airtribe.learner_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long learnerId;

    private String name;

    private String email;

    private String phoneNumber;

    //Back Reference of the relationship with Cohort
    @ManyToMany(mappedBy = "learners")
    @JsonIgnore
    private List<Cohort> cohorts;

    public List<Cohort> getCohorts() {
        return cohorts;
    }

    public void setCohorts(List<Cohort> cohorts) {
        this.cohorts = cohorts;
    }
//Do not create the separate table for this relationship, use the existing Cohort table
    //This is a many-to-many relationship, so we do not need to create a separate join table


    public Learner(String name, String email, String phoneNumber, String ff) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(long learnerId) {
        this.learnerId = learnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
