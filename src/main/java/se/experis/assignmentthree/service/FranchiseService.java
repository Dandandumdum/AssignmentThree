package se.experis.assignmentthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.experis.assignmentthree.models.Character;
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

    public List<Movie> getMoviesByFranchise(Long id){ return movieRepository.getAllByFranchiseId(id); }
    public List<Character> getCharactersByFranchise(Long id){
        return characterRepository.getAllByFranchiseId(id);
    }

    public Franchise save(Franchise franchise) {
        return franchiseRepository.saveAndFlush(franchise);
    }

    public List<Franchise> getFranchises() {
        return franchiseRepository.findAll();
    }

    public boolean exists(Long id) {
        return franchiseRepository.existsById(id);
    }
    public Franchise getById(Long id){
        return franchiseRepository.getFranchiseById(id);
    }



   /* public List<Character> getAllCharacters() {return franchiseRepository.findAll(); }
    public List<Movie> getAllMovies() {return franchiseRepository.findAll(); }
*/
}
