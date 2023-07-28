package model.Pokemon;

import model.PokemonBase;
import model.SpecialPowerBase;
import model.TypeEnum;

public class Eevee extends PokemonBase {

    public Eevee(int id, String name, int health, int damage, TypeEnum type, SpecialPowerBase specialPowerBase) {
        super(id, name, health, damage, type, specialPowerBase);
    }
}
