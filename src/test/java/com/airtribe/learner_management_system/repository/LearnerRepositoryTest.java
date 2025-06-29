package com.airtribe.learner_management_system.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.airtribe.learner_management_system.entity.Learner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Use the real database instead of an in-memory one
public class LearnerRepositoryTest {

    @Autowired
    private LearnerRepo learnerRepo;
    
    private Learner learner;

    @BeforeEach
    public void setUp() {
        // This method will be called before each test
        // You can initialize any common objects or mocks here if needed
        System.out.println("Setting up before each test");
        learner = new Learner("test", "test@gmail.com", "3434", "ff");
    }

    @Test
    public void saveLearnerSuccessfully() {
        // This test will check if the learner is saved successfully
        Learner savedLearner = learnerRepo.save(learner);
        assertNotNull(savedLearner);
        assertNotNull(savedLearner.getLearnerId());
        System.out.println("Learner saved successfully with ID: " + savedLearner.getLearnerId());
    }

    @Test
    public void findLearnerById() {
        // This test will check if the learner can be found by ID
        Learner savedLearner = learnerRepo.save(learner);
        Learner foundLearner = learnerRepo.findById(savedLearner.getLearnerId()).orElse(null);
        assertNotNull(foundLearner);
        System.out.println("Learner found with ID: " + foundLearner.getLearnerId());
    }







}
