package se.experis.assignmentthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.assignmentthree.models.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise,Long> {
    Franchise getFranchiseById(Long id);
}
