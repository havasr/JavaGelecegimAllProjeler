package service;

import model.Character;

import java.util.ArrayList;

public class CharacterService {
    public Character chooseCharacter(ArrayList<Character> characterList, int id){
        Character choosenCharacter = null;
        for (Character character : characterList) {
            if (character.getId() == id){
                choosenCharacter.getId();
            }
        }
        return choosenCharacter;
    }

}
