package com.studentbotique;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.studentbotique.loyalty.SmartLoyaltyCard;
import com.studentbotique.loyalty.Transaction;
import com.studentbotique.loyalty.LoyaltyCard;
import com.studentbotique.loyalty.ILoyaltyCard;
import com.studentbotique.loyalty.CashInTransaction;
import com.studentbotique.loyalty.BuyBookTransaction;
import com.studentbotique.loyalty.TransferTransaction;

public class LoyaltyCardTest {

    @Test
    public void testOldCardOperations() {
        LoyaltyCard card = new LoyaltyCard(2500);
        card.performTransaction(1, 500, null);
        assertTrue(card.cashIn(500));
        LoyaltyCard newCard = new LoyaltyCard(0);
        assertTrue(card.transfer(newCard));
        assertEquals(1500, newCard.getCurrentPoints());
        assertFalse(card.cashIn(500));
    }

    @Test
    public void testCashIn() {
        ILoyaltyCard card = new SmartLoyaltyCard(2500);
        Transaction transaction = new CashInTransaction(1000);
        assertTrue(card.performTransaction(transaction));
        assertEquals(1500, card.getCurrentPoints());
        assertTrue(card.performTransaction(transaction));
        assertEquals(500, card.getCurrentPoints());
    }

    @Test
    public void testTransfer() {
        ILoyaltyCard firstCard = new SmartLoyaltyCard(2500);
        ILoyaltyCard secondCard = new SmartLoyaltyCard(0);
        Transaction transaction = new TransferTransaction(secondCard);
        assertTrue(firstCard.performTransaction(transaction));
        assertEquals(0, firstCard.getCurrentPoints());
        assertEquals(2500, secondCard.getCurrentPoints());
    }

    @Test
    public void testBuyBook() {
        ILoyaltyCard card = new SmartLoyaltyCard(3500);
        Transaction transaction = new BuyBookTransaction(1000);
        assertTrue(card.performTransaction(transaction));
        assertEquals(2500, card.getCurrentPoints());
        assertTrue(card.performTransaction(transaction));
        assertEquals(1500, card.getCurrentPoints());
    }

    @Test
    public void testAllTransactions() {
        ILoyaltyCard firstCard = new SmartLoyaltyCard(2000);
        ILoyaltyCard secondCard = new SmartLoyaltyCard(0);

        Transaction cashIn = new CashInTransaction(1000);
        assertTrue(firstCard.performTransaction(cashIn));
        assertEquals(1000, firstCard.getCurrentPoints());

        Transaction buyBook = new BuyBookTransaction(600);
        assertTrue(firstCard.performTransaction(buyBook));
        assertEquals(400, firstCard.getCurrentPoints());

        Transaction transfer = new TransferTransaction(secondCard);
        assertFalse(firstCard.performTransaction(transfer));
        assertEquals(400, firstCard.getCurrentPoints());
        assertEquals(0, secondCard.getCurrentPoints());
    }
}
