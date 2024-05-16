package com.studentbotique.discount;

public class Wallet implements IWallet {

    double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }

    @Override
    public double getWalletBalance() {
        return this.balance;
    }

    @Override
    public void setWalletBalance(double balance) {
        this.balance = balance;
    }
}
