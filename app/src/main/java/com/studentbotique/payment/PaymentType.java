package com.studentbotique.payment;
import com.studentbotique.constants.AppConstants;

public class PaymentType {

    String type;

    public final static PaymentType GooglePayment = new PaymentType(AppConstants.GOOGLE_PAY);
    public final static PaymentType SchoolPayment = new PaymentType(AppConstants.SCHOOL_CARD);

    public PaymentType(String paymentType) {
        this.type = paymentType;
    }
}
