package com.airtribe.learner_management_system.repository;


import com.airtribe.learner_management_system.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepo extends JpaRepository<Learner, Long> {
    // Additional query methods can be defined here if needed

    Learner findByName(String name);

    //named Query example - parametrised Query
//    @Query("SELECT l FROM Learner l WHERE l.name = ?1")
//    void findByName(String name)// Example method to find a learner by name

}
