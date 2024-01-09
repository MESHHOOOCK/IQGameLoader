package com.example.iqgameloader;

import android.content.Context;

import com.example.iqgameloader.ui.home.HomeFragment;

import java.util.Random;

public class MathGame {
    private MathGamePref mathGamePref;
    private Context context;
    private HomeFragment homeFragment;
    private int level;
    private int num1;
    private int num2;
    private double num3;
    private int correctAnswer;
    private int operation;
    private String question;

    private static final int OPERATION_ADD = 0;
    private static final int OPERATION_SUB = 1;
    private static final int OPERATION_MULT = 2;
    private static final int OPERATION_DIV = 3;
    private static final int OPERATION_POWER = 4;

    private static final int MAX_LEVEL_ADD_SUB = 10;
    private static final int MAX_LEVEL_MULT = 50;
    private static final int MAX_LEVEL_DIV = 150;
    private static final int MAX_LEVEL_POWER = 150;

    public MathGame(Context context) {
        this.context = context;
        mathGamePref = new MathGamePref(context);
        level = 1;
        generateQuestion();
    }

    public void generateQuestion() {
        Random random = new Random();
        num1 = random.nextInt(10) + 1;
        num2 = random.nextInt(10) + 1;

        if (level >= MAX_LEVEL_POWER) {
            operation = random.nextInt(OPERATION_POWER + 1);
            switch (operation) {
                case OPERATION_ADD:
                    correctAnswer = num1 + num2;
                    question = num1 + " + " + num2;
                    break;
                case OPERATION_SUB:
                    if (num1 < num2) {
                        int temp = num1;
                        num1 = num2;
                        num2 = temp;
                    }
                    correctAnswer = num1 - num2;
                    question = num1 + " - " + num2;
                    break;
                case OPERATION_MULT:
                    correctAnswer = num1 * num2;
                    question = num1 + " x " + num2;
                    break;
                case OPERATION_DIV:
                    if (num2 == 0 || num1 % num2 != 0) {
                        generateQuestion();
                        return;
                    }
                    correctAnswer = num1 / num2;
                    question = num1 + " ÷ " + num2;
                    break;
                case OPERATION_POWER:
                    num1 = random.nextInt(10) + 1;
                    num2 = random.nextInt(3) + 2;
                    correctAnswer = (int) Math.pow(num1, num2);
                    question = num1 + " ^ " + num2;
                    break;
            }
        } else if (level >= MAX_LEVEL_MULT) {
            operation = random.nextInt(OPERATION_DIV + 1);
            switch (operation) {
                case OPERATION_ADD:
                    num1 = random.nextInt(100) + 1;  // Увеличение чисел до 100
                    num2 = random.nextInt(100) + 1;
                    correctAnswer = num1 + num2;
                    question = num1 + " + " + num2;
                    break;
                case OPERATION_SUB:
                    num1 = random.nextInt(100) + 1;
                    num2 = random.nextInt(100) + 1;
                    if (num1 < num2) {
                        int temp = num1;
                        num1 = num2;
                        num2 = temp;
                    }
                    correctAnswer = num1 - num2;
                    question = num1 + " - " + num2;
                    break;
                case OPERATION_MULT:
                    num1 = random.nextInt(20) + 1;  // Увеличение чисел до 20
                    num2 = random.nextInt(20) + 1;
                    correctAnswer = num1 * num2;
                    question = num1 + " x " + num2;
                    break;
                case OPERATION_DIV:
                    num1 = random.nextInt(20) + 1;
                    num2 = random.nextInt(20) + 1;
                    if (num2 == 0 || num1 % num2 != 0) {
                        generateQuestion();
                        return;
                    }
                    correctAnswer = num1 / num2;
                    question = num1 + " ÷ " + num2;
                    break;
            }
        } else if (level >= MAX_LEVEL_ADD_SUB) {
            operation = random.nextInt(OPERATION_DIV + 1);
            switch (operation) {
                case OPERATION_ADD:
                    num1 = random.nextInt(50) + 1;  // Увеличение чисел до 50
                    num2 = random.nextInt(50) + 1;
                    correctAnswer = num1 + num2;
                    question = num1 + " + " + num2;
                    break;
                case OPERATION_SUB:
                    num1 = random.nextInt(50) + 1;
                    num2 = random.nextInt(50) + 1;
                    if (num1 < num2) {
                        int temp = num1;
                        num1 = num2;
                        num2 = temp;
                    }

                    correctAnswer = num1 - num2;
                    question = num1 + " - " + num2;
                    break;
                case OPERATION_MULT:
                    num1 = random.nextInt(10) + 1;  // Увеличение чисел до 10
                    num2 = random.nextInt(10) + 1;
                    correctAnswer = num1 * num2;
                    question = num1 + " x " + num2;
                    break;
                case OPERATION_DIV:
                    num1 = random.nextInt(10) + 1;
                    num2 = random.nextInt(10) + 1;
                    if (num2 == 0 || num1 % num2 != 0) {
                        generateQuestion();
                        return;
                    }
                    correctAnswer = num1 / num2;
                    question = num1 + " ÷ " + num2;
                    break;
            }
        } else {
            operation = OPERATION_ADD;
            correctAnswer = num1 + num2;
            question = num1 + " + " + num2;
        }
    }
    public boolean checkAnswer(int answer) {
        if (answer == correctAnswer) {
            int coinsEarned = 1 + mathGamePref.getBonusCoins();
            mathGamePref.setCoins(mathGamePref.getCoins() + coinsEarned);
            mathGamePref.setExperience(mathGamePref.getExperience() + 10);
            generateQuestion();
            mathGamePref.setLevel(mathGamePref.getLevel() + 1); // Вызовите setLevel после генерации вопроса
            return true;
        } else {
            mathGamePref.setExperience(mathGamePref.getExperience() - 5);
            generateQuestion();
            return false;
        }

    }    public int getLevel() {
        return level;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getExperience() {
        // Возвращаем опыт игры
        return mathGamePref.getExperience();
    }

    public int getCoins() {
        // Возвращаем количество монет игры
        return mathGamePref.getCoins();
    }

    public String getOperationString() {
        // Возвращает символ соответствующей операции
        switch (operation) {
            case OPERATION_ADD:
                return " + ";
            case OPERATION_SUB:
                return " - ";
            case OPERATION_MULT:
                return " x ";
            case OPERATION_DIV:
                return " ÷ ";
            case OPERATION_POWER:
                return "^";
            default:
                return "";
        }
    }

    public String getCorrectAnswerMessage() {
        return "Правильный ответ!";
    }

    public String getIncorrectAnswerMessage() {
        return "Неправильный ответ. Попробуйте еще раз.";
    }
}
