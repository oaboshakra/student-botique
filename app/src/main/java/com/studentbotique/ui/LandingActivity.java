package com.studentbotique.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.studentbotique.R;
import com.studentbotique.constants.AppConstants;
import com.studentbotique.discount.Wallet;
import com.studentbotique.discount.IWallet;
import com.studentbotique.discount.DiscountCalculationRule;
import com.studentbotique.discount.DiscountCalculator;
import com.studentbotique.discount.DiscountManager;
import com.studentbotique.discount.Membership;
import com.studentbotique.discount.StudentUser;

public class LandingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        this.loadMembershipSpinner();
        this.setupCalculateDiscountButton();
        this.setupProceedButton();
    }

    protected void loadMembershipSpinner() {
        Spinner membershipSpinner = findViewById(R.id.membershipSpinner);
        List<String> memberships = new ArrayList<>();
        memberships.add("Select a membership");
        memberships.add(AppConstants.SILVER_MEMBERSHIP);
        memberships.add(AppConstants.GOLD_MEMBERSHIP);
        memberships.add(AppConstants.PLATINUM_MEMBERSHIP);

        ArrayAdapter<String> membershipAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, memberships);
        membershipAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        membershipSpinner.setAdapter(membershipAdapter);
    }

    protected double getDeposit() {
        EditText depositBox = findViewById(R.id.depositBox);
        return Double.parseDouble(depositBox.getText().toString());
    }

    protected String getSelectedMembershipType() {
        Spinner membershipSpinner = findViewById(R.id.membershipSpinner);
        return membershipSpinner.getSelectedItem().toString();
    }

    protected double calculateDiscount() {
        String membershipType = getSelectedMembershipType();
        double deposit = getDeposit();
        DiscountManager manager = new DiscountManager(deposit, membershipType);
        return manager.calculateDiscount();
    }

    protected void setupCalculateDiscountButton() {
        Button calculateDiscountButton = findViewById(R.id.calculateDiscountButton);
        calculateDiscountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double totalDiscount = calculateDiscount();
                showDiscount(totalDiscount);
            }
        });
    }

    protected void showDiscount(double totalDiscount) {
        TextView discountLabel = findViewById(R.id.totalDiscountLabel);
        discountLabel.setText("$" + totalDiscount);
    }

    protected void storeBalance2SharedPref(double depositBalance) {
        SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.SCHOOL_CARD, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(AppConstants.SCHOOL_CARD_BALANCE, (float) depositBalance);
        editor.commit();
    }

    protected void storeLoyaltyPoints(int loyaltyPoints) {
        SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.SCHOOL_CARD, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(AppConstants.INITIAL_LOYALTY, loyaltyPoints);
        editor.commit();
    }

    protected void setupProceedButton() {
        Button proceedButton = findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double deposit = getDeposit();
                storeBalance2SharedPref(deposit);
                storeLoyaltyPoints(AppConstants.INITIAL_LOYALTY_POINTS);
                move2Dashboard();
            }
        });
    }

    protected void move2Dashboard() {
        Intent dbIntent = new Intent(this, DashboardActivity.class);
        startActivity(dbIntent);
    }

}
