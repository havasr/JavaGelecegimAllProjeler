package service;

import model.Player;
import model.PokemonBase;
import model.Weather;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameService {
    LoadService loadService = new LoadService();

    public boolean isBeginner() {
        Random random = new Random();
        int beginner = random.nextInt(2) + 1;
        if (beginner == 1) {
            return true;
        } else return false;
    }

    public void chooseBeginner(Player player1, Player player2, Player attacker, Player defender){
        if (isBeginner()) {
            attacker.setName(player1.getName());
            attacker.setCharacter(player1.getCharacter());
            attacker.setWinner(player1.isWinner());
            defender.setName(player2.getName());
            defender.setCharacter(player2.getCharacter());
            defender.setWinner(player2.isWinner());
        } else {
            attacker.setName(player2.getName());
            attacker.setCharacter(player2.getCharacter());
            attacker.setWinner(player2.isWinner());
            defender.setName(player1.getName());
            defender.setCharacter(player1.getCharacter());
            defender.setWinner(player1.isWinner());
        }
    }

    //playRound method switches players after every attack
    public void playRound(int roundNumber, Player attacker, Player defender, Player winner, Player loser) {
        GameService gameService = new GameService();
        Scanner input = new Scanner(System.in);
        boolean a = true;
        while (a) {
            System.out.println("\n" + attacker.getName() + "'s turn.\n");
            System.out.println("Do you want to use the special power of your character?");
            boolean useCharPower = useSpecialPower();

            System.out.println("Do you want to use the special power of your pokemon?");
            boolean usePokePower = useSpecialPower();

            gameService.attack(attacker, defender, usePokePower, useCharPower);

            if (roundNumber == 1){
                a = healthCheckRoundOne(attacker, defender, winner, loser);
            } else {
                a = healthCheckRoundTwo(attacker, defender,winner, loser);

            }

            Player[] players = {attacker, defender};
            gameService.switchRoles(players);
            attacker = players[0];
            defender = players[1];
        }
    }

    //Asks user if they want to use special power
    public boolean useSpecialPower(){
        Scanner input = new Scanner(System.in);
        System.out.println("1- YES 2-NO");
        int choice = input.nextInt();
        boolean useCharPower = false;
        if (choice == 1) {
            useCharPower = true;
        }
        return useCharPower;
    }

    public void attack(Player attacker, Player defender, boolean isPokeSpecialPower, boolean isCharSpecialPower) {
        PokemonBase attackingPokemonBase = attacker.getCharacter().getPokemonList().get(0);
        PokemonBase defendingPokemonBase = defender.getCharacter().getPokemonList().get(0);

       //A random weather is given in every attack
        Weather weather = randomWeather();

        boolean specialAttack = false;
        //Acts based on the choice of the user to use specialPower
        if (isPokeSpecialPower && isCharSpecialPower) {
            specialAttack = attackingPokemonBase.getSpecialPower().getRemainRight() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainRight() > 0;
        } else if (isPokeSpecialPower) {
            specialAttack = attackingPokemonBase.getSpecialPower().getRemainRight() > 0;
        } else if (isCharSpecialPower) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainRight() > 0;
        }

        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainRight();

        int damage = 0;
        //Acts based on if the user has specialPower
        if (specialAttack) {
            if (isPokeSpecialPower && isCharSpecialPower) {
                damage += attackingPokemonBase.specialAttack();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainRight(charRemainingRights - 1);
            } else if (isPokeSpecialPower) {
                damage += attackingPokemonBase.specialAttack();
            } else {
                damage += attackingPokemonBase.getDamage();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainRight(charRemainingRights - 1);
            }
        } else {
            if (isPokeSpecialPower || isCharSpecialPower) {
                damage = 0;
            } else {
                damage += attackingPokemonBase.getDamage();
            }
        }
        //If the weather is the weaknessWeather of the defending pokemon then decreases the health accordingly
        if (weather.getName().equals(defendingPokemonBase.getType().getWeaknessWeather())) {
            damage += weather.getEffect();
        }
        defendingPokemonBase.setHealth(defendingPokemonBase.getHealth() - damage);
    }

    public Weather randomWeather() {
        ArrayList<Weather> weatherList = loadService.loadWeather();
        Random random = new Random();
        Weather weather = weatherList.get(random.nextInt(weatherList.size()));
        System.out.println("\nThe weather is " + weather + " today!");
        return weather;
    }

    //Checks the health of the players in round one
    public boolean healthCheckRoundOne(Player attacker, Player defender, Player winner, Player loser) {
        GameService gameService = new GameService();
        if (!gameService.isDead(defender)) {
            System.out.println(defender.getName() + " has been defeated. " + attacker.getName() + " has won the first round!");
            winner.setName(attacker.getName());
            winner.setCharacter(attacker.getCharacter());
            winner.setWinner(attacker.isWinner());
            loser.setName(defender.getName());
            loser.setCharacter(defender.getCharacter());
            loser.setWinner(defender.isWinner());
            winner.setWinner(true);
            return false;
        } else {
            System.out.println(attacker.getName() + " has made their move. The game continues!");
            return true;
        }
    }

    //Checks the health of the players in round two.
    public boolean healthCheckRoundTwo(Player attacker, Player defender, Player winner, Player loser){
        GameService gameService = new GameService();
        if (!gameService.isDead(defender)) {
            //If the defender is the winner from the first round then changes their main pokemon.
            if (defender.isWinner()) {
                defender.getCharacter().getPokemonList().remove(0);
                //If the winner from the first round isDead for a second time, they lose.
                if (defender.getCharacter().getPokemonList().isEmpty()) {
                    System.out.println(defender.getName() + " has been defeated. " + attacker.getName() + " has won the second round!");
                    winner.setName(attacker.getName());
                    winner.setCharacter(attacker.getCharacter());
                    winner.setWinner(attacker.isWinner());
                    loser.setName(defender.getName());
                    loser.setCharacter(defender.getCharacter());
                    loser.setWinner(defender.isWinner());
                    return false;
                }
            } else {
                System.out.println(defender.getName() + " has been defeated. " + attacker.getName() + " has won the second round!");
                winner.setName(attacker.getName());
                winner.setCharacter(attacker.getCharacter());
                winner.setWinner(attacker.isWinner());
                loser.setName(defender.getName());
                loser.setCharacter(defender.getCharacter());
                loser.setWinner(defender.isWinner());
                return false;
            }
        } else {
            System.out.println(attacker.getName() + " has made their move. The game continues!");
            return true;
        }
        return true;
    }


    public boolean isDead(Player player) {
        if (player.getCharacter().getPokemonList().get(0).getHealth() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void switchRoles(Player[] players) {
        Player temp = players[0];
        players[0] = players[1];
        players[1] = temp;
    }

    public void transferPokemon(Player winner, Player loser, ArrayList<PokemonBase> pokemonBaseList) {
        GameService gameService = new GameService();

        loser.getCharacter().getPokemonList().get(0).setHealth(100);
        winner.getCharacter().getPokemonList().add(loser.getCharacter().getPokemonList().get(0));
        loser.getCharacter().getPokemonList().remove(0);
        PokemonBase weakestPokemonBase = gameService.chooseWeakestPokemon(pokemonBaseList);
        loser.getCharacter().getPokemonList().add(weakestPokemonBase);
    }

    public PokemonBase chooseWeakestPokemon(ArrayList<PokemonBase> pokemonBaseList) {
        PokemonBase weakestPokemonBase = pokemonBaseList.get(0);
        int weakestDamage = pokemonBaseList.get(0).getDamage();

        for (int i = 0; i < pokemonBaseList.size(); i++) {
            if (pokemonBaseList.get(i).getDamage() < weakestDamage) {
                weakestDamage = pokemonBaseList.get(i).getDamage();
                weakestPokemonBase = pokemonBaseList.get(i);
            }
        }
        return weakestPokemonBase;
    }


}

