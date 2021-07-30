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
//Service class for Franchise object
@Service
public class FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CharacterRepository characterRepository;

    public List<Movie> getMoviesByFranchise(Long id){ return movieRepository.getAllByFranchiseId(id); }


    public Franchise save(Franchise franchise) {
        return franchiseRepository.save(franchise);
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

    public  Franchise delete(Long id){return franchiseRepository.deleteFranchiseById(id);}


}
