package model.Pokemon;

import model.PokemonBase;
import model.SpecialPowerBase;
import model.TypeEnum;

public class Gengar extends PokemonBase {

    public Gengar(int id, String name, int health, int damage, TypeEnum type, SpecialPowerBase specialPowerBase) {
        super(id, name, health, damage, type, specialPowerBase);
    }
}
