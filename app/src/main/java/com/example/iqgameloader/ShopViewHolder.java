package com.example.iqgameloader;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShopViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView priceTextView;
    private Button buyButton;

    public ShopViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        priceTextView = itemView.findViewById(R.id.priceTextView);
        buyButton = itemView.findViewById(R.id.buyButton);
    }
}
