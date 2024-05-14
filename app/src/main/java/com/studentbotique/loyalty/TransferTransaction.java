package com.studentbotique.loyalty;

public class TransferTransaction implements Transaction {

    ILoyaltyCard card;
    int MINIMUM_POINTS = 500;

    public TransferTransaction(ILoyaltyCard anotherCard) {
        this.card = anotherCard;
    }

    @Override
    public boolean performTransaction(ILoyaltyCard card) {
        if (card.getCurrentPoints() >= MINIMUM_POINTS) {
            this.card.setCurrentPoints(this.card.getCurrentPoints() + card.getCurrentPoints());
            card.setCurrentPoints(0);
            return true;
        } else {
            return false;
        }
    }

    public boolean isLowPoints(int currentPoints) {
        return currentPoints < MINIMUM_POINTS;
    }
}
