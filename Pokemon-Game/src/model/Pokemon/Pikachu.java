package model.Pokemon;

import model.PokemonBase;
import model.SpecialPowerBase;
import model.TypeEnum;

public class Pikachu extends PokemonBase {

    public Pikachu(int id, String name, int health, int damage, TypeEnum type, SpecialPowerBase specialPowerBase) {
        super(id, name, health, damage, type, specialPowerBase);
    }
}
