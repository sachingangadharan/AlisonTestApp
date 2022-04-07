package com.android.internal.alisontestapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.internal.alisontestapp.Model.Products;
import com.android.internal.alisontestapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductRecyclerviewAdapter extends RecyclerView.Adapter<ProductRecyclerviewAdapter.ViewHolder> {
    private ArrayList<Products> list;
    Context context;

    public ProductRecyclerviewAdapter(ArrayList<Products> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductRecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecyclerviewAdapter.ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        Glide.with(context)
                .load(list.get(position).getImage())
                .centerCrop()
                .placeholder(R.drawable.magazine)
                .into(holder.image);
        holder.description.setText(list.get(position).getDescription());
        holder.rate.setText(list.get(position).getPrice().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ImageView image;
        private final TextView description;
        private final TextView rate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            description = itemView.findViewById(R.id.description);
            rate = itemView.findViewById(R.id.price);
        }
    }
}
