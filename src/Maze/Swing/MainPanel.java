package Maze.Swing;

import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.BOTH;

class MainPanel extends JPanel {

    final static int DEFAULT_WIDTH = 1600;
    final static int DEFAULT_HEIGHT = 1200;
    private final HeadPanel headPanel;
    private MazePanel mazePanel;
    private final MenuPanel menuPanel;

    public MainPanel() {
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setOpaque(true);

        headPanel = new HeadPanel();

        mazePanel = new MazePanel(MazePanel.DEFAULT_MAZE_SIZE, MazePanel.DEFAULT_MAZE_SIZE);
        MazeActionListener mazeActionListener = new MazeActionListener(this);
        mazePanel.createMaze(MazePanel.DEFAULT_MAZE_SIZE, MazePanel.DEFAULT_MAZE_SIZE, mazeActionListener);

        menuPanel = new MenuPanel();
        menuPanel.addMenuPanelAction(this);
        menuPanel.addCreateAndSolveAction(new HeadActionListener(this));
        menuPanel.addChangeListener(new FieldChangeListener(this));

        setFrameLayout();
    }

    MazePanel getMazePanel() {
        return mazePanel;
    }

    MenuPanel getMenuPanel() {
        return menuPanel;
    }

    void setMazePanel(MazePanel mazePanel) {
        this.mazePanel = mazePanel;
    }

    void setFrameLayout() {
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(grid);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 0.15;
        constraints.fill = BOTH;
        add(headPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.7;
        constraints.weighty = 0.85;
        constraints.fill = BOTH;
        add(mazePanel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0.3;
        constraints.weighty = 0.85;
        constraints.fill = BOTH;
        add(menuPanel, constraints);
    }
}
