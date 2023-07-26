package model;

import java.util.ArrayList;

public class Ash extends Character{

    public Ash(int id, String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonList) {
        super(id, name, specialPower, pokemonList);
    }

    public Ash(int id, String name, SpecialPower specialPower) {
        super(id, name, specialPower);
    }
}
