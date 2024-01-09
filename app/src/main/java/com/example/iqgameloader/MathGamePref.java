package com.example.iqgameloader;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class MathGamePref {
    private static final String PREF_NAME = "MathGamePref";
    private static final String KEY_LEVEL = "level";
    private static final String KEY_EXPERIENCE = "experience";
    private static final String KEY_COINS = "coins";
    private static final String KEY_BONUS_COINS = "bonusCoins";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public MathGamePref(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public int getLevel() {
        return pref.getInt(KEY_LEVEL, 1);
    }

    public void setLevel(int level) {
        editor.putInt(KEY_LEVEL, level);
        editor.apply();
    }

    public int getExperience() {
        return pref.getInt(KEY_EXPERIENCE, 0);
    }

    public void setExperience(int experience) {
        editor.putInt(KEY_EXPERIENCE, experience);
        editor.apply();
    }

    public int getCoins() {
        return pref.getInt(KEY_COINS, 0);
    }

    public void setCoins(int coins) {
        editor.putInt(KEY_COINS, coins);
        editor.apply();
    }

    public int getBonusCoins() {
        return pref.getInt(KEY_BONUS_COINS, 0);
    }

    public void setBonusCoins(int bonusCoins) {
        editor.putInt(KEY_BONUS_COINS, bonusCoins);
        editor.apply();
    }
}