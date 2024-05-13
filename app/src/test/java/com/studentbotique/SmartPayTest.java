package com.studentbotique;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.studentbotique.payment.SmartPayAdapter;
import com.studentbotique.payment.GooglePay;
import com.studentbotique.payment.IGooglePay;
import com.studentbotique.payment.PaymentType;
import com.studentbotique.payment.SmartPay;

public class SmartPayTest {

    @Test
    public void testSmartPayOperation() {
        IGooglePay googlePay = new GooglePay(5000);
        SmartPayAdapter adapter = new SmartPayAdapter(googlePay);
        SmartPay smartPay = new SmartPay(adapter);
        smartPay.setSchoolBalance(5000);

        assertTrue(smartPay.pay(PaymentType.GooglePayment, 500));
        assertTrue(smartPay.pay(PaymentType.SchoolPayment, 300));
        assertEquals(800, (int)smartPay.getPaidAmount());
    }

    @Test
    public void testGooglePaySuccessful() {
        IGooglePay googlePay = new GooglePay(5000);
        assertTrue(googlePay.pay(500));
        assertEquals(4500, (int)googlePay.getCurrentBalance());
    }

}
