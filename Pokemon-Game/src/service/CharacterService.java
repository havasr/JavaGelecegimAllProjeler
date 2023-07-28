package service;

import model.CharacterBase;

import java.util.ArrayList;

public class CharacterService {
    public CharacterBase chooseCharacter(ArrayList<CharacterBase> characterBaseList, int id){
        CharacterBase characterBase = new CharacterBase();
      if(id<= characterBaseList.size()){
         characterBase = characterBaseList.get(id - 1);
      } else {
          System.out.println("Wrong input.");
      }
      return characterBase;
    }
}
