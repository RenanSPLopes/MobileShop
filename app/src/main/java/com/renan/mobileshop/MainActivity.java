package com.renan.mobileshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.renan.mobileshop.Adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickRecyclerView {

    public static final String EXTRA_MESSAGE = "com.renan.mobileshop.MESSAGE";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Product product = new Product();
        product.setName("Iphone 7 Jet Black 32GB Preto Iphone IOS 4G Wi-fi Câmera 12MP");
        product.setPrice(2748.98);
        product.setImageId(1);

        Product product2 = new Product();
        product2.setName("IPhone 8 Plus 64GB Vermelho Special Edition Tela 5.5 IOS 11 4G Câmera 12MP");
        product2.setPrice(3999.99);
        product2.setImageId(2);

        Product product3 = new Product();
        product3.setName("IPhone 8 Plus 64GB Vermelho Special Edition Tela 5.5 IOS 11 4G Câmera 12MP");
        product3.setPrice(3999.99);
        product3.setImageId(2);

        products.add(product);
        products.add(product2);
        products.add(product3);

        setupRecyclerView();

    }

    public void setupRecyclerView(){
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(this, products, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.addItemDecoration(
                new android.support.v7.widget.DividerItemDecoration
                    (this, android.support.v7.widget.DividerItemDecoration.VERTICAL));

        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCustomClick(Object object) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        intent.putExtra("product", (Product) object);
        startActivity(intent);
    }
}
