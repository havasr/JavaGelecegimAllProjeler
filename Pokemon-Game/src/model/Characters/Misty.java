package model.Characters;

import model.CharacterBase;
import model.PokemonBase;
import model.SpecialPowerBase;

import java.util.ArrayList;

public class Misty extends CharacterBase {

    public Misty(int id, String name, SpecialPowerBase specialPowerBase, ArrayList<PokemonBase> pokemonBaseList) {
        super(id, name, specialPowerBase, pokemonBaseList);
    }

    public Misty(int id, String name, SpecialPowerBase specialPowerBase) {
        super(id, name, specialPowerBase);
    }
}
