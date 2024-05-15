package com.studentbotique.payment;
import com.studentbotique.constants.AppConstants;

public class PaymentManager {
    double schoolBalance;
    double googleCredit;
    String paymentType;

    public PaymentManager(double schoolBalance, double googleCredit, String paymentType) {
        this.schoolBalance = schoolBalance;
        this.googleCredit = googleCredit;
        this.paymentType = paymentType;
    }

    protected ISchoolCard getSchoolCard() {
        SmartPay schoolCard = new SmartPay(null);
        schoolCard.setSchoolBalance(this.schoolBalance);
        return schoolCard;
    }

    protected double getSchoolBalance() {
        ISchoolCard schoolCard = getSchoolCard();
        return ((SmartPay) schoolCard).getSchoolBalance();
    }

    protected IGooglePay getGooglePay() {
        IGooglePay googlePay = new GooglePay(this.googleCredit);
        return googlePay;
    }

    protected double getGoogleCredit() {
        IGooglePay googlePay = getGooglePay();
        return googlePay.getCurrentBalance();
    }

    protected SmartPay getSmartPay() {
        SmartPayAdapter adapter = new SmartPayAdapter(new GooglePay(googleCredit));
        SmartPay smartPay = new SmartPay(adapter);
        smartPay.setSchoolBalance(this.schoolBalance);
        return smartPay;
    }

    protected double getSmartPayBalance() {
        SmartPay smartPay = getSmartPay();
        return smartPay.getSchoolBalance() + smartPay.adapter.googlePay.getCurrentBalance();
    }

    public double getCurrentBalance() {
        if (this.paymentType.equals(AppConstants.SCHOOL_CARD)) {
            return getSchoolBalance();
        } else if (this.paymentType.equals(AppConstants.GOOGLE_PAY)) {
            return getGoogleCredit();
        } else if (this.paymentType.equals(AppConstants.SMART_PAY)) {
            return getSmartPayBalance();
        }
        return 0;
    }
    
}
