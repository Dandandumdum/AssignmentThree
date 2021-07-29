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
    //All endpoints return a response entity containing both a http status and the actual Json body
    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")//Gets a specific movie based upon input id
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
        Movie returnMovie = new Movie();
        HttpStatus status;
        //Checks whether object exists, returning 404 if not.
        if(movieService.exists(id)){
            status = HttpStatus.OK;
            returnMovie = movieService.getById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnMovie, status);
    }
    @GetMapping//Gets every movie and returns it as a list
    public ResponseEntity<List<Movie>>getAllMovies(){
    List<Movie>movies = movieService.getMovies();
    HttpStatus status = HttpStatus.OK;
    return new ResponseEntity<>(movies,status);
    }

    @GetMapping("/characters/{id}")//Gets all character objects in the form of a list which are part of the movie object, based upon the movie id
    public ResponseEntity<List<Character>> getAllCharactersByMovie(@PathVariable Long id){
        List<Character> data = movieService.getCharactersByMovie(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }
    @PostMapping//adds a movie object
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie add = movieService.save(movie);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }
    @PutMapping("/update/{movieId}")//Updates the movie object with matching id to the input
    public ResponseEntity<Movie> updateMovie(@PathVariable Long movieId, @RequestBody Movie movie){
        Movie returnMovie = new Movie();
        HttpStatus status;
        //Checks whether the franchise object to be updated matches the object specified by the input, returning BAD REQUEST if not
        if(!movieId.equals(movie.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnMovie,status);
        }
        returnMovie = movieService.save(movie);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnMovie, status);

    }
    @PutMapping("/update/character/{movieId}")//Updates the movie object with characters, if the movie id with matching id to the input.
    // characters to be included are within an int array in the Json body of the request.
    public ResponseEntity<Movie> updateCharacterInMovie(@PathVariable Long movieId, @RequestBody Movie movie){
        Movie returnMovie = new Movie();
        HttpStatus status;
        //Checks whether the franchise object to be updated matches the object specified by the input, returning BAD REQUEST if not
        if(!movieId.equals(movie.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnMovie,status);
        }
        returnMovie = movieService.save(movie);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnMovie, status);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id){
        Movie returnMovie = new Movie();
        HttpStatus status;
        //Checks whether object exists, returning 404 if not.
        if(movieService.exists(id)){
            status = HttpStatus.OK;
            movieService.delete(id);
            returnMovie = movieService.getById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnMovie, status);
    }
}
