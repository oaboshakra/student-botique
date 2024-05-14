package com.studentbotique.factory;
import com.studentbotique.constants.AppConstants;
import java.util.ArrayList;

public class ItemCRUD {

    ArrayList<Item> items;

    public ItemCRUD() {
        this.items = new ArrayList<>();
        this.loadSampleItems();
    }

    protected void loadSampleItems() {
        this.loadBooks();
        this.loadClothes();
    }

    protected void loadBooks() {
        ItemFactory factory = ItemFactoryProducer.getFactory(true);
        Item daVinciCode = factory.getItem(AppConstants.DA_VINCI_CODE);
        this.items.add(daVinciCode);
        Item sherlockHolmes = factory.getItem(AppConstants.SHERLOCK_HOLMES);
        this.items.add(sherlockHolmes);
    }

    protected void loadClothes() {
        ItemFactory factory = ItemFactoryProducer.getFactory(false);
        Item tShirt = factory.getItem(AppConstants.T_SHIRT);
        this.items.add(tShirt);

        Item winterJacket = factory.getItem(AppConstants.WINTER_JACKET);
        this.items.add(winterJacket);

        Item mitten = factory.getItem(AppConstants.MITTEN);
        this.items.add(mitten);
    }

    public ArrayList<Item> collectRetrievedItems(String category) {
        ArrayList<Item> retrieved = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getCategory().equals(category)) {
                retrieved.add(item);
            }
        }
        return retrieved;
    }

    public ArrayList<String> collectItemHeaders() {
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Item");
        headers.add("Price");
        return headers;
    }

    public Item deliverTopItem(ArrayList<Item> items) {
        if (!items.isEmpty()) {
            Item topItem = items.get(0);
            items.remove(topItem);
            return topItem;
        } else return null;
    }
}
