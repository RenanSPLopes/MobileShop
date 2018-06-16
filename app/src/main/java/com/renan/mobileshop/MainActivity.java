package com.renan.mobileshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.renan.mobileshop.Adapters.RecyclerViewAdapter;
import com.renan.mobileshop.Models.Product;
import com.renan.mobileshop.Persistency.ProductDAO;
import com.renan.mobileshop.Persistency.ProductDAOFactory;


public class MainActivity extends AppCompatActivity implements ClickRecyclerView {

    private ProductDAO dao;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductDAOFactory factory = new ProductDAOFactory();
        dao = factory.Create(this);

        setupRecyclerView();
    }

    public void setupRecyclerView(){
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(this, dao.getAll(), this);
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
