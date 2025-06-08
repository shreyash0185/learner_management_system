package com.airtribe.learner_management_system.entity;

import java.util.List;

public class LaarnerDTO {

    private Long learnerId;
    private String name;
    private String email;
    private String phoneNumber;

    private List<CohortDTO> cohorts;

    public LaarnerDTO(Long learnerId, String name, String email, String phoneNumber, List<CohortDTO> cohorts) {
        this.learnerId = learnerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cohorts = cohorts;
    }

    public Long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(Long learnerId) {
        this.learnerId = learnerId;
    }

    public List<CohortDTO> getCohorts() {
        return cohorts;
    }

    public void setCohorts(List<CohortDTO> cohorts) {
        this.cohorts = cohorts;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
