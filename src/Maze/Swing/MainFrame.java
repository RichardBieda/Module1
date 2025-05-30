package Maze.Swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final static String TITLE = "Maze";
    final static Color DEFAULT_BACKGROUND = new Color(235, 235, 255);
    private final MainPanel mainPanel;

    public MainFrame() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(DEFAULT_BACKGROUND);
        setBackground(DEFAULT_BACKGROUND);

        mainPanel = new MainPanel();

        add(mainPanel);
        pack();
        setVisible(true);
    }

    MainPanel getMainPanel() {
        return mainPanel;
    }
}

