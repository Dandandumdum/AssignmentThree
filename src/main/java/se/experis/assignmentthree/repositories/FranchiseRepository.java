package se.experis.assignmentthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.assignmentthree.models.Franchise;

//Repository for all franchise specific SQL functions generated by Hibernate
@Repository
public interface FranchiseRepository extends JpaRepository<Franchise,Long> {
    //Finds a specific franchise with a franchise id matching the input id and returns the object
    Franchise getFranchiseById(Long id);
    Franchise deleteFranchiseById (Long id);

}
