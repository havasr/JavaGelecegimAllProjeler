package service;
import model.Character;
import model.Players;

public class PlayerService {
    public Players createPlayer(String name, Character character){
        return new Players(name, character, false);

    }
}
