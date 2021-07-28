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
    //All endpoints return a response entity containing both a http status and the actual Json body
    @Autowired
    private FranchiseService franchiseService;

    @GetMapping//Gets every franchise and returns it as a list
    public ResponseEntity<List<Franchise>>getAllFranchises(){
        List<Franchise>franchises = franchiseService.getFranchises();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(franchises,status);
    }
    @GetMapping("/{id}")//Gets a specific franchise based upon input id
    public ResponseEntity<Franchise> getFranchise(@PathVariable Long id){
        Franchise returnFran = new Franchise();
        HttpStatus status;
        //Checks whether object exists, returning 404 if not.
        if(franchiseService.exists(id)){
            status = HttpStatus.OK;
            returnFran = franchiseService.getById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnFran, status);
    }

    @GetMapping("/movies/{id}")//Gets all movie objects in the form of a list which are part of a  franchise object, based upon the franchise id
    public ResponseEntity<List<Movie>> getAllMoviesByFranchise(@PathVariable Long id){
        List<Movie> data = franchiseService.getMoviesByFranchise(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }
    @GetMapping("/characters/{id}")//Gets all character objects in the form of a list which are part of the franchise object, based upon the franchise id
    public ResponseEntity<List<Character>> getAllCharactersByFranchise(@PathVariable Long id){
        List<Character> data =  franchiseService.getCharactersByFranchise(id);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }
    @PostMapping//adds a franchise object
    public ResponseEntity<Franchise> addFranchise(@RequestBody Franchise franchise){
        Franchise add = franchiseService.save(franchise);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }
    @PutMapping("/update/{franchiseId}")//Updates the franchise object with matching id to the input
    public ResponseEntity<Franchise> updateFranchise(@PathVariable Long franchiseId, @RequestBody Franchise franchise){
        Franchise returnFran = new Franchise();
        HttpStatus status;
        //Checks whether the franchise object to be updated matches the object specified by the input, returning BAD REQUEST if not
        if(!franchiseId.equals(franchise.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnFran,status);
        }
        returnFran = franchiseService.save(franchise);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnFran, status);

    }
    @PutMapping("/update/movie/{franchiseId}")//Updates the  franchise object with movies, if the franchise id with matching id to the input.
    // movies to be included are within an int array in the Json body of the request.
    public ResponseEntity<Franchise> updateMovieInFranchise(@PathVariable Long franchiseId, @RequestBody Franchise franchise){
        Franchise returnFran = new Franchise();
        HttpStatus status;
        //Checks whether the franchise object to be updated matches the object specified by the input, returning BAD REQUEST if not
        if(!franchiseId.equals(franchise.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnFran,status);
        }
        returnFran = franchiseService.save(franchise);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnFran, status);

    }





}
