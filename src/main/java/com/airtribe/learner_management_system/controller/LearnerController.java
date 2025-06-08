package com.airtribe.learner_management_system.controller;

import com.airtribe.learner_management_system.entity.Cohort;
import com.airtribe.learner_management_system.entity.CohortDTO;
import com.airtribe.learner_management_system.entity.LaarnerDTO;
import com.airtribe.learner_management_system.entity.Learner;
import com.airtribe.learner_management_system.repository.LearnerNotFoundException;
import com.airtribe.learner_management_system.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class LearnerController {

    @Autowired
    LearnerService learnerService;
//
//    @PostMapping("/learner")
//    public Learner createLearner(@RequestBody  Learner learner) {
//        return learnerService.createLearner(learner);
//    }

    @GetMapping("/learner")
    public List<Learner> getAllLearner() {
        return learnerService.getAllLearner();
    }

    @GetMapping("/learner/{lernerId}")
    public Learner getLearnerById(@PathVariable Long lernerId) {
        Optional<Learner> optionalLearner = Optional.ofNullable(learnerService.getLearnerById(lernerId));
        if(!optionalLearner.isPresent()) {
            throw new LearnerNotFoundException("Learner not found with id: " + lernerId);
        }
        return learnerService.getLearnerById(lernerId);
    }

    @GetMapping("/learner/{lernerId}")
    public Learner getLearnerByName(@PathVariable String name) {
        return learnerService.getLearnerByName(name);
    }

    @GetMapping("learners")
    public List<LaarnerDTO> findLearners(@RequestParam(value = "learnerName" , required = false) String learnerName,
                                         @RequestParam(value = "learnerId", required = false) Long learnerId) {

        if(learnerName == null && learnerId == null) {
            List<Learner> learners = learnerService.getAllLearner();
            List<LaarnerDTO> learnerDTOs = new ArrayList<>();
            for (Learner learner : learners) {
                List<Cohort> cohorts = learner.getCohorts();
                List<CohortDTO> cohortDTOs = new ArrayList<>();
                for (Cohort cohort : cohorts) {
                    CohortDTO cohortDTO = new CohortDTO(cohort.getCohortId(), cohort.getCohortName());
                    cohortDTOs.add(cohortDTO);
                }
                learnerDTOs.add(new LaarnerDTO(learner.getLearnerId(), learner.getName(), learner.getEmail(), learner.getPhoneNumber(), cohortDTOs));
            }
        }

        //Need to map same code in below table

        List<LaarnerDTO> learnerDTOs = new ArrayList<>();
        if (learnerName == null && learnerId != null) {
            Learner learner = learnerService.getLearnerById(learnerId);
            if (learner != null) {
                List<CohortDTO> cohortDTOs = new ArrayList<>();
                for (Cohort cohort : learner.getCohorts()) {
                    cohortDTOs.add(new CohortDTO(cohort.getCohortId(), cohort.getCohortName()));
                }
                learnerDTOs.add(new LaarnerDTO(learner.getLearnerId(), learner.getName(), learner.getEmail(), learner.getPhoneNumber(), cohortDTOs));
            }
            return learnerDTOs;
        }
//        List<Learner> learners = new ArrayList<>();
//        if(learnerName == null && learnerId != null) {
//            learners.add(learnerService.getLearnerById(learnerId)) ;
//
//            return learners;
//        }


//        learners.add(learnerService.getLearnerByName(learnerName));
//        return learners;
        return learnerDTOs;

    }

    @ExceptionHandler(LearnerNotFoundException.class)
    public ResponseEntity handleLearnerNotFoundException(LearnerNotFoundException e) {
        return ResponseEntity
                .status(404)
                .body(e.getMessage());
    }





}
