package se.experis.assignmentthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.experis.assignmentthree.models.Character;
import se.experis.assignmentthree.repositories.CharacterRepository;
import se.experis.assignmentthree.repositories.MovieRepository;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }
}
