package com.games.poker;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class GameStrategy implements ComparisonStrategy {

    @Override
    public int compare(Hand thisHand, Hand thatHand) {
        if (thisHand.calcHandValue() == thatHand.calcHandValue()) {
            return compareHands(thisHand, thatHand);
        } else {
            throw new IllegalArgumentException("This comparison approach " +
                    "should be used only for the hands with even value");
        }
    }

    private int compareHands(Hand thisHand, Hand thatHand) {
        SortedSet<Map.Entry<Rank, List<Card>>> thisHandSet = new TreeSet<>(new HandComparator());
        thisHandSet.addAll(thisHand.getCardSet()
                .stream()
                .collect(groupingBy(Card::getRank))
                .entrySet());

        SortedSet<Map.Entry<Rank, List<Card>>> thatHandSet = new TreeSet<>(new HandComparator());
        thatHandSet.addAll(thatHand.getCardSet().stream()
                .collect(groupingBy(Card::getRank))
                .entrySet());

        return Integer.compare(thisHandSet.last().getKey().getWeight(), thatHandSet.last().getKey().getWeight());
    }

    private class HandComparator implements Comparator<Map.Entry<Rank, List<Card>>> {
        @Override
        public int compare(Map.Entry<Rank, List<Card>> e1, Map.Entry<Rank, List<Card>> e2) {
            if (e1.getValue().size() < e2.getValue().size()) {
                return -1;
            } else if (e1.getValue().size() > e2.getValue().size()) {
                return 1;
            } else {
                return Integer.compare(e1.getKey().getWeight(), e2.getKey().getWeight());
            }
        }
    }
}
