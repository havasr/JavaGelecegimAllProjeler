import model.Character;
import model.Player;
import model.Pokemon;
import model.Weather;
import service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();
        CharacterService characterService = new CharacterService();
        PokemonService pokemonService = new PokemonService();
        Scanner input = new Scanner(System.in);

        // Load characters, Pokemon, weather
        ArrayList<model.Character> characterList = loadService.loadCharacters();
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();

        System.out.println("\nWelcome! \nAre you ready to become a Pokemon master? Let the journey begin!");

        //FOR FIRST PLAYER
        boolean a = true;
        Player player1 = new Player();

        while (a) {
            System.out.print("For Player 1, Enter your name: ");
            String name1 = input.nextLine();
            System.out.println("Welcome " + name1 + "!\n");

            //Character1 is chosen
            System.out.println("Choose your character:");
            System.out.println("---------------Characters---------------");
            int indexC1 = 1;
            for (Character character : characterList) {
                System.out.println(indexC1 + character.toString());
                indexC1++;
            }
            int inputChar1 = input.nextInt();
            Character character1 = characterService.chooseCharacter(characterList, inputChar1);

            //Pokemon1 is chosen
            System.out.println("Choose your Pokemon:");
            System.out.println("------------------------------Pokemon------------------------------");
            int indexP1 = 1;
            for (Pokemon pokemon : pokemonList) {
                System.out.println(indexP1 + pokemon.toString());
                indexP1++;
            }
            int inputPoke1 = input.nextInt();
            Pokemon pokemon1 = pokemonService.choosePokemon(pokemonList, inputPoke1);

            System.out.println("\nGreat! You're character is " + character1.getName() + " and you're pokemon is " + pokemon1.getName());
            System.out.println("Choose 1 to continue, 2 to re-enter.");
            int choice1 = input.nextInt();
            input.nextLine();

            switch (choice1) {
                case 1:
                    System.out.println("Awesome! The game continues!");
                    characterList.remove(character1);
                    pokemonList.remove(pokemon1);
                    character1.getPokemonList().add(pokemon1);
                    player1 = playerService.createPlayer(name1, character1);
                    a = false;
                    break;

                case 2:
                    System.out.println("Please re-enter your information.");
                    break;

                default:
                    System.out.println("Wrong input, try again.");
                    break;
            }
        }

        //SECOND PLAYER
        boolean b = true;
        Player player2 = new Player();

        while (b) {
            System.out.println("");
            System.out.print("For Player 2, Enter your name: ");
            String name2 = input.nextLine();
            System.out.println("Welcome " + name2 + "!\n");

            //Character2 chosen
            System.out.println("Choose your character:");
            System.out.println("---------------Characters---------------");
            int indexC2 = 1;
            for (Character character : characterList) {
                System.out.println(indexC2 + character.toString());
                indexC2++;
            }
            int inputChar2 = input.nextInt();
            Character character2 = characterService.chooseCharacter(characterList, inputChar2);

            //Pokemon2 chosen
            System.out.println("Choose your Pokemon:");
            System.out.println("------------------------------Pokemon------------------------------");
            int indexP2 = 1;
            for (Pokemon pokemon : pokemonList) {
                System.out.println(indexP2 + pokemon.toString());
                indexP2++;
            }
            int inputPoke2 = input.nextInt();
            Pokemon pokemon2 = pokemonService.choosePokemon(pokemonList, inputPoke2);

            System.out.println("\nGreat! You're character is " + character2.getName() + " and you're pokemon is " + pokemon2.getName());
            System.out.println("Choose 1 to continue, 2 to re-enter.");
            int choice2 = input.nextInt();
            input.nextLine();

            switch (choice2) {
                case 1:
                    characterList.remove(character2);
                    pokemonList.remove(pokemon2);
                    character2.getPokemonList().add(pokemon2);
                    player2 = playerService.createPlayer(name2, character2);
                    b = false;
                    break;

                case 2:
                    System.out.println("Please re-enter your information.");
                    break;

                default:
                    System.out.println("Wrong input, try again.");
                    break;
            }
        }

        System.out.println("\nLet the Pokemon battle begin!\n");
        System.out.println("ROUND 1");

        Player attacker1 = new Player();
        Player defender1 = new Player();

        if (gameService.isBeginner(player1)) {
            attacker1 = player1;
            defender1 = player2;
        } else {
            attacker1 = player2;
            defender1 = player1;
        }

        Player winner1 = new Player();
        Player loser1 = new Player();

        boolean c = true;
        while (c) {
            System.out.println("\n" + attacker1.getName() + "'s turn.\n");
            System.out.println("Do you want to use the special power of your character?");
            System.out.println("1- YES 2-NO");
            int charPower = input.nextInt();
            boolean useCharPower = false;
            if (charPower == 1) {
                useCharPower = true;
            }

            System.out.println("Do you want to use the special power of your pokemon?");
            System.out.println("1- YES 2-NO");
            int pokePower = input.nextInt();
            boolean usePokePower = false;
            if (pokePower == 1) {
                usePokePower = true;
            }

            gameService.attack(attacker1, defender1, usePokePower, useCharPower);

            if (!gameService.healthCheck(defender1)) {
                System.out.println(defender1.getName() + " has been defeated. " + attacker1.getName() + " has won the first round!");
                winner1 = attacker1;
                loser1 = defender1;
                c = false;
            } else {
                System.out.println(attacker1.getName() + " has made their move. The game continues!");
            }

            Player[] players = {attacker1, defender1};
            gameService.switchRoles(players);
            attacker1 = players[0];
            defender1 = players[1];

        }

        System.out.println("ROUND 2");

        loser1.getCharacter().getPokemonList().get(0).setHealth(100);
        winner1.getCharacter().getPokemonList().add(loser1.getCharacter().getPokemonList().get(0));
        loser1.getCharacter().getPokemonList().remove(0);
        Pokemon weakestPokemon = gameService.chooseWeakestPokemon(pokemonList);
        loser1.getCharacter().getPokemonList().add(weakestPokemon);

        Player attacker2 = new Player();
        Player defender2 = new Player();

        if (gameService.isBeginner(winner1)) {
            attacker2 = winner1;
            defender2 = loser1;
        } else {
            attacker2 = loser1;
            defender2 = winner1;
        }

        Player winner2 = new Player();
        Player loser2 = new Player();

        boolean d = true;
        while (d) {
            System.out.println("\n" + attacker2.getName() + "'s turn.\n");
            System.out.println("Do you want to use the special power of your character?");
            System.out.println("1- YES 2-NO");
            int charPower = input.nextInt();
            boolean useCharPower = false;
            if (charPower == 1) {
                useCharPower = true;
            }

            System.out.println("Do you want to use the special power of your pokemon?");
            System.out.println("1- YES 2-NO");
            int pokePower = input.nextInt();
            boolean usePokePower = false;
            if (pokePower == 1) {
                usePokePower = true;

            }

            gameService.attack(attacker2, defender2, usePokePower, useCharPower);

            if (!gameService.healthCheck(defender2)) {
                if (defender2 == winner1) {
                    defender2.getCharacter().getPokemonList().remove(0);
                    if (defender2.getCharacter().getPokemonList().isEmpty()) {
                        System.out.println(defender2.getName() + " has been defeated. " + attacker2.getName() + " has won the second round!");
                        winner2 = attacker2;
                        loser2 = defender2;
                        d = false;
                        break;
                    }
                } else {
                    System.out.println(defender2.getName() + " has been defeated. " + attacker2.getName() + " has won the second round!");
                    winner2 = attacker2;
                    loser2 = defender2;
                    d = false;
                    break;
                }
            }

            System.out.println(attacker2.getName() + " has made their move. The game continues!");

            Player[] players = {attacker2, defender2};
            gameService.switchRoles(players);
            attacker2 = players[0];
            defender2 = players[1];
        }

        System.out.println("\nTHE BATTLE HAS ENDED!");
        if (winner1==winner2){
            System.out.println("\n"+ winner1.getName()+ " has become the new Pokemon master!");
        } else {
            System.out.println("It's tie! No one became the Pokemon master.");
        }
    }
}
