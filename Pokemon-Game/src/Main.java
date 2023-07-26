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
        ArrayList<Weather> weatherList = loadService.loadWeather();

        System.out.println("\nWelcome! \nAre you ready to become a Pokemon master? Let the journey begin!");
        //FOR FIRST PLAYER
        System.out.print("For Player 1, Enter your name: ");
        String name1 = input.nextLine();
        System.out.println("Welcome " + name1 + "!\n");


        //Character is chosen
        System.out.println("Choose your character:");
        System.out.println("---------------Characters---------------");
        for (Character character : characterList) {
            System.out.println(character.toString());
        }
        int inputChar1 = input.nextInt();
        Character character1 = characterService.chooseCharacter(characterList, inputChar1);
        characterList.remove(character1);

        //Pokemon is chosen
        System.out.println("Choose your Pokemon:");
        System.out.println("------------------------------Pokemon------------------------------");
        for (Pokemon pokemon : pokemonList) {
            System.out.println(pokemon.toString());
        }
        int inputPoke1 = input.nextInt();
        Pokemon pokemon1 = pokemonService.choosePokemon(pokemonList, inputPoke1);
        pokemonList.remove(pokemon1);
        character1.getPokemonList().add(pokemon1);

        System.out.println("\nGreat! You're character is " + character1.getName() + " and you're pokemon is " + pokemon1.getName());

        //SECOND PLAYER
        System.out.println("");
        System.out.print("For Player 2, Enter your name: ");
        input.nextLine();
        String name2 = input.nextLine();
        System.out.println("Welcome " + name2 + "!\n");

        //Character chosen
        System.out.println("Choose your character:");
        System.out.println("---------------Characters---------------");
        for (Character character : characterList) {
            System.out.println(character.toString());
        }
        int inputChar2 = input.nextInt();
        Character character2 = characterService.chooseCharacter(characterList, inputChar2);

        //Pokemon chosen
        System.out.println("Choose your Pokemon:");
        System.out.println("------------------------------Pokemon------------------------------");
        for (Pokemon pokemon : pokemonList) {
            System.out.println(pokemon.toString());
        }
        int inputPoke2 = input.nextInt();
        Pokemon pokemon2 = pokemonService.choosePokemon(pokemonList, inputPoke2);
        character2.getPokemonList().add(pokemon2);

        System.out.println("\nGreat! You're character is " + character2.getName() + " and you're pokemon is " + pokemon2.getName());

        Player player1 = playerService.createPlayer(name1, character1);
        Player player2 = playerService.createPlayer(name2, character2);

        if (gameService.chooseBegginer() == 1) {
           // player1 start
        } else {
            //player2 start
        }

       // while ()

        System.out.println("Do you want to use to special power of your character?");
        System.out.println("1- YES 2-NO");
        int charPower = input.nextInt();
        boolean useCharPower = false;
        if (charPower==1){
            useCharPower = true;
        }

        System.out.println("Do you want to use to special power of your pokemon?");
        System.out.println("1- YES 2-NO");
        int pokePower = input.nextInt();
        boolean usePokePower = false;
        if (pokePower==1){
            usePokePower = true;
        }

        gameService.attack(player1, player2, usePokePower, useCharPower);
        gameService.healthCheck(player2);

    }
}