package com.airtribe.learner_management_system.service;

import com.airtribe.learner_management_system.entity.Learner;
import com.airtribe.learner_management_system.repository.LearnerNotFoundException;
import com.airtribe.learner_management_system.repository.LearnerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import static org.mockito.Mockito.when;

@SpringBootTest
public class LearnerServiceTest {

    @Mock
    private LearnerRepo learnerRepo;

    @InjectMocks
    private LearnerService learnerService;

    @Test
    public void testLearnerSavedSuccesfully() {
        Learner learner = new Learner("test", "test", "3434", "ff");
        when(learnerRepo.save(learner)).thenReturn(learner);
        Learner createdLearner = learnerService.createLearner(learner);
        Assertions.assertEquals("test", createdLearner.getEmail());
        Assertions.assertEquals("test", createdLearner.getName());
        Assertions.assertEquals("3434", createdLearner.getPhoneNumber());


    }

    @Test
    public void testGetLearnerById() {
        Learner learner = new Learner("test", "test", "3434", "ff");
        when(learnerRepo.findById(1L)).thenReturn(java.util.Optional.of(learner));

        Learner foundLearner = learnerService.getLearnerById(1L);
        Assertions.assertNotNull(foundLearner);
        Assertions.assertEquals("test", foundLearner.getEmail());
        Assertions.assertEquals("test", foundLearner.getName());
    }

    @Test
    public void testGetLearnerById_UnhappyCase(){
        when(learnerRepo.findById(1L)).thenReturn(java.util.Optional.empty());
        Assertions.assertThrows(LearnerNotFoundException.class, () -> {
            learnerService.getLearnerById(1L);
        });
    }

}
