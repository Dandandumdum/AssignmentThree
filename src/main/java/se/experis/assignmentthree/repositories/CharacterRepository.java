package se.experis.assignmentthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.assignmentthree.models.Character;
import se.experis.assignmentthree.models.Movie;

import java.util.List;
import java.util.Set;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {
    List<Character> getAllByFranchiseId(Long id);
    List<Character> getAllById(Long id);
    Character getById(Long id);


}
