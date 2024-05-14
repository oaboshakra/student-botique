package com.studentbotique.factory;
import com.studentbotique.constants.AppConstants;

public class BookFactory implements ItemFactory{

    @Override
    public Item getItem(String itemType) {
        if (itemType.equals(AppConstants.DA_VINCI_CODE)) {
            return new DaVinciCode();
        } else if (itemType.equals(AppConstants.SHERLOCK_HOLMES)) {
            return new SherlockHolmes();
        } else {
            return null;
        }
    }

}
