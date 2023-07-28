package service;

import model.CharacterBase;
import model.Player;
import model.PokemonBase;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerService {

    CharacterService characterService = new CharacterService();
    PokemonService pokemonService = new PokemonService();

    public Player createPlayer(String name, CharacterBase characterBase) {
        return new Player(name, characterBase, false);

    }

    //chooseCharacterAndPokemonForPlayer asks user to enter name, choose character and pokemon. Then creates a player.
    public Player chooseCharacterAndPokemonForPlayer(ArrayList<CharacterBase> characterBaseList, ArrayList<PokemonBase> pokemonBaseList) {
        boolean a = true;
        Scanner input = new Scanner(System.in);

        while (a) {
            String name = input.nextLine();
            System.out.println("Welcome " + name + "!\n");

            //Character is chosen
            System.out.println("Choose your character:");
            System.out.println("---------------Characters---------------");
            int indexC = 1;
            for (CharacterBase characterBase : characterBaseList) {
                System.out.println(indexC + characterBase.toString());
                indexC++;
            }
            int inputChar = input.nextInt();
            CharacterBase characterBase = characterService.chooseCharacter(characterBaseList, inputChar);

            //Pokemon is chosen
            System.out.println("Choose your Pokemon:");
            System.out.println("---------------------------------------------------Pokemon---------------------------------------------------");
            int indexP = 1;
            for (PokemonBase pokemonBase : pokemonBaseList) {
                System.out.println(indexP + pokemonBase.toString());
                indexP++;
            }
            int inputPoke1 = input.nextInt();
            PokemonBase pokemonBase = pokemonService.choosePokemon(pokemonBaseList, inputPoke1);

            System.out.println("\nGreat! You're character is " + characterBase.getName() + " and you're pokemon is " + pokemonBase.getName());
            System.out.println("Choose 1 to continue, 2 to re-enter.");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Awesome! The game continues!");
                    characterBaseList.remove(characterBase);
                    pokemonBaseList.remove(pokemonBase);
                    characterBase.getPokemonList().add(pokemonBase);
                    Player player1 = createPlayer(name, characterBase);
                    a = false;
                    return player1;

                case 2:
                    System.out.println("Please re-enter your information.\nEnter your name:");
                    break;

                default:
                    System.out.println("Wrong input, try again.");
                    break;
            }
        }
        return null;
    }


}
