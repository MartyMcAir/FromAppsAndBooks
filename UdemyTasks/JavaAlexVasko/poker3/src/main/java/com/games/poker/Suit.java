package com.games.poker;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Suit {

    SPADES('C'), CLUBS('D'), DIMONDS('H'), HEARTS('S');

    private char symbol;
    private static final Map<Character, Suit> symbolToEnum = Stream.of(values()).collect(toMap(Suit::getSymbol,e->e));

    Suit(char c) {
        symbol = c;
    }

    public char getSymbol(){
        return symbol;
    }

    public static Suit fromSymbol(char symbol){
        Suit suit = symbolToEnum.get(symbol);
        if(suit != null){
            return suit;
        } else {
            throw new IllegalArgumentException("Card suit with symbol "+symbol+" doesn't exist");
        }
    }


}
