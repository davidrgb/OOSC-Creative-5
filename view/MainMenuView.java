package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuView {
    private JFrame window;

    private int xResolution;
    private int yResolution;

    private boolean escalationMode;
    private String gameModeButtonText;

    public MainMenuView(JFrame window, int xResolution, int yResolution, boolean escalationMode) {
        this.window = window;
        window.setTitle("Main Menu");

        this.xResolution = xResolution;
        this.yResolution = yResolution;

        this.escalationMode = escalationMode;

        if (!escalationMode) gameModeButtonText = "Game Mode: Speed";
        else gameModeButtonText = "Game Mode: Escalation";
    }

    public void init() {
        Container container = window.getContentPane();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.setPreferredSize(new Dimension(xResolution / 5, xResolution / 5));
        window.setLocation(xResolution / 2 - xResolution / 10, yResolution / 2 - xResolution / 10);

        JButton instructionsButton = new JButton("How To Play");
        JButton gameMode = new JButton(gameModeButtonText);
        JButton easyButton = new JButton("Easy");
        JButton normalButton = new JButton("Normal");
        JButton hardButton = new JButton("Hard");

        panel.add(instructionsButton);
        panel.add(gameMode);
        panel.add(easyButton);
        panel.add(normalButton);
        panel.add(hardButton);

        container.add(BorderLayout.CENTER, panel);

        instructionsButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var instructions = new InstructionsView(window, xResolution, yResolution, escalationMode);
            instructions.init();
            window.pack();
            window.revalidate();
        });

        gameMode.addActionListener( e -> {
            escalationMode = !escalationMode;
            if (!escalationMode) gameMode.setText("Game Mode: Speed");
            else gameMode.setText("Game Mode: Escalation");
        });

        easyButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var easy = new GameView(window, xResolution, yResolution, 1, escalationMode);
            easy.init();
            window.pack();
            window.revalidate();
        });

        normalButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var normal = new GameView(window, xResolution, yResolution, 2, escalationMode);
            normal.init();
            window.pack();
            window.revalidate();
        });

        hardButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var hard = new GameView(window, xResolution, yResolution, 3, escalationMode);
            hard.init();
            window.pack();
            window.revalidate();
        });
    }
}
