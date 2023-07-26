package model;
import java.util.ArrayList;

public class Character {
    private int id;
    private String name;
    private SpecialPower specialPower;
    private ArrayList<Pokemon> pokemonList;

    public Character(int id, String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonList) {
        this.id = id;
        this.name = name;
        this.specialPower = specialPower;
        this.pokemonList = pokemonList;
    }

    //Null checke gerek yok cunku bos liste ekliyoruz
    public Character(int id, String name, SpecialPower specialPower) {
        this.id = id;
        this.name = name;
        this.specialPower = specialPower;
        this.pokemonList = new ArrayList<>();
    }

    public Character() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return pokemonList;
    }

    public void setPokemonList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @Override
    public String toString() {
        return  id + "- Name: " + name + '\n' +
                "SpecialPower: " + specialPower + '\n';
    }
}
