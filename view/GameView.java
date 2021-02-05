package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Game;

public class GameView {
    
    private JFrame window;
    private Game game;

    private int xResolution;
    private int yResolution;

    private boolean escalationMode;

    private JTextField target = new JTextField();
    private JTextField input = new JTextField();

    public GameView(JFrame window, int xResolution, int yResolution, int difficulty, boolean escalationMode) {
        this.window = window;
        switch (difficulty) {
            case 1: window.setTitle("Easy"); break;
            case 2: window.setTitle("Normal"); break;
            case 3: window.setTitle("Hard"); break;
        }

        game = new Game(difficulty, escalationMode, this);

        this.xResolution = xResolution;
        this.yResolution = yResolution;

        this.escalationMode = escalationMode;
    }

    public void init() {
        Container container = window.getContentPane();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.setPreferredSize(new Dimension(yResolution / 5, yResolution / 10));
        window.setLocation(xResolution / 2 - yResolution / 10, yResolution / 2 - yResolution / 20);

        panel.add(target);
        panel.add(input);

        game.start();

        container.add(BorderLayout.CENTER, panel);
    }

    /*public void endGame(int state) {
        window.getContentPane().removeAll();
        var endGame = new EndGameView(window, xResolution, yResolution, state, cheats);
        endGame.init();
        window.pack();
        window.revalidate();
    }*/

    public JTextField getTarget() {
        return target;
    }

    public JTextField getInput() {
        return input;
    }
}
