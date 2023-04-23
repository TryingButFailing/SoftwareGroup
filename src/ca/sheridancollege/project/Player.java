package ca.sheridancollege.project;

import java.util.ArrayList;
public abstract class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void drawCard(Card card) {
        hand.addCard(card);
    }

    public Card chooseCard(String color, String value) {
        ArrayList<Card> cards = hand.getCards();

        for (Card card : cards) {
            if (card instanceof UnoCard) {
                UnoCard unoCard = (UnoCard) card;
                if (unoCard.getColor().equals(color) || unoCard.getValue().equals(value) || unoCard.getColor().equals("Wild")) {
                    return card;
                }
            }
        }

        return null;
    }

    public abstract void play();
}
