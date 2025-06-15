package com.airtribe.learner_management_system.controller;


import com.airtribe.learner_management_system.entity.Cohort;
import com.airtribe.learner_management_system.entity.Learner;
import com.airtribe.learner_management_system.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/cohorts")
    public Iterable<Cohort> getAllCohorts() {
        return learnerManagementService.getAllCohorts();
    }

    @PostMapping("/cohorts/{cohortId}/learners")
    public Cohort addLearnerToCohort(@RequestBody List<Learner> learners , @PathVariable("cohortId") Long cohortId) {
        return learnerManagementService.addLearnerToCohort(learners,cohortId);
    }


}
