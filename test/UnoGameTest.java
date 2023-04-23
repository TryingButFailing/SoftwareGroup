

import ca.sheridancollege.project.Deck;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class UnoGameTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void testCardGetColor() {
        Card card = new UnoCard("Red", "1");
        Assertions.assertEquals("Red", card.getColor());
    }

    @Test
    void testCardGetValue() {
        Card card = new UnoCard("Red", "1");
        Assertions.assertEquals("1", card.getValue());
    }

    @Test
    void testUnoCardGetDescription() {
        UnoCard card = new UnoCard("Red", "1");
        Assertions.assertEquals("Red 1", card.getDescription());
    }

    @Test
    void testDeckCreateDeck() {
        deck.createDeck();
        Assertions.assertEquals(108, deck.getSize());
    }

    @Test
    void testDeckDrawCard() {
        deck.createDeck();
        int initialSize = deck.getSize();
        Card card = deck.drawCard();
        Assertions.assertNotNull(card);
        Assertions.assertEquals(initialSize - 1, deck.getSize());
    }

    @Test
    void testPlayerDrawCard() {
        Player player = new HumanPlayer("Alice");
        Card card = new UnoCard("Red", "1");
        player.drawCard(card);
        Assertions.assertEquals(1, player.getHand().getSize());
    }

    @Test
    void testHandAddCard() {
        Hand hand = new Hand();
        Card card = new UnoCard("Red", "1");
        hand.addCard(card);
        Assertions.assertEquals(1, hand.getSize());
    }

    @Test
    void testHandRemoveCard() {
        Hand hand = new Hand();
        Card card = new UnoCard("Red", "1");
        hand.addCard(card);
        int initialSize = hand.getSize();
        hand.removeCard(card);
        Assertions.assertEquals(initialSize - 1, hand.getSize());
    }
}

