package com.airtribe.learner_management_system.service;

import com.airtribe.learner_management_system.entity.Learner;
import com.airtribe.learner_management_system.repository.LearnerNotFoundException;
import com.airtribe.learner_management_system.repository.LearnerRepo;
import org.junit.jupiter.api.*;
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

    private Learner learner;
    
    @BeforeEach
    public void setUp() {

         learner = new Learner("test", "test@gmail.com", "3434", "ff");

        // This method will be called before each test
        // You can initialize any common objects or mocks here if needed
        System.out.println("Setting up before each test");
    }
    
    @BeforeAll
    public static void beforeA() {
        // This method will be called once before all tests
        // You can perform any static initialization here if needed
        System.out.println("Setting up before all tests");
    }

    @AfterEach
    public void tearDown() {
        // This method will be called after each test
        // You can clean up any resources or reset mocks here if needed
        System.out.println("Tearing down after each test");
    }

    @AfterAll
    public static void afterA() {
        // This method will be called once after all tests
        // You can perform any final cleanup here if needed
        System.out.println("Tearing down after all tests");
    }
    

    @Test
    public void testLearnerSavedSuccesfully() {
        when(learnerRepo.save(learner)).thenReturn(learner);
        Learner createdLearner = learnerService.createLearner(learner);
        Assertions.assertEquals("test@gmail.com", createdLearner.getEmail());
        Assertions.assertEquals("test", createdLearner.getName());
        Assertions.assertEquals("3434", createdLearner.getPhoneNumber());


    }

    @Test
    public void testGetLearnerById() {
        Learner learner = new Learner("test", "test@gmail.com", "3434", "ff");
        when(learnerRepo.findById(1L)).thenReturn(java.util.Optional.of(learner));

        Learner foundLearner = learnerService.getLearnerById(1L);
        Assertions.assertNotNull(foundLearner);
        Assertions.assertEquals("test@gmail.com", foundLearner.getEmail());
        Assertions.assertEquals("test", foundLearner.getName());
    }

    @Test
    public void testGetLearnerById_UnhappyCase(){
        when(learnerRepo.findById(1L)).thenReturn(java.util.Optional.empty());
//        Assertions.assertThrows(LearnerNotFoundException.class, () -> {
//            learnerService.getLearnerById(1L);
//        });
     LearnerNotFoundException exception = Assertions.assertThrows(LearnerNotFoundException.class, () -> {
            learnerService.getLearnerById(1L);
        });
//        Assertions.assertEquals("Learner with ID 1 not found.", exception.getMessage());
    }

}
