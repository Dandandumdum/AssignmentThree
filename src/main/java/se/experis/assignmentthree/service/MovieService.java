package se.experis.assignmentthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.experis.assignmentthree.models.Movie;
import se.experis.assignmentthree.repositories.CharacterRepository;
import se.experis.assignmentthree.repositories.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CharacterRepository characterRepository;

    public List<String> getCharactersByMovie(Long id){
        return movieRepository.getById(id).characters();
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

/*
public boolean updateCharactersInMovie(long movieId, int[] charactersToAdd) {
        return movieRepository.updateCharacterInMovie(movieId, charactersToAdd);
    }
    public Movie getMovieById(long id){
        return movieRepository.getById(id);
    }
 */





}
