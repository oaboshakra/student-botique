package com.studentbotique.factory;
import com.studentbotique.constants.AppConstants;

public class DaVinciCode implements Item{

    @Override
    public String getName() {
        return AppConstants.DA_VINCI_CODE;
    }

    @Override
    public double getPrice() {
        return 200;
    }

    @Override
    public String getCategory() {
        return AppConstants.BOOK;
    }
}
