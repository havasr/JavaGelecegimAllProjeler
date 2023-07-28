package service;

import model.*;
import model.CharacterBase;
import model.Characters.*;
import model.Pokemon.*;
import model.SpecialPowers.*;

import java.util.ArrayList;
public class LoadService {
    public ArrayList<CharacterBase> loadCharacters(){
        SpecialPowerBase strategy1 = new Strategy("Strategy", 8, 1);
        SpecialPowerBase strategy2 = new Strategy("Strategy 2", 9, 1);
        SpecialPowerBase strategy3 = new Strategy("Strategy 3", 9, 1);
        SpecialPowerBase strategy4 = new Strategy("Strategy 4", 7, 1);

        CharacterBase ash = new Ash(1, "Ash", strategy1);
        CharacterBase brooke = new Brock(2,"Brooke", strategy2);
        CharacterBase misty = new Misty(3,"Misty", strategy3);
        CharacterBase suzie = new Suzie(4,"Suzie", strategy4);

        ArrayList<CharacterBase> characterBaseList = new ArrayList<>();
        characterBaseList.add(ash);
        characterBaseList.add(brooke);
        characterBaseList.add(misty);
        characterBaseList.add(suzie);

        return characterBaseList;
    }

    public ArrayList<PokemonBase> loadPokemons(){
        SpecialPowerBase electricity = new Electricity("Electricty", 8, 1);
        SpecialPowerBase water = new Water("Water", 6, 1);
        SpecialPowerBase fire = new Fire("Fire", 7, 1);
        SpecialPowerBase grass = new Grass("Grass", 8, 1);
        SpecialPowerBase poison = new Poison("Poison", 9, 1);
        SpecialPowerBase normal = new Normal("Normal", 1, 1);


        PokemonBase pikachu = new Pikachu(1,"Pikachu", 100, 50, TypeEnum.ELECTRIC, electricity);
        PokemonBase squirtle = new Squirtle(2,"Squirtle", 120, 40, TypeEnum.WATER, water);
        PokemonBase charmander = new Charmander(3,"Charmander", 130, 50, TypeEnum.FIRE, fire);
        PokemonBase bulbasaur = new Bulbasaur(4,"Bulbasaur", 140, 45, TypeEnum.GRASS, grass);
        PokemonBase eevee = new Eevee(5,"Eevee", 140, 45, TypeEnum.NORMAL, normal);
        PokemonBase gengar = new Gengar(6,"Gengar", 140, 55, TypeEnum.POISON, poison);


        ArrayList<PokemonBase> pokemonBaseList = new ArrayList<>();
        pokemonBaseList.add(pikachu);
        pokemonBaseList.add(squirtle);
        pokemonBaseList.add(charmander);
        pokemonBaseList.add(bulbasaur);
        pokemonBaseList.add(eevee);
        pokemonBaseList.add(gengar);

        return pokemonBaseList;
    }

    public ArrayList<Weather> loadWeather(){
        Weather snow = new Weather("Snowy", 6);
        Weather harshSun = new Weather("Harsh Sunny", 5);
        Weather storm = new Weather("Stormy", 7);
        Weather rain = new Weather("Rainy", 6);

        ArrayList<Weather> weatherList = new ArrayList<>();
        weatherList.add(snow);
        weatherList.add(harshSun);
        weatherList.add(storm);
        weatherList.add(rain);

        return weatherList;
    }

}
