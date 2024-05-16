package com.studentbotique.payment;

public class GooglePay implements IGooglePay {

    private double balance;

    public GooglePay(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public double getCurrentBalance() {
        return this.balance;
    }
}
