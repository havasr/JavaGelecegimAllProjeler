package service;

import model.Pokemon;

import java.util.ArrayList;

public class PokemonService {
    public Pokemon choosePokemon(ArrayList<Pokemon> pokemonList, int id){
        Pokemon pokemon = new Pokemon();
        if(id<=pokemonList.size()){
            pokemon = pokemonList.get(id - 1);
        } else {
            System.out.println("Wrong input.");
        }
        return pokemon;
    }
}
