package com.studentbotique.payment;

public class SmartPayAdapter implements ISchoolCard {

    public IGooglePay googlePay;

    public SmartPayAdapter(IGooglePay googlePay) {
        this.googlePay = googlePay;
    }

    @Override
    public boolean pay(PaymentType paymentType, double amount) {
        if (paymentType.equals(PaymentType.SchoolPayment)) {
            return true;
        } else if (paymentType.equals(PaymentType.GooglePayment)) {
            return googlePay.pay(amount);
        }
        return false;
    }
}
