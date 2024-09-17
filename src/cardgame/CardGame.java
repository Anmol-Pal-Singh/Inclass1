/*Name-Anmol Pal Singh
Student_id-991741917*/

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import java.util.Random;
import java.util.Scanner;


public class CardGame {
      
    private Card[] hand;
    private static final int HAND_SIZE = 7;
    private static final Card.Suit[] suits = Card.Suit.values();

    public CardGame() {
        hand = new Card[HAND_SIZE];
        generateHand();
    }

    private void generateHand() {
        Random random = new Random();
        for (int i = 0; i < HAND_SIZE; i++) {
            Card.Suit suit = suits[random.nextInt(suits.length)];
            Card.Value value = getRandomValue(random);
            hand[i] = new Card(value, suit);
        }
    }
    
    private Card.Value getRandomValue(Random random) {
        return Card.Value.values()[random.nextInt(Card.Value.values().length - 1)];
    }

    public void printHand() {
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }
    }
    public boolean searchCard(Card.Value value, Card.Suit suit) {
        for (Card card : hand) {
            if (card.getValue() == value && card.getSuit() == suit) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printHand();
         Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a card value (ACE, TWO, THREE, ... KING):");
        String valueInput = scanner.nextLine().toUpperCase();
        Card.Value selectedValue = Card.Value.valueOf(valueInput);

        System.out.println("Pick a suit (HEARTS, CLUBS, SPADES, DIAMONDS):");
        String suitInput = scanner.nextLine().toUpperCase();
        Card.Suit selectedSuit = Card.Suit.valueOf(suitInput);

        // Search for the card in the hand
        if (game.searchCard(selectedValue, selectedSuit)) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is NOT in the magic hand.");
        }
    }
}
    
    

