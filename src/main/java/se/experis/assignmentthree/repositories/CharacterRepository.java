package se.experis.assignmentthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.assignmentthree.models.Character;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {
    List<Character> getByFranchiseId(Long id);
    List<Character> getByMovieId(Long id);
    Character getById(Long id);

}
