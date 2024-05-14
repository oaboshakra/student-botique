package com.studentbotique.factory;
import com.studentbotique.constants.AppConstants;

public class TShirt implements Item{

    @Override
    public String getName() {
        return AppConstants.T_SHIRT;
    }

    @Override
    public double getPrice() {
        return 25;
    }

    @Override
    public String getCategory() {
        return AppConstants.CLOTHES;
    }
}
