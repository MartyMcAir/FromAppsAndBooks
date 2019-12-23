package com.games.poker;

public class BaseStrategy implements ComparisonStrategy {

    @Override
    public int compare(Hand thisHand, Hand thatHand){
        if(thisHand.calcHandValue()==thatHand.calcHandValue()){
            return 0;
        } else {
            throw new IllegalArgumentException("This comparison approach " +
                    "should be used only for the hands with even value");
        }
    }
}
