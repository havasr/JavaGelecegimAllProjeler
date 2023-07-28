package service;
import model.Player;
import model.Pokemon;
import model.Weather;

import java.util.ArrayList;
import java.util.Random;

public class GameService {
    LoadService loadService = new LoadService();

    public void attack(Player attacker, Player defender, boolean isPokeSpecialAttack, boolean isCharSpecialAttack) {
        Pokemon attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(0);

        Weather weather = randomWeather();

        boolean specialAttack = false;
        //Kullanmak istiyor mu?
        if (isPokeSpecialAttack && isCharSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainRight() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainRight() > 0;
        } else if (isPokeSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainRight() > 0;
        } else if (isCharSpecialAttack) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainRight() > 0;
        }

        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainRight();

        int damage = 0;
        //Hakki var mi?
        if (specialAttack) {
            if (isPokeSpecialAttack && isCharSpecialAttack) {
                damage += attackingPokemon.specialAttack();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainRight(charRemainingRights - 1);
            } else if (isPokeSpecialAttack) {
       //azaltma zaten specialAttack icinde yapiliyor
                damage += attackingPokemon.specialAttack();
            } else {
                damage += attackingPokemon.getDamage();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainRight(charRemainingRights - 1);
            }
        } else {
            //Hakki yoksa
            if (isPokeSpecialAttack || isCharSpecialAttack) {
                damage = 0;
            } else {
                damage += attackingPokemon.getDamage();
            }
        }
        if (weather.getName().equals(defendingPokemon.getType().getWeaknessWeather())){
            damage += weather.getEffect();
        }
        defendingPokemon.setHealth(defendingPokemon.getHealth() - damage);
    }

    public boolean healthCheck(Player player) {
        if (player.getCharacter().getPokemonList().get(0).getHealth() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public Weather randomWeather(){
        ArrayList<Weather> weatherList = loadService.loadWeather();
        Random random = new Random();
        Weather weather = weatherList.get(random.nextInt(weatherList.size()));
        System.out.println("\nThe weather is " + weather + " today!");
        return weather;
    }

    public boolean isBeginner(Player player1){
        Random random = new Random();
        int beginner = random.nextInt(2) + 1;
        if (beginner==1){
            return true;
        } else return false;
    }


    public void switchRoles(Player[] players) {
        Player temp = players[0];
        players[0] = players[1];
        players[1] = temp;
    }

    public Pokemon chooseWeakestPokemon(ArrayList<Pokemon> pokemonList){
            Pokemon weakestPokemon = pokemonList.get(0);
            int weakestDamage = pokemonList.get(0).getDamage();

            for (int i = 0; i < pokemonList.size(); i++){
            if (pokemonList.get(i).getDamage() < weakestDamage){
                weakestDamage = pokemonList.get(i).getDamage();
                weakestPokemon = pokemonList.get(i);
            }
        }
            return weakestPokemon;
    }
}


