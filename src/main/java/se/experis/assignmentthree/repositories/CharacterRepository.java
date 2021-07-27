package se.experis.assignmentthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.assignmentthree.models.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {
}
