package se.experis.assignmentthree.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.assignmentthree.models.Character;
import se.experis.assignmentthree.service.CharacterService;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/characters")
public class CharacterController {
    //All endpoints return a response entity containing both a http status and the actual Json body
    @Autowired
    private CharacterService characterService;

    @Operation(summary = "Get all characters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the characters",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Character.class)) })})
    @GetMapping//Gets every franchise and returns it as a list
    public ResponseEntity<List<Character>> getAllCharacters(){
        List<Character>characters = characterService.getCharacters();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(characters,status);
    }
    @Operation(summary = "Get a Character by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the character",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Character.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Character not found",
                    content = @Content) })
    @GetMapping("/{id}")//Gets a specific character based upon input id
    public ResponseEntity<Character> getCharacter(@PathVariable Long id){
        Character returnCharacter = new Character();
        HttpStatus status;
        //Checks whether object exists, returning 404 if not.
        if(characterService.exists(id)){
            status = HttpStatus.OK;
            returnCharacter = characterService.getById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnCharacter, status);
    }
    @Operation(summary = "Create a character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created the character",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Character.class)) })})
    @PostMapping//Creates a character object
    public ResponseEntity<Character> addCharacter(@RequestBody Character character){
        Character add = characterService.save(character);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }
    @Operation(summary = "Update a Character by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Updated the character",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Character.class)) }),
            @ApiResponse(responseCode = "400", description = "Suplied id does not match up with id in body",
                    content = @Content)})
    @PutMapping("/update/{id}")//Updates the character object with matching id to the input
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character){
        Character returnCharacter = new Character();
        HttpStatus status;
        //Checks whether the franchise object to be updated matches the object specified by the input, returning BAD REQUEST if not
        if(!id.equals(character.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnCharacter,status);
        }
        returnCharacter = characterService.save(character);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnCharacter, status);

    }
    @Operation(summary = "Delete a Character by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the character",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Character.class)) }),
            @ApiResponse(responseCode = "404", description = "Character not found",
                    content = @Content) })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Character> deleteCharacter(@PathVariable Long id){
        Character returnCharacter = new Character();
        HttpStatus status;
        //Checks whether object exists, returning 404 if not.
        if(characterService.exists(id)){
            status = HttpStatus.OK;
            characterService.delete(id);
            returnCharacter = characterService.getById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnCharacter, status);
    }



}
