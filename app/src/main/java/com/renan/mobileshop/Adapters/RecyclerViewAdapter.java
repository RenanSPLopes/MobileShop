package com.renan.mobileshop.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renan.mobileshop.ClickRecyclerView;
import com.renan.mobileshop.Models.Product;
import com.renan.mobileshop.R;
import com.renan.mobileshop.ViewHolders.RecyclerViewHolder;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    public static ClickRecyclerView clickRecyclerView;
    Context context;
    private List<Product> products;

    public RecyclerViewAdapter(Context context, List<Product> products, ClickRecyclerView clickRecyclerView){
        this.context = context;
        this.products = products;
        this.clickRecyclerView = clickRecyclerView;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_row, parent, false);
        return new RecyclerViewHolder(itemView, products);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.setClickRecyclerView(clickRecyclerView);

        Product product = products.get(position);
        holder.setName(product.getName());
        holder.setPrice(String.valueOf(product.getPrice()));
        holder.setImage(getImageKey(product.getImageId()) );
    }

    private int getImageKey(int i){
        String imageName = "img"+i+"_small";
        return context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

}
