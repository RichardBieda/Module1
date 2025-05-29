package Maze.Swing;

import javax.swing.*;
import java.awt.*;

class MenuPanel extends JPanel {

    private final static int DEFAULT_MENUPANEL_WIDTH = 480;
    private final static int DEFAULT_MENUPANEL_HEIGHT = 1020;
    private final JSlider slider;
    private final MazeToggleButton EMPTY_FIELD;
    private final MazeToggleButton BRIDGE;
    private final MazeToggleButton GOAL;
    private final MazeToggleButton NO_FLY_ZONE;
    private final MazeToggleButton START;
    private final MazeToggleButton WALL;
    private final MazeToggleButton WATER;

    MenuPanel() {
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(3, 0));
        setOpaque(true);
        setPreferredSize(new Dimension(DEFAULT_MENUPANEL_WIDTH, DEFAULT_MENUPANEL_HEIGHT));

        //creation of panel1
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setOpaque(true);
        panel1.setBackground(MainFrame.DEFAULT_BACKGROUND);

        slider = new JSlider(1, 5, 1);
        slider.setBackground(MainFrame.DEFAULT_BACKGROUND);
        slider.setMajorTickSpacing(1);
        slider.setPreferredSize(new Dimension(300, 100));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        //creation of panel 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.setOpaque(true);
        panel2.setBackground(MainFrame.DEFAULT_BACKGROUND);
        ButtonGroup buttonGroup = new ButtonGroup();

        EMPTY_FIELD = new MazeToggleButton("Empty field");
        BRIDGE = new MazeToggleButton("Bridge");
        GOAL = new MazeToggleButton("Destinatin");
        NO_FLY_ZONE = new MazeToggleButton("No fly zone ");
        START = new MazeToggleButton("Start");
        WALL = new MazeToggleButton("Wall");
        WATER = new MazeToggleButton("Water");
        buttonGroup.add(EMPTY_FIELD);
        buttonGroup.add(BRIDGE);
        buttonGroup.add(GOAL);
        buttonGroup.add(NO_FLY_ZONE);
        buttonGroup.add(START);
        buttonGroup.add(WALL);
        buttonGroup.add(WATER);

        //creation of panel 3
        JPanel panel3 = new JPanel();
        panel3.setBackground(MainFrame.DEFAULT_BACKGROUND);
        panel3.setLayout(new GridBagLayout());
        panel3.setOpaque(true);

        //adding to panel 1
        panel1.add(slider);
        //adding to panel 2
        panel2.add(EMPTY_FIELD);
        panel2.add(BRIDGE);
        panel2.add(GOAL);
        panel2.add(NO_FLY_ZONE);
        panel2.add(START);
        panel2.add(WALL);
        panel2.add(WATER);
        //adding all sub panels to menu panel
        add(panel1);
        add(panel2);
        add(panel3);
    }

    void addMenuPanelAction(MenuActionListener listener) {
        EMPTY_FIELD.addActionListener(listener);
        BRIDGE.addActionListener(listener);
        GOAL.addActionListener(listener);
        NO_FLY_ZONE.addActionListener(listener);
        START.addActionListener(listener);
        WALL.addActionListener(listener);
        WATER.addActionListener(listener);
    }
}
