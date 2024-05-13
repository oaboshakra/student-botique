package com.studentbotique;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.studentbotique.constants.AppConstants;
import com.studentbotique.discount.StudentUser;
import com.studentbotique.discount.Wallet;
import com.studentbotique.discount.IStudent;
import com.studentbotique.discount.IWallet;
import com.studentbotique.discount.DiscountCalculator;
import com.studentbotique.discount.Membership;

public class StudentUserTest {
    @Test
    public void testStudent() {
        IStudent student = new StudentUser("Devon", "Smith");
        IWallet wallet = new Wallet(200);
        student.setWallet(wallet);
        assertEquals(20, (int) student.calculateDiscount());
        assertNotEquals(25, (int) student.calculateDiscount());
    }

    @Test
    public void testStudentWithSilverMembership() {
        StudentUser student = new StudentUser("Sophie", "Adam");
        IWallet wallet = new Wallet(200);
        student.setWallet(wallet);

        DiscountCalculator silverDiscountCalculator = new DiscountCalculator(AppConstants.SILVER_RATE);
        Membership silver = new Membership(silverDiscountCalculator);
        student.setMembership(silver);
        assertEquals(20, (int) student.calculateDiscount());
    }

    @Test
    public void testStudentWithGoldMembership() {
        StudentUser student = new StudentUser("Matt", "Williams");
        IWallet wallet = new Wallet(200);
        student.setWallet(wallet);

        DiscountCalculator goldDiscountCalculator = new DiscountCalculator(AppConstants.GOLD_RATE);
        Membership gold = new Membership(goldDiscountCalculator);
        student.setMembership(gold);
        assertEquals(30, (int) student.calculateDiscount());
    }

    @Test
    public void testStudentWithPlatinumMembership() {
        StudentUser student = new StudentUser("Random", "Student");
        IWallet wallet = new Wallet(200);
        student.setWallet(wallet);

        DiscountCalculator goldDiscountCalculator = new DiscountCalculator(AppConstants.PLATINUM_RATE);
        Membership gold = new Membership(goldDiscountCalculator);
        student.setMembership(gold);
        assertEquals(40, (int) student.calculateDiscount());
    }

}


