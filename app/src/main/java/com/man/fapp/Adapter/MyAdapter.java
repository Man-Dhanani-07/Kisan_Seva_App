package com.man.fapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.man.fapp.Model.Item;
import com.man.fapp.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Item> itemList;

    public MyAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_raw,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item currentitem = itemList.get(position);
        holder.title.setText(currentitem.getTitle());
        holder.description.setText(currentitem.getDescription());
        holder.quantity.setText(currentitem.getQuantity());
        holder.quality.setText(currentitem.getQuality());
        holder.price.setText(currentitem.getPrice());
        String imageUrl = currentitem.getImageUrl();

        Glide.with(context)
                .load(imageUrl)
                .fitCenter()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
public TextView title,quantity,quality,description,price;
public ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title =itemView.findViewById(R.id.item_title);
            quantity = itemView.findViewById(R.id.item_quantity);
            quality = itemView.findViewById(R.id.item_quality);
            description = itemView.findViewById(R.id.item_des);
            price = itemView.findViewById(R.id.item_price);
            image = itemView.findViewById(R.id.item_image);

        }
    }
}
