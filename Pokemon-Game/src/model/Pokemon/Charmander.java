package model.Pokemon;

import model.PokemonBase;
import model.SpecialPowerBase;
import model.TypeEnum;

public class Charmander extends PokemonBase {


    public Charmander(int id, String name, int health, int damage, TypeEnum type, SpecialPowerBase specialPowerBase) {
        super(id, name, health, damage, type, specialPowerBase);
    }
}
