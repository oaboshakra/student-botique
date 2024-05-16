package com.studentbotique.discount;

public class Membership {

    DiscountCalculationRule rule;

    public Membership(DiscountCalculationRule rule) {
        this.rule = rule;
    }

    protected DiscountCalculationRule getRule() {
        return this.rule;
    }
}
