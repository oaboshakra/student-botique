package com.studentbotique.loyalty;

public interface ILoyaltyCard {

    public boolean performTransaction(Transaction transaction);
    public int getCurrentPoints();
    public void setCurrentPoints(int points);
}
