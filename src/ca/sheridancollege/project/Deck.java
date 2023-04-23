package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void createDeck() {
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Draw Two", "Reverse", "Wild", "Wild Draw Four"};

        for (String color : colors) {
            for (String value : values) {
                if (!value.equals("Wild") && !value.equals("Wild Draw Four")) {
                    for (int i = 0; i < 2; i++) {
                        cards.add(new UnoCard(color, value));
                    }
                } else {
                    cards.add(new UnoCard(color, value));
                }
            }
        }
        Collections.shuffle(cards);
    }
    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        } else {
            return cards.remove(0);
        }
    }

    public int getSize() {
        return cards.size();
    }
}