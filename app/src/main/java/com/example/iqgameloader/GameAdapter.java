package com.example.iqgameloader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {
    private List<Game> gameList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Game game);
    }

    public GameAdapter(List<Game> gameList, OnItemClickListener listener) {
        this.gameList = gameList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        final Game game = gameList.get(position);
        holder.bind(game);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(game);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder {
        private TextView gameNameTextView;

        public GameViewHolder(View itemView) {
            super(itemView);
            gameNameTextView = itemView.findViewById(R.id.tv_gameName);
        }

        public void bind(Game game) {
            gameNameTextView.setText(game.getName());
        }
    }
}