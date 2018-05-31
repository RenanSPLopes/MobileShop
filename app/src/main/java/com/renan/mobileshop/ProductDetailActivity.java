package com.renan.mobileshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");

        TextView productDescription = findViewById(R.id.product_description);
        TextView productPrice = findViewById(R.id.product_detail_price);
        ImageView image = findViewById(R.id.product_detail_image);

        productDescription.setText(product.getName());
        productPrice.setText("R$ " + String.valueOf(product.getPrice()));
        image.setImageResource(getImageKey(product.getImageId()));

    }

    private int getImageKey(int i){
        String imageName = "img"+i+"_big";
        return getResources().getIdentifier(imageName, "drawable", getPackageName());
    }
}
