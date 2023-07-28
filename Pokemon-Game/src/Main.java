import model.CharacterBase;
import model.Player;
import model.PokemonBase;
import service.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();

        // Load characters and Pokemon
        ArrayList<CharacterBase> characterBaseList = loadService.loadCharacters();
        ArrayList<PokemonBase> pokemonBaseList = loadService.loadPokemons();

        System.out.println("\nWelcome! \nAre you ready to become a Pokemon master? Let the journey begin!");

        //First Player enters name, chooses Character and Pokemon
        System.out.print("\nFor Player 1, Enter your name: ");
        Player player1 = playerService.chooseCharacterAndPokemonForPlayer(characterBaseList, pokemonBaseList);

        //Second Player enters name, chooses Character and Pokemon
        System.out.println("");
        System.out.print("For Player 2, Enter your name: ");
        Player player2 = playerService.chooseCharacterAndPokemonForPlayer(characterBaseList, pokemonBaseList);

        //The first round starts
        System.out.println("REMINDER: If you try to overuse your Special Power, your attack will be blocked.");
        System.out.println("\nLet the Pokemon battle begin!");
        System.out.println("\nROUND 1");

        Player attackerRoundOne = new Player();
        Player defenderRoundOne = new Player();

        //Choosing the player that starts randomly

        gameService.chooseBeginner(player1, player2, attackerRoundOne, defenderRoundOne);

        Player winnerRoundOne = new Player();
        Player loserRoundOne = new Player();

        gameService.playRound(1, attackerRoundOne, defenderRoundOne, winnerRoundOne, loserRoundOne);

        //The second round starts
        System.out.println("\nROUND 2");

        gameService.transferPokemon(winnerRoundOne, loserRoundOne, pokemonBaseList);

        Player attackerRoundTwo = new Player();
        Player defenderRoundTwo = new Player();

        //Choosing the player that starts randomly
        gameService.chooseBeginner(winnerRoundOne, loserRoundOne, attackerRoundTwo, defenderRoundTwo);

        Player winnerRoundTwo = new Player();
        Player loserRoundTwo = new Player();

        gameService.playRound(2, attackerRoundTwo, defenderRoundTwo, winnerRoundTwo, loserRoundTwo);

        System.out.println("\nTHE BATTLE HAS ENDED!");
        if (winnerRoundOne == winnerRoundTwo) {
            System.out.println("\n" + winnerRoundOne.getName() + " has become the new Pokemon master!");
        } else {
            System.out.println("It's tie! No one became the Pokemon master.");
        }
    }
}
