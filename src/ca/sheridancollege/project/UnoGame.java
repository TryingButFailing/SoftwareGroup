package ca.sheridancollege.project;

import java.util.ArrayList;

public class UnoGame {
    public static void main(String[] args) {
        ArrayList<String> playerNames = new ArrayList<>();
        playerNames.add("Player 1");
        playerNames.add("Player 2");
        Game game = new Game(playerNames);
        game.play();
    }
}
