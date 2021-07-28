package se.experis.assignmentthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.experis.assignmentthree.models.Character;
import se.experis.assignmentthree.models.Movie;
import se.experis.assignmentthree.repositories.CharacterRepository;
import se.experis.assignmentthree.repositories.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CharacterRepository characterRepository;

   public List<Character> getCharactersByMovie(Long id){
        return characterRepository.getAllById(id);    }



    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }
    public boolean exists(Long id){
        return movieRepository.existsById(id);
    }
    public Movie getById(Long id){
        return movieRepository.getMovieById(id);
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
