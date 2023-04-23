package ca.sheridancollege.project;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
        // Get input from the user
        System.out.println("Enter the color and value of the card you want to play, separated by a space:");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        String color = parts[0];
        String value = parts[1];

        // Choose a card to play
        Card card = chooseCard(color, value);

        if (card == null) {
            System.out.println("You don't have a card that matches the color or value.");
        } else {
            System.out.println("You played: " + card.getDescription());
            getHand().removeCard(card);
        }
    }
}
