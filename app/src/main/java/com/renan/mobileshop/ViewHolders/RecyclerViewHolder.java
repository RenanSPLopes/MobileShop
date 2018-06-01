package com.renan.mobileshop.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.renan.mobileshop.ClickRecyclerView;
import com.renan.mobileshop.Models.Product;
import com.renan.mobileshop.R;

import java.util.List;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    private ClickRecyclerView clickRecyclerView;
    private TextView price;
    private TextView name;
    private ImageView image;

    public RecyclerViewHolder(final View itemView, final List<Product> products){
        super(itemView);

        name = itemView.findViewById(R.id.product_name);
        price = itemView.findViewById(R.id.product_price);
        image =  itemView.findViewById(R.id.product_image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickRecyclerView.onCustomClick(products.get(getLayoutPosition()));
            }
        });

    }

    public void setClickRecyclerView(ClickRecyclerView clickRecyclerView) {
        this.clickRecyclerView = clickRecyclerView;
    }

    public TextView getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price.setText("R$ " + price);
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(int imageId) {
        this.image.setImageResource(imageId);
    }
}
