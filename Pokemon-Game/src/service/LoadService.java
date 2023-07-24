package service;

import model.*;
import model.Character;
import java.util.ArrayList;
public class LoadService {
    public ArrayList<model.Character> loadCharacters(){
        SpecialPower strategy1 = new Strategy("Strategy", 4, 1);
        SpecialPower strategy2 = new Strategy("Strategy 2", 3, 1);

        Character ash = new Ash("Ash", strategy1, null);
        Character brooke = new Brooke("Brooke", strategy2, null);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);

        return characterList;
    }

    public ArrayList<Pokemon> loadPokemons(){
        SpecialPower electricity = new Electricity("Electricty", 3, 3);
        SpecialPower water = new Water("Water", 1, 3);
        SpecialPower fire = new Fire("Fire", 5, 3);
        SpecialPower earth = new Earth("Earth", 4, 3);

        Pokemon pokemon1 = new Pikachu("Pikachu", 100, 10, TypeEnum.ELECTRIC, electricity);
        Pokemon pokemon2 = new Squirtle("Squirtle", 120, 8, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander("Charmander", 90, 12, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Bulbasaur("Bulbasaur", 140, 7, TypeEnum.EARTH, earth);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }

}
