package com.studentbotique.payment;

public class SmartPay implements ISchoolCard {

    public SmartPayAdapter adapter;
    double balance;
    double paidAmount;

    public SmartPay(SmartPayAdapter adapter) {
        this.adapter = adapter;
    }

    public void setSchoolBalance(double balance) {
        this.balance = balance;
    }

    public double getSchoolBalance() {
        return this.balance;
    }

    @Override
    public boolean pay(PaymentType paymentType, double amount) {
        if (paymentType.equals(PaymentType.SchoolPayment)) {
            if (adapter != null) {
                boolean paid = adapter.pay(paymentType, amount);
                if (paid) {
                    paidAmount += amount;
                }
                return paid;
            } else {
                if (balance >= amount) {
                    balance -= amount;
                    paidAmount += amount;
                    return true;
                }
            }
        } else if (paymentType.equals(PaymentType.GooglePayment)) {
            if (adapter != null) {
                boolean paid = adapter.pay(paymentType, amount);
                if (paid) {
                    paidAmount += amount;
                }
                return paid;
            } else {
                return false;
            }
        }
        return false;
    }

    public double getPaidAmount() {
        return this.paidAmount;
    }
}
