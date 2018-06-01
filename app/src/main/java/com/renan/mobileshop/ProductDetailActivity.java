package com.renan.mobileshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.renan.mobileshop.Models.Product;

public class ProductDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.renan.mobileshop.CHECKOUT_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");

        TextView productDescription = findViewById(R.id.product_description);
        TextView productPrice = findViewById(R.id.product_detail_price);
        ImageView image = findViewById(R.id.product_detail_image);

        productDescription.setText(product.getName());
        productPrice.setText("R$ " + String.valueOf(product.getPrice()));
        image.setImageResource(getImageKey(product.getImageId()));

        Button button = findViewById(R.id.buy_button);
        button.setOnClickListener(v -> buyProduct(product));
    }

    private void buyProduct(Product product){
        Intent intent = new Intent(this, ProductCheckoutActivity.class);
        intent.putExtra(EXTRA_MESSAGE, product.getPrice());
        startActivity(intent);
    }

    private int getImageKey(int i){
        String imageName = "img"+i+"_big";
        return getResources().getIdentifier(imageName, "drawable", getPackageName());
    }
}
