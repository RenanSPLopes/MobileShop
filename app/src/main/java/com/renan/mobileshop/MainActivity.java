package com.renan.mobileshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.renan.mobileshop.Adapters.RecyclerViewAdapter;
import com.renan.mobileshop.Models.Product;
import com.renan.mobileshop.Repository.ProductRepository;

public class MainActivity extends AppCompatActivity implements ClickRecyclerView {

    public static final String EXTRA_MESSAGE = "com.renan.mobileshop.MESSAGE";

    private ProductRepository productRepository;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    public MainActivity(){
        this.productRepository = new ProductRepository();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
    }

    public void setupRecyclerView(){
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(this, productRepository.getProducts(), this);
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
