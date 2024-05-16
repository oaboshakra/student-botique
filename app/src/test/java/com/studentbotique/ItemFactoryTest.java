package com.studentbotique;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

import com.studentbotique.constants.AppConstants;
import com.studentbotique.factory.Item;
import com.studentbotique.factory.ItemFactory;
import com.studentbotique.factory.WinterJacket;
import com.studentbotique.factory.Mitten;
import com.studentbotique.factory.TShirt;
import com.studentbotique.factory.ItemFactoryProducer;
import com.studentbotique.factory.DaVinciCode;
import com.studentbotique.factory.SherlockHolmes;

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
    @Test
    public void testBookFactory() {
        ItemFactory factory = ItemFactoryProducer.getFactory(true);

        Item daVinciCode = factory.getItem(AppConstants.DA_VINCI_CODE);
        assertThat(daVinciCode, instanceOf(DaVinciCode.class));
        assertFalse(daVinciCode instanceof SherlockHolmes);

        Item sherlock = factory.getItem(AppConstants.SHERLOCK_HOLMES);
        assertThat(sherlock, instanceOf(SherlockHolmes.class));
        assertFalse(sherlock instanceof DaVinciCode);
    }

}
