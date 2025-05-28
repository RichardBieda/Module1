package Maze.Swing;

import Maze.Maze;
import Maze.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Maze.InvalidSizeException;

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
        addHeadPanelAction(new HeadActionListener(this));

        mazePanel = new MazePanel();
        mazePanel.addAllFields();

        menuPanel = new MenuPanel();

        setFrameLayout();
    }

    HeadPanel getHeadPanel() {
        return headPanel;
    }

    MazePanel getMazePanel() {
        return mazePanel;
    }

    void setMazePanel(MazePanel mazePanel) {
        this.mazePanel = mazePanel;
    }

    private void addHeadPanelAction(HeadActionListener listener) {
        getHeadPanel().getNEW_MAZE_BUTTON().addActionListener(listener);
        getHeadPanel().getSOLVE_BUTTON().addActionListener(listener);
        getHeadPanel().getPEDESTRIAN().addActionListener(listener);
        getHeadPanel().getAIRPLANE().addActionListener(listener);
        getHeadPanel().getAMPHIBIOUS().addActionListener(listener);
        getHeadPanel().getBOAT().addActionListener(listener);
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
