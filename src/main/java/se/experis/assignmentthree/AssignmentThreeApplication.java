package se.experis.assignmentthree;

import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.experis.assignmentthree.controllers.FranchiseController;
import se.experis.assignmentthree.models.Franchise;

@SpringBootApplication
public class AssignmentThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentThreeApplication.class, args);
    }

}
