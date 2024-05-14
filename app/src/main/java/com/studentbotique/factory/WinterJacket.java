package com.studentbotique.factory;
import com.studentbotique.constants.AppConstants;

public class WinterJacket implements Item {

    @Override
    public String getName() {
        return AppConstants.WINTER_JACKET;
    }

    @Override
    public double getPrice() {
        return 350;
    }

    @Override
    public String getCategory() {
        return AppConstants.CLOTHES;
    }

}
