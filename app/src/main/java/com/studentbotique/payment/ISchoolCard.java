package com.studentbotique.payment;

public interface ISchoolCard {

    public boolean pay(PaymentType paymentType, double amount);
}
