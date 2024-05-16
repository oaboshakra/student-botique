package com.studentbotique.loyalty;

public class BuyBookTransaction implements Transaction {

    int points2Buy;
    int MINIMUM_POINTS = 1000;

    public BuyBookTransaction(int points2Buy) {
        this.points2Buy = points2Buy;
    }

    @Override
    public boolean performTransaction(ILoyaltyCard card) {
        if (card.getCurrentPoints() >= points2Buy) {
            card.setCurrentPoints(card.getCurrentPoints() - points2Buy);
            return true;
        } else {
            return false;
        }
    }

    public boolean isLowPoints(int currentPoints) {
        return currentPoints < MINIMUM_POINTS;
    }
}
