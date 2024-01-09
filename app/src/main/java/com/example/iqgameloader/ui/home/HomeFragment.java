package com.example.iqgameloader.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iqgameloader.Game;
import com.example.iqgameloader.GameAdapter;
import com.example.iqgameloader.MainActivity;
import com.example.iqgameloader.MathGame;
import com.example.iqgameloader.R;
import com.example.iqgameloader.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private MathGame mathGame;

    private TextView levelTextView;
    private TextView experienceTextView;
    private TextView coinsTextView;

    public HomeFragment() {
        // Пустой конструктор
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mathGame = new MathGame(requireContext());

        levelTextView = view.findViewById(R.id.levelTextView);
        experienceTextView = view.findViewById(R.id.experienceTextView);
        coinsTextView = view.findViewById(R.id.coinsTextView);

        updateStats();

        return view;
    }

    public void updateStats() {
        int level = mathGame.getLevel();
        int experience = mathGame.getExperience();
        int coins = mathGame.getCoins();

        levelTextView.setText("Уровень: " + level);
        experienceTextView.setText("Опыт: " + experience);
        coinsTextView.setText("Койны: " + coins);
    }
}