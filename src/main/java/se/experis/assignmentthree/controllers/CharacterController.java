package se.experis.assignmentthree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.assignmentthree.models.Character;
import se.experis.assignmentthree.models.Franchise;
import se.experis.assignmentthree.models.Movie;
import se.experis.assignmentthree.service.CharacterService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters(){
        List<Character>characters = characterService.getCharacters();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(characters,status);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable Long id){
        Character returnCharacter = new Character();
        HttpStatus status;

        if(characterService.exists(id)){
            status = HttpStatus.OK;
            returnCharacter = characterService.getById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnCharacter, status);
    }
    @PostMapping
    public ResponseEntity<Character> addCharacter(@RequestBody Character character){
        Character add = characterService.save(character);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }
    @PutMapping("/update/{characterId}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long characterId, @RequestBody Character character){
        Character returnCharacter = new Character();
        HttpStatus status;

        if(!characterId.equals(character.getId())){
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnCharacter,status);
        }
        returnCharacter = characterService.save(character);
        status = HttpStatus.NO_CONTENT;
        System.out.println();
        return new ResponseEntity<>(returnCharacter, status);

    }
}
