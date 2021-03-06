package se.experis.assignmentthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.experis.assignmentthree.models.Character;
import se.experis.assignmentthree.models.Movie;
import se.experis.assignmentthree.repositories.CharacterRepository;
import se.experis.assignmentthree.repositories.MovieRepository;

import java.util.ArrayList;
import java.util.List;
//Service class for Movie object
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CharacterRepository characterRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public boolean exists(Long id){
        return movieRepository.existsById(id);
    }

    public Movie delete(Long id) {return movieRepository.deleteMovieById(id);}

    public Movie getById(Long id){
        return movieRepository.findMovieById(id);
    }
    //Custom method for unidirectional data
    public List<Character> getCharactersByMovie(Long id){
       Movie movie =getById(id);
       List <Character> charactersByMovie = new ArrayList<>() ;
       charactersByMovie.addAll(movie.characters);
       return charactersByMovie;
    }
}
