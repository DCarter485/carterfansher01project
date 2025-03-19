package carterfansherproject;

import java.util.Random;

public class CarterFansherProject {
    public static void main(String[] args) {
        String[] deck = newDeck();
        System.out.println("Original Deck:");
        printDeck(deck);

        deck = newDeck();
        shuffleDeck(deck);
        System.out.println("\nShuffle 1:");
        printDeck(deck);

        deck = newDeck();
        shuffleDeck(deck);
        System.out.println("\nShuffle 2:");
        printDeck(deck);

        deck = newDeck();
        System.out.println("\nFive Random Hands:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Hand " + (i + 1) + ": ");
            for (int j = 0; j < 5; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(draw(deck, deal(deck)));
            }
            System.out.println();
        }
    }

    public static String[] newDeck() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] deck = new String[52];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static String draw(String[] deck, int index) {
        if (deck[index] == null) return "Card already drawn";
        String card = deck[index];
        deck[index] = null;
        return card;
    }

    public static void printCard(String[] deck, int index) {
        System.out.println(draw(deck, index));
    }

    public static void printDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i]);
        }
        System.out.println();
    }

    public static int deal(String[] deck) {
        Random rand = new Random();
        int index;
        do {
            index = rand.nextInt(52);
        } while (deck[index] == null);
        return index;
    }

    public static void shuffleDeck(String[] deck) {
        Random rand = new Random();
        for (int i = 51; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }
}
