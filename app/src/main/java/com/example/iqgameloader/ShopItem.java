package com.example.iqgameloader;

import java.util.ArrayList;
import java.util.List;

public class ShopItem {
    private String name; // Название предмета
    private int price; // Цена предмета
    private int bonus; // Бонус к заработку за каждую решенную задачу

    public ShopItem(String name, int price, int bonus) {
        this.name = name;
        this.price = price;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getBonus() {
        return bonus;
    }
}
