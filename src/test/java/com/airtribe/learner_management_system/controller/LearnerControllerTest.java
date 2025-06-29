package com.airtribe.learner_management_system.controller;

import com.airtribe.learner_management_system.entity.Learner;
import com.airtribe.learner_management_system.service.LearnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc// Use this annotation to enable MockMvc support for testing controllers
public class LearnerControllerTest {

    @Mock
    private LearnerService learnerService;

    @InjectMocks
    private LearnerController learnerController;

    @Autowired
    private MockMvc mockMvc;

    private List<Learner> learnerList;

    @BeforeEach
    public void setUp() {
        learnerList =new ArrayList<>(List.of(
                new Learner("John Doe", "test","test")));
         mockMvc = MockMvcBuilders.standaloneSetup(learnerController).build();
    }

    @Test
    public void getAllLearnersTest() throws Exception {
      when(learnerService.getAllLearner()).thenReturn(learnerList);
        // Here you would typically perform a GET request to the endpoint and verify the response
        // For example:
         mockMvc.perform(MockMvcRequestBuilders.get("/learners"))
                .andExpect(status().isOk())
                 .andDo(print());
//                .andExpect(jsonPath("$[0].name").value("John Doe"));
    }


}
