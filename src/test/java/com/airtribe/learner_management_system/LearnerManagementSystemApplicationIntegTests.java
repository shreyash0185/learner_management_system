package com.airtribe.learner_management_system;

import com.airtribe.learner_management_system.repository.LearnerRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class LearnerManagementSystemApplicationIntegTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    LearnerRepo learnerRepo;

    @AfterEach
    public void setUp() {
        // This method will be called before each test
        // You can initialize any common objects or mocks here if needed
        System.out.println("Setting up before each test");
        learnerRepo.deleteAll();
    }

    @Test
    public void testCreateLearnerEndpoint() throws Exception {
        // This test will check if the create learner endpoint is working correctly
        mockMvc.perform(MockMvcRequestBuilders.post("/learners")
                        .contentType("application/json")
                        .content("{\"name\":\"John Doe\", \"email\":\"test@gmail.com\", \"password\":\"test\"}"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("test@gmail.com"))
                .andExpect(jsonPath("$.learnerId").exists());

    }





}
