package com.studentbotique.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import com.studentbotique.R;
import com.studentbotique.constants.AppConstants;
import com.studentbotique.loyalty.BuyBookTransaction;
import com.studentbotique.loyalty.CashInTransaction;
import com.studentbotique.loyalty.SmartLoyaltyCard;
import com.studentbotique.loyalty.Transaction;
import com.studentbotique.loyalty.TransferTransaction;

public class LoyaltyActivity extends AppCompatActivity {

    public SmartLoyaltyCard smartLoyaltyCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loyalty);
        this.showLoadedLoyaltyPoints();
        this.loadSmartLoyaltyCard();
        this.setupMakeTransactionButton();
    }

    protected int getLoyaltyPointFromSharedPref() {
        SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.SCHOOL_CARD, MODE_PRIVATE);
        return sharedPreferences.getInt(AppConstants.INITIAL_LOYALTY, 0);
    }

    protected void showLoadedLoyaltyPoints() {
        int points = getLoyaltyPointFromSharedPref();
        TextView pointLabel = findViewById(R.id.currentPointLabel);
        pointLabel.setText(Integer.toString(points));
    }

    protected void showUpdatedLoyaltyPoints() {
        int points = (int) getUpdateLoyaltyPoints();
        TextView pointLabel = findViewById(R.id.currentPointLabel);
        pointLabel.setText(Integer.toString(points));
    }

    protected void loadSmartLoyaltyCard() {
        int points = getLoyaltyPointFromSharedPref();
        this.smartLoyaltyCard = new SmartLoyaltyCard(points);
    }

    protected int getPoint2Deduct() {
        EditText point2DeductBox = findViewById(R.id.point2DeductBox);
        return Integer.parseInt(point2DeductBox.getText().toString().trim());
    }

    protected Transaction getCashInTransaction(int point2Deduct) {
        return new CashInTransaction(point2Deduct);
    }

    protected Transaction getBuyBookTransaction(int point2Deduct) {
        return new BuyBookTransaction(point2Deduct);
    }

    protected Transaction getTransferTransaction() {
        SmartLoyaltyCard anotherCard = new SmartLoyaltyCard(0);
        return new TransferTransaction(anotherCard);
    }

    protected Transaction getSelectedTransaction() {
        RadioButton cashIn = findViewById(R.id.cashInButton);
        RadioButton transfer = findViewById(R.id.transferButton);
        RadioButton buyBook = findViewById(R.id.buyBookButton);
        int point2Deduct = 0;
        if (cashIn.isChecked()) {
            point2Deduct = getPoint2Deduct();
            return getCashInTransaction(point2Deduct);
        } else if (transfer.isChecked()) {
            return getTransferTransaction();
        } else if (buyBook.isChecked()) {
            point2Deduct = getPoint2Deduct();
            return getBuyBookTransaction(point2Deduct);
        }
        return null;
    }

    protected boolean performTransaction() {
        Transaction transaction = getSelectedTransaction();
        return transaction.performTransaction(this.smartLoyaltyCard);
    }

    protected double getUpdateLoyaltyPoints() {
        return this.smartLoyaltyCard.getCurrentPoints();
    }

    public void setupMakeTransactionButton() {
        Button makeTransaction = findViewById(R.id.makeTransactionButton);
        makeTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (performTransaction()) {
                    showTransactionMessage(makeTransaction, AppConstants.TRANSACTION_SUCCESSFUL);
                    showUpdatedLoyaltyPoints();
                } else {
                    showTransactionMessage(makeTransaction, AppConstants.TRANSACTION_FAILED);
                }
            }
        });
    }

    protected void showTransactionMessage(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
