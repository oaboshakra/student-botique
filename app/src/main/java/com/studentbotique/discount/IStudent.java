package com.studentbotique.discount;

public interface IStudent {

    public void setWallet(IWallet wallet);

    public IWallet getWallet();

    public double calculateDiscount();
}
