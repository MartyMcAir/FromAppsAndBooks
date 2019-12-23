package com.games.poker;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameStrategyTest {
    private static ComparisonStrategy strategy;

    @BeforeClass
    public static void init() {
        strategy = new GameStrategy();
    }

    @Test(expected = IllegalArgumentException.class)
    public void compareDifferentHandsTest() {
        String twoPairs = "5D 4H TS 5C TD";
        Hand twoPairHand = Hand.fromString(twoPairs);

        String threeOfAKind = "5H KC KD AS KS";
        Hand threeOfAKindHand = Hand.fromString(threeOfAKind);

        assertEquals(-1, strategy.compare(twoPairHand, threeOfAKindHand));
    }


    @Test
    public void compareHighestCards() {
        String highestCardOne = "5D 4H TS 3C QD";
        Hand highestCardOneHand = Hand.fromString(highestCardOne);
        String highestCardTwo = "AD 4D QS 3H JC";
        Hand highestCardTwoHand = Hand.fromString(highestCardTwo);
        String highestCardOneReshuffled = "QD 5D TS 3C 4H";
        Hand highestCardOneReshuffledHand = Hand.fromString(highestCardOneReshuffled);
        assertEquals(-1, strategy.compare(highestCardOneHand, highestCardTwoHand));
        assertEquals(1, strategy.compare(highestCardTwoHand, highestCardOneHand));
        assertEquals(0, strategy.compare(highestCardOneHand, highestCardOneReshuffledHand));
    }


    @Test
    public void compareOnePair() {
        String onePairsLower = "AD 4D QS 4H JC";
        Hand onePairsLowerHand = Hand.fromString(onePairsLower);
        String onePairsHigher = "5D 4H TS 5C JD";
        Hand onePairsHigherHand = Hand.fromString(onePairsHigher);
        String onePairsHigherReshuffled = "5D 5C JD 4H TS";
        Hand onePairsHigherReshuffledHand = Hand.fromString(onePairsHigherReshuffled);
        assertEquals(-1, strategy.compare(onePairsLowerHand, onePairsHigherHand));
        assertEquals(1, strategy.compare(onePairsHigherHand, onePairsLowerHand));
        assertEquals(0, strategy.compare(onePairsHigherHand, onePairsHigherReshuffledHand));
    }

    @Test
    public void compareTwoPairs() {
        String twoPairsLower = "5D 4H TS 5C TD";
        Hand twoPairsLowerHand = Hand.fromString(twoPairsLower);
        String twoPairsHigher = "AD 4D QS 4H QD";
        Hand twoPairsHigherHand = Hand.fromString(twoPairsHigher);
        String twoPairsHigherReshuffled = "AD 4H QD 4D QS";
        Hand twoPairsHigherReshuffledHand = Hand.fromString(twoPairsHigherReshuffled);
        assertEquals(-1, strategy.compare(twoPairsLowerHand, twoPairsHigherHand));
        assertEquals(1, strategy.compare(twoPairsHigherHand, twoPairsLowerHand));
        assertEquals(0, strategy.compare(twoPairsHigherHand, twoPairsHigherReshuffledHand));
    }

    @Test
    public void compareFlash() {
        String flashLower = "5D 6D 7D 8D 2D";
        Hand flashLowerHand = Hand.fromString(flashLower);
        String flashHigher = "AD TD 8D 7D 6D";
        Hand flashHigherHand = Hand.fromString(flashHigher);
        String flashHigherReshuffled = "8D 7D 6D AD TD";
        Hand flashHigherReshuffledHand = Hand.fromString(flashHigherReshuffled);
        assertEquals(-1, strategy.compare(flashLowerHand, flashHigherHand));
        assertEquals(1, strategy.compare(flashHigherHand, flashLowerHand));
        assertEquals(0, strategy.compare(flashHigherHand, flashHigherReshuffledHand));
    }
}
