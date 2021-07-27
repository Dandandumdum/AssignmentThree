package se.experis.assignmentthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.assignmentthree.models.Franchise;
import se.experis.assignmentthree.models.Movie;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> getByFranchiseId(Long franchise_id);
    Movie getById(Long id);

   // boolean updateCharacterInMovie(long id, int[] charactersToAdd);
}
