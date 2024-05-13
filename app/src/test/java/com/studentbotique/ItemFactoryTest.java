package com.studentbotique;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import com.studentbotique.constants.AppConstants;
import com.studentbotique.factory.Item;
import com.studentbotique.factory.ItemFactory;
import com.studentbotique.factory.WinterJacket;
import com.studentbotique.factory.Mitten;
import com.studentbotique.factory.TShirt;
import com.studentbotique.factory.ItemFactoryProducer;

import org.junit.Test;

public class ItemFactoryTest {

    @Test
    public void testClothesFactory() {
        ItemFactory factory = ItemFactoryProducer.getFactory(false);
        Item tShirt = factory.getItem(AppConstants.T_SHIRT);
        assertThat(tShirt, instanceOf(TShirt.class));
        assertFalse(tShirt instanceof WinterJacket);

        Item jacket = factory.getItem(AppConstants.WINTER_JACKET);
        assertThat(jacket, instanceOf(WinterJacket.class));
        assertFalse(jacket instanceof TShirt);

        Item mitten = factory.getItem(AppConstants.MITTEN);
        assertThat(mitten, instanceOf(Mitten.class));
        assertFalse(mitten instanceof WinterJacket);
    }

}
