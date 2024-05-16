package com.studentbotique.factory;
import com.studentbotique.constants.AppConstants;

public class ClothesFactory  implements ItemFactory{

    @Override
    public Item getItem(String itemType) {
        if (itemType.equals(AppConstants.T_SHIRT)) {
            return new TShirt();
        } else if (itemType.equals(AppConstants.WINTER_JACKET)) {
            return new WinterJacket();
        } else if (itemType.equals(AppConstants.MITTEN)) {
            return new Mitten();
        } else {
            return null;
        }
    }

}
