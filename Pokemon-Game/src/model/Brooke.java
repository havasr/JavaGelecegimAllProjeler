package model;

import java.util.ArrayList;

public class Brooke extends Character{

    public Brooke(int id, String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonList) {
        super(id, name, specialPower, pokemonList);
    }

    public Brooke(int id, String name, SpecialPower specialPower) {
        super(id, name, specialPower);
    }
}
