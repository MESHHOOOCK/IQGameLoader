package com.example.iqgameloader;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<ShopItem> items; // Список предметов в магазине

    public Shop() {
        items = new ArrayList<>();
    }

    public void addItem(ShopItem item) {
        items.add(item);
    }

    public List<ShopItem> getItems() {
        return items;
    }

    public boolean buyItem(ShopItem item, MathGamePref mathGamePref) {
        int coins = mathGamePref.getCoins();
        if (coins >= item.getPrice()) {
            mathGamePref.setCoins(coins - item.getPrice());
            mathGamePref.setBonusCoins(mathGamePref.getBonusCoins() + item.getBonus());
            return true;
        } else {
            return false;
        }
    }

    public boolean buyBackground(int price, MathGamePref mathGamePref) {
        int coins = mathGamePref.getCoins();
        if (coins >= price) {
            mathGamePref.setCoins(coins - price);
            return true;
        } else {
            return false;
        }
    }
}
