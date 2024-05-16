package com.studentbotique.payment;

public interface IGooglePay {

    public boolean pay(double amount);

    public double getCurrentBalance();
}
