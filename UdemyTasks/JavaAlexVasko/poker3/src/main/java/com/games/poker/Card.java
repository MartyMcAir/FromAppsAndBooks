package com.games.poker;

import java.util.Arrays;
import java.util.List;

public class Card implements Comparable<Card> {

    private final Suit suit;
    private final Rank rank;

    Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    public static Card fromString(String str) {
        char[] chars = str.toCharArray();
        return new Card(Rank.fromSymbol(chars[0]), Suit.fromSymbol(chars[1]));
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        if (suit != card.suit) return false;
        return rank == card.rank;
    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }


    @Override
    public int compareTo(Card card) {
        Rank[] values = Rank.values();
        List<Rank> ranks = Arrays.asList(values);
        if (ranks.indexOf(this.rank) < ranks.indexOf(card.getRank())) {
            return -1;
        } else if (ranks.indexOf(this.rank) > ranks.indexOf(card.getRank())) {
            return +1;
        } else if (ranks.indexOf(this.rank) == ranks.indexOf(card.getRank())) {
            return String.valueOf(suit).compareTo(String.valueOf(card.getSuit()));
        }
        return 0;
    }

    @Override
    public String toString() {
        return rank.getSymbol() + String.valueOf(suit.getSymbol());
    }
}
