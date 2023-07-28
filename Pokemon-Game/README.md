# Pokemon Game
This project is created as a homework for the Java course in GelecegimAll program. The purpose of the application is to generate a game of Pokemon for two Players.  
Each player picks a character and a Pokemon from a list. One of the two players is randomly selected to start the game.   
The game consists of two rounds. Each round one player attacks the other using the damage power of their Pokemon. This damage can be increased via special powers that their character and Pokemon have individually.
The special power can only be used once per character/Pokemon. If the player tries to reuse it, the attack will be blocked all together.     
In each round the weather is randomly determined. Every pokemon has a weather weakness and is negatively affected by the given weather.   

Once one of the players is defeated the first round ends. The winner of the round gets to keep their Pokemon and also gets to take the losers Pokemon with full health. The loser gets assigned the weakest Pokemon among the remaining ones.  
The second round starts the same as the first one. If the winner from the first round loses one of their Pokemon they get to continue the fight with their second Pokemon.
At the end of the rounds the winner is anounced.
________________________________

## Structure of the project
### Player
The Player class is created with the input received from the user. The recpective fields are name for user name and characterBase for chosen charater. The isWinner field is set after every round and is for determining if the player has won the round. 

### CharacterBase
CharacterBase class holds name and special power of the character as well as the pokemons owned. This class is used as a parent class for characters in the game.

### PokemonBase
PokemonBase class holds name, health, type, damage and special power of the pokemons. This class is used as a parent class for pokemons in the game.

### SpecialPowerBase
SpecialPowerBase class holds name, extraDamage and remainRight. This class is used as a parent class for special powers in the game.
