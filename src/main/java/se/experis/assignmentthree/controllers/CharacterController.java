package se.experis.assignmentthree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.experis.assignmentthree.models.Character;
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
}
