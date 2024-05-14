package com.studentbotique.discount;

public class DiscountCalculator implements DiscountCalculationRule {

    double discountRate;

    public DiscountCalculator(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculate(StudentUser student) {
        return student.getWallet().getWalletBalance() * discountRate;
    }
}
