package se.experis.assignmentthree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.assignmentthree.models.Character;
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

    @GetMapping("/characters/{id}")
    public ResponseEntity<List<Movie>> getAllCharactersByMovie(@PathVariable Long id){
        List<Movie> data = (List<Movie>) getAllCharactersByMovie(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }
/*
    @PostMapping("/{id}")
    public ResponseEntity<Movie> updateCharacterInMovie(@PathVariable long id ,@RequestBody int [] charactersToUpdate){
        HttpStatus status;
        Movie returnMovie = new Movie();

        //add boolean check

        status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(returnMovie,status);
    }
*/


}
