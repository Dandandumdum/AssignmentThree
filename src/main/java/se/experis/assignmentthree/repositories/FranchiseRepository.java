package se.experis.assignmentthree.repositories;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.assignmentthree.models.Franchise;

@Repository
//@SQLUpdate(sql = "Update Franchise Set name = ?, description = ? Where id = ? ")
public interface FranchiseRepository extends JpaRepository<Franchise,Long> {
    Franchise getFranchiseById(Long id);

}
