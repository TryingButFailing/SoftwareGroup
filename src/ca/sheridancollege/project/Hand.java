package ca.sheridancollege.project;

import java.util.ArrayList;

class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getCard(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.get(index);
        } else {
            return null;
        }
    }

    public int getSize() {
        return cards.size();
    }

    @Override
    public String toString() {
        String result = "";
        for (Card card : cards) {
            result += card.getDescription() + " ";
        }
        return result;
    }
}