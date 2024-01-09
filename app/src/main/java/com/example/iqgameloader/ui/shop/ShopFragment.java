package com.example.iqgameloader.ui.shop;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.iqgameloader.MathGamePref;
import com.example.iqgameloader.R;
import com.example.iqgameloader.Shop;
import com.example.iqgameloader.ShopItem;

public class ShopFragment extends Fragment {
    private MathGamePref mathGamePref;
    private Shop shop;
    private RecyclerView recyclerView;
    private ShopAdapter shopAdapter;

    public ShopFragment() {
        // Пустой конструктор
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        mathGamePref = new MathGamePref(requireContext());
        shop = new Shop();

        // Заполняем магазин предметами
        shop.addItem(new ShopItem("Койны +1", 25, 1));
        shop.addItem(new ShopItem("Койны +2", 50, 2));
        shop.addItem(new ShopItem("Койны +5", 125, 5));
        shop.addItem(new ShopItem("Койны +7", 175, 7));
        shop.addItem(new ShopItem("Койны +10", 250, 10));
        shop.addItem(new ShopItem("Койны +12", 300, 12));
        shop.addItem(new ShopItem("Койны +15", 375, 15));
        shop.addItem(new ShopItem("Койны +17", 425, 17));
        shop.addItem(new ShopItem("Койны +20", 500, 20));

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        shopAdapter = new ShopAdapter(shop.getItems(), new ShopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ShopItem item) {
                if (shop.buyItem(item, mathGamePref)) {
                    // Предмет успешно куплен
                    Toast.makeText(requireContext(), "Предмет " + item.getName() + " куплен!", Toast.LENGTH_SHORT).show();
                } else {
                    // Недостаточно монет для покупки предмета
                    Toast.makeText(requireContext(), "Недостаточно Койнов", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView.setAdapter(shopAdapter);

        return view;
    }
}