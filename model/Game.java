package model;

import java.util.Random;

import view.GameView;

public class Game {

    private String targetText;
    private String inputText;

    private int difficulty;
    private boolean escalationMode;

    private int length;
    private int interval;
    private double modifier;

    private boolean scan;

    private int score;

    private GameView view;

    Random random = new Random();

    public Game(int difficulty, boolean escalationMode, GameView view) {
        this.difficulty = difficulty;
        this.escalationMode = escalationMode;

        switch (difficulty) {
            case 1: length = 3; interval = 5000; break;
            case 2: length = 5; interval = 3000; break;
            case 3: length = 10; interval = 1500; break;
        }

        if (!escalationMode) {
            switch (difficulty) {
                case 1: modifier = 0.95; break;
                case 2: modifier = 0.9; break;
                case 3: modifier = 0.8; break;
            }
        }
        else modifier = 1.0;
        
        scan = false;

        this.view = view;
    }

    public char generateChar() {
        return (char)(random.nextInt(26) + 1 + 96);
    }

    public void generateTarget() {
        targetText = "";
        for (int i = 0; i < length; i++) {
            targetText += generateChar();
        }
    }

    public String getTargetText() {
        return targetText;
    }

    public void start() {
        generateTarget();
        view.getTarget().setText(targetText);
        view.getInput().setText("");
    }
}
