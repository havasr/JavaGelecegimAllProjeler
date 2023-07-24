package model;

import java.util.ArrayList;

public class Character {
    private String name;
    private SpecialPower specialPower;
    private ArrayList<Pokemon> PokemonList;

    public Character(String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonList) {
        this.name = name;
        this.specialPower = specialPower;
        this.PokemonList = pokemonList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(SpecialPower specialPower) {
        this.specialPower = specialPower;
    }

    public ArrayList<Pokemon> getPokemonList() {
        return PokemonList;
    }

    public void setPokemonList(ArrayList<Pokemon> pokemonList) {
        PokemonList = pokemonList;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", specialPower=" + specialPower +
                ", PokemonList=" + PokemonList +
                '}';
    }
}
