package model;

public class Player {
    private String name;
    private CharacterBase characterBase;
    private boolean isWinner;

    public Player(String name, CharacterBase characterBase, boolean isWinner) {
        this.name = name;
        this.characterBase = characterBase;
        this.isWinner = false;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterBase getCharacter() {
        return characterBase;
    }

    public void setCharacter(CharacterBase characterBase) {
        this.characterBase = characterBase;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    @Override
    public String toString() {
        return "Players{" +
                "name='" + name + '\'' +
                ", character=" + characterBase +
                ", isWinner=" + isWinner +
                '}';
    }
}
