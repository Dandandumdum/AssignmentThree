package se.experis.assignmentthree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.assignmentthree.models.Character;
import se.experis.assignmentthree.models.Franchise;
import se.experis.assignmentthree.models.Movie;
import se.experis.assignmentthree.repositories.MovieRepository;
import se.experis.assignmentthree.service.CharacterService;
import se.experis.assignmentthree.service.MovieService;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
        Movie returnMovie = new Movie();
        HttpStatus status;

        if(movieService.exists(id)){
            status = HttpStatus.OK;
            returnMovie = movieService.getById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnMovie, status);
    }
    @GetMapping
    public ResponseEntity<List<Movie>>getAllMovies(){
    List<Movie>movies = movieService.getMovies();
    HttpStatus status = HttpStatus.OK;
    return new ResponseEntity<>(movies,status);
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<List<Character>> getAllCharactersByMovie(@PathVariable Long id){
        List<Character> data = movieService.getCharactersByMovie(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie add = movieService.save(movie);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }
    @PutMapping("/update/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long movieId, @RequestBody Movie movie){
        Movie returnMovie = new Movie();
        HttpStatus status;

        if(!movieId.equals(movie.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnMovie,status);
        }
        returnMovie = movieService.save(movie);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnMovie, status);

    }
    @PutMapping("/update/character/{movieId}")
    public ResponseEntity<Movie> updateCharacterInMovie(@PathVariable Long movieId, @RequestBody Movie movie){
        Movie returnMovie = new Movie();
        HttpStatus status;

        if(!movieId.equals(movie.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnMovie,status);
        }
        returnMovie = movieService.save(movie);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnMovie, status);

    }
}
