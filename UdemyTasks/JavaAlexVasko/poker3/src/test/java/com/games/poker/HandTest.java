package com.games.poker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {


    @Test
    public void handValueCalculationTest() {
        String onePair = "4D 3D 3H   7H AD";
        assertEquals(Value.ONE_PAIR, Hand.fromString(onePair).calcHandValue());

        String twoPairs = "4D 4H TS TC 5D";
        assertEquals(Value.TWO_PAIR, Hand.fromString(twoPairs).calcHandValue());

        String threeOfAKind = " 5H 5C     5D AS KS";
        assertEquals(Value.THREE_OF_A_KIND, Hand.fromString(threeOfAKind).calcHandValue());

        String straight = "5H 6C 8S 7D 9S";
        assertEquals(Value.STRAIGHT, Hand.fromString(straight).calcHandValue());

        String flush = "5H 6H QH KH 9H";
        assertEquals(Value.FLUSH, Hand.fromString(flush).calcHandValue());

        String fullHouse = "5H 5C 5D AS AC";
        assertEquals(Value.FULL_HOUSE, Hand.fromString(fullHouse).calcHandValue());

        String fourOfAKind = "5H 5C 5D 5S KS";
        assertEquals(Value.FOUR_OF_A_KIND, Hand.fromString(fourOfAKind).calcHandValue());

        String straightFlush = "5C 6C 7C 8C 9C";
        assertEquals(Value.STRAIGHT_FLUSH, Hand.fromString(straightFlush).calcHandValue());

        String royalFlush = "TC JC QC KC AC";
        assertEquals(Value.ROYAL_FLUSH, Hand.fromString(royalFlush).calcHandValue());

    }

    @Test(expected = IllegalArgumentException.class)
    public void twoTheSameCards() {
        String fullHouse = "5H 5H 5D AS AC";
        Hand.fromString(fullHouse).calcHandValue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void notFullHand() {
        String fullHouse = "5H 5D AS AC";
        Hand.fromString(fullHouse).calcHandValue();
    }

    @Test
    public void compareTwoHands() {
        String fourOfAKind = "5H 5C 5D 5S KS";
        Hand hand = Hand.fromString(fourOfAKind);
        String anotherOfAKind = "5H KS 5C 5D 5S";
        Hand anotherHand = Hand.fromString(anotherOfAKind);
        assertEquals(0, hand.compareTo(anotherHand));

        String straight = "5H 6C 8S 7D 9S";
        Hand straightHand = Hand.fromString(straight);
        assertEquals(1, hand.compareTo(straightHand));

        String straightFlush = "5C 6C 7C 8C 9C";
        Hand straightFlushHand = Hand.fromString(straightFlush);
        assertEquals(-1, hand.compareTo(straightFlushHand));

    }
}
