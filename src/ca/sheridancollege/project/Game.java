package ca.sheridancollege.project;

import ca.sheridancollege.project.*;

import java.util.ArrayList;
import java.util.Collections;

class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private String currentColor;
    private String currentValue;
    private int currentPlayerIndex;

    public Game(ArrayList<String> playerNames) {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        for (String name : playerNames) {
            if (name.equals("Player 1")) {
                players.add(new HumanPlayer(name));
            } else {
                players.add(new ComputerPlayer(name));
            }
        }

        deck.createDeck();
        currentColor = deck.drawCard().getColor();
        currentValue = deck.drawCard().getValue();
        currentPlayerIndex = 0;
    }

    public void play() {
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);

            System.out.println("Current color: " + currentColor);
            System.out.println("Current value: " + currentValue);
            System.out.println(currentPlayer.getName() + "'s turn");

            Card chosenCard;
            if (currentPlayer.getName().equals("Player 1")) {
                chosenCard = currentPlayer.chooseCard(currentColor, currentValue);
            } else {
                chosenCard = currentPlayer.chooseCard(null, null);
            }

            if (chosenCard == null) {
                System.out.println(currentPlayer.getName() + " drew a card");
                Card drawnCard = deck.drawCard();
                currentPlayer.drawCard(drawnCard);

                if (drawnCard instanceof UnoCard) {
                    UnoCard unoCard = (UnoCard) drawnCard;
                    if (unoCard.getColor().equals(currentColor) || unoCard.getValue().equals(currentValue) || unoCard.getColor().equals("Wild")) {
                        System.out.println(currentPlayer.getName() + " played " + drawnCard.getDescription());
                        currentPlayer.getHand().removeCard(drawnCard);
                        currentColor = unoCard.getColor();
                        currentValue = unoCard.getValue();
                    }
                }

                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            } else {
                if (chosenCard instanceof UnoCard) {
                    UnoCard unoCard = (UnoCard) chosenCard;
                    System.out.println(currentPlayer.getName() + " played " + chosenCard.getDescription());
                    currentPlayer.getHand().removeCard(chosenCard);
                    currentColor = unoCard.getColor();
                    currentValue = unoCard.getValue();

                    if (currentPlayer.getHand().getSize() == 0) {
                        System.out.println(currentPlayer.getName() + " won!");
                        return;
                    }

                    if (currentValue.equals("Reverse")) {
                        Collections.reverse(players);
                        currentPlayerIndex = players.indexOf(currentPlayer);
                    } else if (currentValue.equals("Skip")) {
                        currentPlayerIndex = (currentPlayerIndex + 2) % players.size();
                    } else if (currentValue.equals("Draw Two")) {
                        Player nextPlayer = players.get((currentPlayerIndex + 1) % players.size());
                        nextPlayer.drawCard(deck.drawCard());
                        nextPlayer.drawCard(deck.drawCard());
                        currentPlayerIndex = (currentPlayerIndex + 2) % players.size();
                    }
                }
            }
        }
    }
}
