package com.studentbotique.factory;
import com.studentbotique.constants.AppConstants;

public class Mitten implements Item{

    @Override
    public String getName() {
        return AppConstants.MITTEN;
    }

    @Override
    public double getPrice() {
        return 20;
    }

    @Override
    public String getCategory() {
        return AppConstants.CLOTHES;
    }
}
