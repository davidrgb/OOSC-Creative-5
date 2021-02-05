package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InstructionsView {
    private JFrame window;
    private JTextArea instructionsArea = new JTextArea();

    private int xResolution;
    private int yResolution;

    private boolean escalationMode;

    private String instructions;

    public InstructionsView(JFrame window, int xResolution, int yResolution, boolean escalationMode) {
        this.window = window;
        window.setTitle("How To Play");

        this.xResolution = xResolution;
        this.yResolution = yResolution;

        this.escalationMode = escalationMode;

        instructions = "The goal of the game is to type the given string of characters as quickly as possible.\n";
        instructions += "In Speed Mode, the time limit decreases with each string.\n";
        instructions += "The higher the difficulty, the less time you start with and the quicker it dissapears.\n";
        instructions += "In Escalation Mode, the number of characters increases with each word.\n";
        instructions += "The higher the difficulty, the higher the number of characters you start with.\n";
        instructions += "\nGood luck!";
    }

    public void init() {
        Container container = window.getContentPane();

        var scrollPane = new JScrollPane(instructionsArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(xResolution / 3, xResolution / 15));
        window.setLocation(xResolution / 2 - xResolution / 6, yResolution / 2 - xResolution / 30);

        instructionsArea.setText(instructions);

        container.add(BorderLayout.CENTER, scrollPane);
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 1));
        
        JButton exitButton = new JButton("Go Back");
        controlPanel.add(exitButton);

        container.add(BorderLayout.SOUTH, controlPanel);

        exitButton.addActionListener( e -> {
            window.getContentPane().removeAll();
            var mainMenu = new MainMenuView(window, xResolution, yResolution, escalationMode);
            mainMenu.init();
            window.pack();
            window.revalidate();
        });
    }
}
