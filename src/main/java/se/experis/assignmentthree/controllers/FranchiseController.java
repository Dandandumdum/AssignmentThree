package se.experis.assignmentthree.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.assignmentthree.models.Character;
import se.experis.assignmentthree.models.Franchise;
import se.experis.assignmentthree.models.Movie;
import se.experis.assignmentthree.service.FranchiseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/franchise")
public class FranchiseController {
    //All endpoints return a response entity containing both a http status and the actual Json body
    @Autowired
    private FranchiseService franchiseService;

    @Operation(summary = "Get all franchises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the franchises",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Franchise.class)) })})
    @GetMapping//Gets every franchise and returns it as a list
    public ResponseEntity<List<Franchise>>getAllFranchises(){
        List<Franchise>franchises = franchiseService.getFranchises();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(franchises,status);
    }
    @Operation(summary = "Get a Franchise by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the franchise",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Franchise.class)) }),
            @ApiResponse(responseCode = "404", description = "Franchise not found",
                    content = @Content) })
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
    @Operation(summary = "Get all Movies in a Franchise by Franchise id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Movies",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Franchise.class)) }),
            @ApiResponse(responseCode = "404", description = "Franchise not found",
                    content = @Content) })
    @GetMapping("/movies/{id}")//Gets all movie objects in the form of a list which are part of a  franchise object, based upon the franchise id
    public ResponseEntity<List<Movie>> getAllMoviesByFranchise(@PathVariable Long id){
        List<Movie>data = null;
        HttpStatus status;
        if(franchiseService.exists(id)){
            status = HttpStatus.OK;
            data = franchiseService.getMoviesByFranchise(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(data, status);

    }
    @Operation(summary = "Get all Characters in a  Franchise by franchise id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Characters",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Franchise.class)) }),
            @ApiResponse(responseCode = "404", description = "Franchise not found",
                    content = @Content) })
    @GetMapping("/characters/{id}")//Gets all character objects in the form of a list which are part of the franchise object, based upon the franchise id
    public ResponseEntity<List<Character>> getAllCharactersByFranchise(@PathVariable Long id){
        List<Character>data = null;
        HttpStatus status;
        if(franchiseService.exists(id)){
            status = HttpStatus.OK;
            data = franchiseService.getCharactersByFranchise(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(data, status);

    }
    @Operation(summary = "Create a Franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created the Franchise",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Franchise.class)) })})
    @PostMapping//adds a franchise object
    public ResponseEntity<Franchise> addFranchise(@RequestBody Franchise franchise){
        Franchise add = franchiseService.save(franchise);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }

    @Operation(summary = "Update a Franchise by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Updated the franchise",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Franchise.class)) }),
            @ApiResponse(responseCode = "400", description = "Supplied id does not match up with id in body",
                    content = @Content)})
    @PutMapping("/update/{id}")//Updates the franchise object with matching id to the input
    public ResponseEntity<Franchise> updateFranchise(@PathVariable Long id, @RequestBody Franchise franchise){
        Franchise returnFran = new Franchise();
        HttpStatus status;
        //Checks whether the franchise object to be updated matches the object specified by the input, returning BAD REQUEST if not
        if(!id.equals(franchise.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnFran,status);
        }
        returnFran = franchiseService.save(franchise);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnFran, status);

    }
    @Operation(summary = "Update a Franchise wit a Movie by Franchise id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Updated the Franchise",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Franchise.class)) }),
            @ApiResponse(responseCode = "400", description = "Supplied id does not match up with id in body",
                    content = @Content)})
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
    @Operation(summary = "Delete a Franchise by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the Franchise",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Franchise.class)) }),
            @ApiResponse(responseCode = "404", description = "Franchise not found",
                    content = @Content) })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Franchise> deleteFranchise(@PathVariable Long id){
        Franchise returnFranchise = new Franchise();
        HttpStatus status;
        //Checks whether object exists, returning 404 if not.
        if(franchiseService.exists(id)){
            status = HttpStatus.OK;
            franchiseService.delete(id);
            returnFranchise = franchiseService.getById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnFranchise, status);
    }





}
