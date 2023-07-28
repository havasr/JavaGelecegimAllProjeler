package service;

import model.PokemonBase;

import java.util.ArrayList;

public class PokemonService {
    public PokemonBase choosePokemon(ArrayList<PokemonBase> pokemonBaseList, int id){
        PokemonBase pokemonBase = new PokemonBase();
        if(id<= pokemonBaseList.size()){
            pokemonBase = pokemonBaseList.get(id - 1);
        } else {
            System.out.println("Wrong input.");
        }
        return pokemonBase;
    }
}
