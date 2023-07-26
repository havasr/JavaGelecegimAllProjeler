import model.Character;
import model.Players;
import model.Pokemon;
import model.Weather;
import service.CharacterService;
import service.GameService;
import service.LoadService;
import service.PlayerService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();
        CharacterService characterService = new CharacterService();
        Scanner input = new Scanner(System.in);

        // Load characters
        ArrayList<model.Character> characterList = loadService.loadCharacters();


        // Load Pokemon
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();
       // System.out.println("\n------Pokemon--------");
       // for (Pokemon pokemon : pokemonList) {
        //    System.out.println(pokemon.toString());
        //}

        // Load Weather
        ArrayList<Weather> weatherList = loadService.loadWeather();

        System.out.println("Welcome! Are you ready to become a Pokemon master? Let the journey begin!");
        System.out.print("Enter your name:");
        String name = input.nextLine();
        System.out.println("Welcome "+ name + "!");
        System.out.println("Choose your character:");
        System.out.println("------Characters------");
        for (Character character : characterList) {
            System.out.println(character.toString());
        }
        int inputChar = input.nextInt();

        Character character1 = characterService.chooseCharacter(characterList, inputChar);

        characterList.get(0).getPokemonList().add(pokemonList.get(0));
        characterList.get(1).getPokemonList().add(pokemonList.get(1));

        //Players player1 = playerService.createPlayer("Tuğçe", characterList.get(0));
        //Players player2 = playerService.createPlayer("Hasan", characterList.get(1));

        //gameService.attack(player1, player2, true, true);

       // gameService.healthCheck(player2);


    }
}