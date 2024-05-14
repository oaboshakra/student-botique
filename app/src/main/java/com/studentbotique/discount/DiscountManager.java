package com.studentbotique.discount;

import com.studentbotique.constants.AppConstants;

public class DiscountManager {

    double deposit;
    String membershipType;

    public DiscountManager(double deposit, String membershipType) {
        this.deposit = deposit;
        this.membershipType = membershipType;
    }

    protected double getDiscountRate(String membershipType) {
        if (membershipType.equals(AppConstants.SILVER_MEMBERSHIP)) {
            return AppConstants.SILVER_RATE;
        } else if (membershipType.equals(AppConstants.GOLD_MEMBERSHIP)) {
            return AppConstants.GOLD_RATE;
        } else if (membershipType.equals(AppConstants.PLATINUM_MEMBERSHIP)) {
            return AppConstants.PLATINUM_RATE;
        } else return 0;
    }

    protected DiscountCalculationRule getDiscountCalculationRule() {
        double discountRate = getDiscountRate(membershipType);
        return new DiscountCalculator(discountRate);
    }

    protected Membership getMembership(DiscountCalculationRule rule) {
        return new Membership(rule);
    }

    protected IWallet getDalWallet() {
        return new Wallet(this.deposit);
    }

    public double calculateDiscount() {
        StudentUser student = new StudentUser("John", "Doe");
        student.setMembership(getMembership(getDiscountCalculationRule()));
        student.setWallet(getDalWallet());
        return student.calculateDiscount();
    }
}
