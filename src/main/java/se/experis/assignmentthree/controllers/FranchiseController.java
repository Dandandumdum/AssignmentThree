package se.experis.assignmentthree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.assignmentthree.models.Character;
import se.experis.assignmentthree.models.Franchise;
import se.experis.assignmentthree.models.Movie;
import se.experis.assignmentthree.service.FranchiseService;
import se.experis.assignmentthree.service.MovieService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/franchise")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;


    @GetMapping("/movies/{id}")
    public ResponseEntity<List<Movie>> getAllMoviesByFranchise(@PathVariable Long id){
        List<Movie> data = franchiseService.getMoviesByFranchise(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }
    @GetMapping("/characters/{id}")
    public ResponseEntity<List<Character>> getAllCharactersByFranchise(@PathVariable Long id){
        List<Character> data =  franchiseService.getCharactersByFranchise(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }
    @PostMapping
    public ResponseEntity<Franchise> addFranchise(@RequestBody Franchise franchise){
        Franchise add = franchiseService.save(franchise);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }
    @PutMapping("/movie/{franchiseId}")
    public ResponseEntity<Franchise> updateFranchise(@PathVariable Long franchiseId, @RequestBody Franchise franchise){
        Franchise returnFran = new Franchise();
        HttpStatus status;
/*
        if(!franchiseId.equals(franchise.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnFran,status);
        }
 */
        returnFran = franchiseService.save(franchise);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnFran, status);



    }



}
