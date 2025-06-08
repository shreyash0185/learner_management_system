package com.airtribe.learner_management_system.controller;


import com.airtribe.learner_management_system.entity.Cohort;
import com.airtribe.learner_management_system.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CohortController {

    @Autowired
    private LearnerService learnerManagementService;

    @PostMapping("/cohorts")
    public Cohort createCohort(Cohort cohort) {
        return learnerManagementService.createCohort(cohort);

    }

    @PostMapping("/assignLearners")
    public Cohort assignLearnersToCohort(@RequestParam("cohortId") Long cohortId, @RequestParam("learnerId") Long learnerId) {
        return learnerManagementService.assignLearnerToCohort(cohortId, learnerId);
    }


}
