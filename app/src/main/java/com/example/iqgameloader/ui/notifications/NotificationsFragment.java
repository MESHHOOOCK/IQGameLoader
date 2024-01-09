package com.example.iqgameloader.ui.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.iqgameloader.MathGame;
import com.example.iqgameloader.MathGamePref;
import com.example.iqgameloader.R;
import com.example.iqgameloader.databinding.FragmentNotificationsBinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class NotificationsFragment extends Fragment {
    private MathGame mathGame;
    private MathGamePref mathGamePref;
    private TextView levelTextView;
    private TextView questionTextView;
    private EditText answerEditText;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        Context context = requireContext();
        mathGamePref = new MathGamePref(context);
        mathGame = new MathGame(context);

        levelTextView = view.findViewById(R.id.tv_level);
        questionTextView = view.findViewById(R.id.tv_question);
        answerEditText = view.findViewById(R.id.et_answer);
        Button submitButton = view.findViewById(R.id.btn_submit);

        updateUI();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answerString = answerEditText.getText().toString();
                if (!answerString.isEmpty()) {
                    int answer = Integer.parseInt(answerString);
                    boolean isCorrect = mathGame.checkAnswer(answer);
                    if (isCorrect) {
                        updateUI();
                        Toast.makeText(getContext(), mathGame.getCorrectAnswerMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), mathGame.getIncorrectAnswerMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }

    private void updateUI() {
        int level = mathGamePref.getLevel();
        int num1 = mathGame.getNum1();
        int num2 = mathGame.getNum2();

        levelTextView.setText("Уровень: " + level);
        questionTextView.setText("Решите задание: " + num1 + " " + mathGame.getOperationString() + " " + num2);
        answerEditText.setText("");

        // Дополнительные обновления интерфейса, если необходимо
        // ...
    }
}