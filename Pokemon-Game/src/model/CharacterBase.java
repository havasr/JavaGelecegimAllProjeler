package model;
import java.util.ArrayList;

public class CharacterBase {
    private int id;
    private String name;
    private SpecialPowerBase specialPowerBase;
    private ArrayList<PokemonBase> pokemonBaseList;

    public CharacterBase(int id, String name, SpecialPowerBase specialPowerBase, ArrayList<PokemonBase> pokemonBaseList) {
        this.id = id;
        this.name = name;
        this.specialPowerBase = specialPowerBase;
        this.pokemonBaseList = pokemonBaseList;
    }

    //Null check is not necessary because an empty list is added
    public CharacterBase(int id, String name, SpecialPowerBase specialPowerBase) {
        this.id = id;
        this.name = name;
        this.specialPowerBase = specialPowerBase;
        this.pokemonBaseList = new ArrayList<>();
    }

    public CharacterBase() {
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

    public SpecialPowerBase getSpecialPower() {
        return specialPowerBase;
    }

    public void setSpecialPower(SpecialPowerBase specialPowerBase) {
        this.specialPowerBase = specialPowerBase;
    }

    public ArrayList<PokemonBase> getPokemonList() {
        return pokemonBaseList;
    }

    public void setPokemonList(ArrayList<PokemonBase> pokemonBaseList) {
        this.pokemonBaseList = pokemonBaseList;
    }

    @Override
    public String toString() {
        return  "- Name: " + name + '\n' +
                "SpecialPower: " + specialPowerBase + '\n';
    }
}
