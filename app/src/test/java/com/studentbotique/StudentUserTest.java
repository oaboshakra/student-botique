package com.studentbotique;

import org.junit.Test;

import com.studentbotique.discount.StudentUser;
import com.studentbotique.discount.Wallet;
import com.studentbotique.discount.IStudent;
import com.studentbotique.discount.IWallet;

public class StudentUserTest {
    @Test
    public void testStudent() {
        IStudent student = new StudentUser("Devon", "Smith");
        IWallet wallet = new Wallet(225);
        student.setWallet(wallet);
    }
}


