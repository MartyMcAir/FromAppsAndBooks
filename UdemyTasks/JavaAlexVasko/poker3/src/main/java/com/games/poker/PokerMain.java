package com.games.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerMain {

    private static List<Card> deckOfCards = new ArrayList<>();

    public static void main(String[] args) {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deckOfCards.add(new Card(rank, suit));
            }
        }

        Hand.setComparisonStrategy(new GameStrategy());

        List<Hand> handList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Collections.shuffle(deckOfCards);
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                builder.append(deckOfCards.get(j)).append(" ");
            }
            Hand hand = Hand.fromString(builder.toString());
            handList.add(hand);
        }
        Collections.sort(handList);
        Collections.reverse(handList);
        printHands(handList);
    }

    private static void printDeck(List<Card> deckOfCards) {
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : "  ");
        }
    }

    private static void printHands(List<Hand> hands) {
        for (Hand hand : hands) {
            System.out.println(hand);
        }
    }
}
