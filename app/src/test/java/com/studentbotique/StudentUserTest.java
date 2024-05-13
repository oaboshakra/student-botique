package com.studentbotique;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.studentbotique.discount.StudentUser;
import com.studentbotique.discount.Wallet;
import com.studentbotique.discount.IStudent;
import com.studentbotique.discount.IWallet;

public class StudentUserTest {
    @Test
    public void testStudent() {
        IStudent student = new StudentUser("Devon", "Smith");
        IWallet wallet = new Wallet(200);
        student.setWallet(wallet);
        assertEquals(20, (int) student.calculateDiscount());
        assertNotEquals(25, (int) student.calculateDiscount());
    }
    
}


