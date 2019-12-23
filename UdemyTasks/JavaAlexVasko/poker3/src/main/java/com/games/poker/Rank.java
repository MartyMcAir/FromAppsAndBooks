package com.games.poker;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Rank {

    DEUCE('2', 1), THREE('3', 2), FOUR('4', 3), FIVE('5', 4), SIX('6', 5), SEVEN('7', 6), EIGHT('8', 7), NINE('9', 8), TEN('T', 9), JACK('J', 10), QUEEN('Q', 11), KING('K', 12), ACE('A', 13);

    private static final Map<Character, Rank> symbolToEnum = Stream.of(values()).collect(toMap(Rank::getSymbol, e -> e));
    private char symbol;
    private int weight;

    Rank(char c, int w) {
        symbol = c;
        weight = w;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Rank fromSymbol(char symbol) {
        Rank rank = symbolToEnum.get(symbol);
        if (rank != null) {
            return rank;
        } else {
            throw new IllegalArgumentException("Card rank with symbol " + symbol + "doesn't exist");
        }
    }

    public int getWeight() {
        return weight;
    }
}
