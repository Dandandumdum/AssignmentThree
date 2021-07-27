package se.experis.assignmentthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.experis.assignmentthree.models.Franchise;
import se.experis.assignmentthree.models.Movie;
import se.experis.assignmentthree.repositories.CharacterRepository;
import se.experis.assignmentthree.repositories.FranchiseRepository;
import se.experis.assignmentthree.repositories.MovieRepository;

import java.util.List;

@Service
public class FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CharacterRepository characterRepository;

    public List<String> getMoviesByFranchise(Long id){
        return franchiseRepository.getById(id).movies();
    }
    public List<String> getCharactersByFranchise(Long id){
        return franchiseRepository.getById(id).characters();
    }

    public Franchise save(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }



   /* public List<Character> getAllCharacters() {return franchiseRepository.findAll(); }
    public List<Movie> getAllMovies() {return franchiseRepository.findAll(); }
*/
}
