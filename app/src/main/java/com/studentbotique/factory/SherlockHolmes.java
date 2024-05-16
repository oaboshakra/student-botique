package com.studentbotique.factory;
import com.studentbotique.constants.AppConstants;

public class SherlockHolmes implements Item {

    @Override
    public String getName() {
        return AppConstants.SHERLOCK_HOLMES;
    }

    @Override
    public double getPrice() {
        return 150;
    }

    @Override
    public String getCategory() {
        return AppConstants.BOOK;
    }
}
