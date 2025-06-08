package com.airtribe.learner_management_system.service;



import com.airtribe.learner_management_system.entity.Cohort;
import com.airtribe.learner_management_system.entity.Learner;
import com.airtribe.learner_management_system.repository.CohortRepository;
import com.airtribe.learner_management_system.repository.LearnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {


    @Autowired
    private LearnerRepo learnerRepository;

    @Autowired
    private CohortRepository cohortRepository;

    public Learner createLearner(Learner learner) {
        // Here you would typically save the learner to a database
        // For this example, we will just return a success message

         return learnerRepository.save(learner);


    }

    public List<Learner> getAllLearner() {
        // This method would retrieve all learners from the database
        // For this example, we will just print a message
        System.out.println("Retrieving all learners...");
       List<Learner> learnerList = learnerRepository.findAll();
       return learnerList;
    }

    public Learner getLearnerById(Long id) {

        Optional<Learner> optionalLearner = learnerRepository.findById(id);
        if (optionalLearner.isPresent()) {
            return optionalLearner.get();
        } else {
            // Handle the case where the learner is not found
            System.out.println("Learner with ID " + id + " not found.");
            return null; // or throw an exception
        }
    }

    public Learner getLearnerByName(String name) {

        // This method would retrieve a learner by name from the database
        // For this example, we will just print a message
        System.out.println("Retrieving learner by name: " + name);
        Learner learner = learnerRepository.findByName(name);
        if (learner != null) {
            return learner;
        } else {
            System.out.println("Learner with name " + name + " not found.");
            return null; // or throw an exception
        }
    }

    public Cohort createCohort(Cohort cohort) {

        return cohortRepository.save(cohort);

    }

    public Cohort assignLearnerToCohort(Long cohortId, Long learnerId) {
        Optional<Cohort> optionalCohort = cohortRepository.findById(cohortId);
        Optional<Learner> optionalLearner = learnerRepository.findById(learnerId);
        if (optionalCohort.isPresent() && optionalLearner.isPresent()) {
            Cohort cohort = optionalCohort.get();
            Learner learner = optionalLearner.get();

            // Add the learner to the cohort's list of learners
            cohort.getLearners().add(learner);
            // Save the updated cohort
            return cohortRepository.save(cohort);
        } else {
            // Handle the case where the cohort or learner is not found
            System.out.println("Cohort or Learner not found.");
            return null; // or throw an exception
        }
    }
}
