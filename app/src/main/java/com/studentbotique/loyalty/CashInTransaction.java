package com.studentbotique.loyalty;

public class CashInTransaction implements Transaction{

    int point2Cash;
    int MINIMUM_POINTS = 1000;

    public CashInTransaction(int point2Cash) {
        this.point2Cash = point2Cash;
    }

    public boolean performTransaction(ILoyaltyCard card) {
        if (card.getCurrentPoints() >= MINIMUM_POINTS) {
            card.setCurrentPoints(card.getCurrentPoints() - point2Cash);
            return true;
        } else {
            return false;
        }
    }

    public boolean isLowPoints(int currentPoints) {
        return currentPoints < MINIMUM_POINTS;
    }
}
