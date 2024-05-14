package com.studentbotique.discount;

public class StudentUser implements IStudent{

    String firstName;
    String lastName;
    IWallet wallet;
    Membership membership;

    public StudentUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void setWallet(IWallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public IWallet getWallet() {
        return this.wallet;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Membership getMembership() {
        return this.membership;
    }


    @Override
    public double calculateDiscount() {
        if (membership != null) {
            return membership.getRule().calculate(this);
        } else {
            return 0;
        }
    }
}
