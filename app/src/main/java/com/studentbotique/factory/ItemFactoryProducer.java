package com.studentbotique.factory;

public class ItemFactoryProducer {

    public static ItemFactory getFactory(boolean isBook) {
        if (isBook) {
            return new BookFactory();
        } else {
            return new ClothesFactory();
        }
    }

}
