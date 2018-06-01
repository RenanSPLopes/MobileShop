package com.renan.mobileshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ProductCheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_checkout);

        Button confirmButton = findViewById(R.id.confirm_order_button);
        confirmButton.setOnClickListener(v -> confirmOrder());
    }

    private void confirmOrder(){
        Intent intent = new Intent(this, PaymentFinalizedActivity.class);
        startActivity(intent);
    }
}