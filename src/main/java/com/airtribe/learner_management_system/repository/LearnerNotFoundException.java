package com.airtribe.learner_management_system.repository;

public class LearnerNotFoundException extends RuntimeException {
    public LearnerNotFoundException(String message) {
        super(message);
    }


    public LearnerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
