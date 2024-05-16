package com.studentbotique.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.studentbotique.R;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.setupGoShoppingButton();
        this.setupLoyaltyButton();
    }

    protected void setupGoShoppingButton() {
        Button shoppingButton = findViewById(R.id.shoppingButton);
        shoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move2Products();
            }
        });
    }

    protected void setupLoyaltyButton() {
        Button loyaltyButton = findViewById(R.id.loyaltyButton);
        loyaltyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move2Loyalty();
            }
        });
    }

    protected void move2Products(){
        Intent productIntent = new Intent(this, ProductActivity.class);
        startActivity(productIntent);
    }

    protected void move2Loyalty(){
        Intent loyaltyIntent = new Intent(this, LoyaltyActivity.class);
        startActivity(loyaltyIntent);
    }

}
