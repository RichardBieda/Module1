package Maze.Swing;

import Maze.MazeLabels.*;
import Maze.User.User;

import javax.swing.*;
import java.awt.*;

class MenuPanel extends JPanel {

    private final static int DEFAULT_MENUPANEL_WIDTH = 480;
    private final static int DEFAULT_MENUPANEL_HEIGHT = 1020;
    private final static String NEW_MAZE_BUTTON_TEXT = "create new maze";
    private final static String SOLVE_BUTTON_TEXT = "solve maze";
    private final MazeToggleButton VERTICAL;
    private final MazeToggleButton HORIZONTAL;
    private final JSlider slider;
    private final MazeToggleButton EMPTY_FIELD;
    private final MazeToggleButton BRIDGE;
    private final MazeToggleButton GOAL;
    private final MazeToggleButton NO_FLY_ZONE;
    private final MazeToggleButton START;
    private final MazeToggleButton WALL;
    private final MazeToggleButton WATER;
    private final MazeToggleButton PEDESTRIAN;
    private final MazeToggleButton AIRPLANE;
    private final MazeToggleButton AMPHIBIOUS;
    private final MazeToggleButton BOAT;
    private final HeadButton NEW_MAZE_BUTTON;
    private final HeadButton SOLVE_BUTTON;

    MenuPanel() {
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(3, 0));
        setOpaque(true);
        setPreferredSize(new Dimension(DEFAULT_MENUPANEL_WIDTH, DEFAULT_MENUPANEL_HEIGHT));

        //creation of panel1
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,0));
        panel1.setOpaque(true);
        panel1.setBackground(MainFrame.DEFAULT_BACKGROUND);

        JPanel mazeNSolvePanel = new JPanel();
        mazeNSolvePanel.setBackground(MainFrame.DEFAULT_BACKGROUND);
        mazeNSolvePanel.setOpaque(true);
        NEW_MAZE_BUTTON = new HeadButton(NEW_MAZE_BUTTON_TEXT);
        SOLVE_BUTTON = new HeadButton(SOLVE_BUTTON_TEXT);
        mazeNSolvePanel.add(NEW_MAZE_BUTTON);
        mazeNSolvePanel.add(SOLVE_BUTTON);

        JPanel userPanel = new JPanel();
        userPanel.setBackground(MainFrame.DEFAULT_BACKGROUND);
        userPanel.setLayout(new FlowLayout());
        userPanel.setOpaque(true);
        PEDESTRIAN = new MazeToggleButton(User.PEDESTRIAN.name());
        AIRPLANE = new MazeToggleButton(User.AIRPLANE.name());
        AMPHIBIOUS = new MazeToggleButton(User.AMPHIBIOUS.name());
        BOAT = new MazeToggleButton(User.BOAT.name());
        userPanel.add(PEDESTRIAN);
        userPanel.add(AIRPLANE);
        userPanel.add(AMPHIBIOUS);
        userPanel.add(BOAT);

        ButtonGroup userGroup = new ButtonGroup();
        userGroup.add(PEDESTRIAN);
        userGroup.add(AIRPLANE);
        userGroup.add(AMPHIBIOUS);
        userGroup.add(BOAT);
        PEDESTRIAN.setSelected(true);
        //creation of panel 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 0));
        panel2.setOpaque(true);
        panel2.setBackground(MainFrame.DEFAULT_BACKGROUND);

        JPanel XYPanel = new JPanel();
        XYPanel.setBackground(MainFrame.DEFAULT_BACKGROUND);
        XYPanel.setLayout(new GridBagLayout());
        XYPanel.setOpaque(true);

        ButtonGroup XYGroup = new ButtonGroup();
        VERTICAL = new MazeToggleButton("vertical");
        HORIZONTAL = new MazeToggleButton("horizontal");
        HORIZONTAL.setSelected(true);
        XYGroup.add(VERTICAL);
        XYGroup.add(HORIZONTAL);
        XYPanel.add(HORIZONTAL);
        XYPanel.add(VERTICAL);


        JPanel sliderPanel = new JPanel();
        sliderPanel.setBackground(MainFrame.DEFAULT_BACKGROUND);
        sliderPanel.setLayout(new GridBagLayout());
        sliderPanel.setOpaque(true);
        slider = new JSlider(1, 10, 1);
        slider.setBackground(MainFrame.DEFAULT_BACKGROUND);
        slider.setMajorTickSpacing(1);
        slider.setPreferredSize(new Dimension(280, 100));
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        sliderPanel.add(slider);

        //creation of panel 3
        JPanel panel3 = new JPanel();
        panel3.setBackground(MainFrame.DEFAULT_BACKGROUND);
        panel3.setLayout(new FlowLayout());
        panel3.setOpaque(true);

        ButtonGroup fieldGroup = new ButtonGroup();
        EMPTY_FIELD = new MazeToggleButton("Empty field");
        BRIDGE = new MazeToggleButton("Bridge");
        GOAL = new MazeToggleButton("Goal");
        NO_FLY_ZONE = new MazeToggleButton("No fly zone ");
        START = new MazeToggleButton("Start");
        WALL = new MazeToggleButton("Wall");
        WATER = new MazeToggleButton("Water");
        EMPTY_FIELD.setSelected(true);
        fieldGroup.add(EMPTY_FIELD);
        fieldGroup.add(BRIDGE);
        fieldGroup.add(GOAL);
        fieldGroup.add(NO_FLY_ZONE);
        fieldGroup.add(START);
        fieldGroup.add(WALL);
        fieldGroup.add(WATER);

        //adding to panel 1
        panel1.add(mazeNSolvePanel);
        panel1.add(userPanel);
        //adding to panel 2
        panel2.add(XYPanel);
        panel2.add(sliderPanel);
        //adding to panel 3
        panel3.add(EMPTY_FIELD);
        panel3.add(BRIDGE);
        panel3.add(NO_FLY_ZONE);
        panel3.add(WALL);
        panel3.add(WATER);
        panel3.add(START);
        panel3.add(GOAL);
        //adding all sub panels to menu panel
        add(panel1);
        add(panel2);
        add(panel3);
    }

    void addMenuPanelAction(MainPanel mainPanel) {
        HORIZONTAL.addItemListener(e -> mainPanel.getMazePanel().getListener().setOri(true));
        VERTICAL.addItemListener(e -> mainPanel.getMazePanel().getListener().setOri(false));

        slider.addChangeListener(e -> mainPanel.getMazePanel().getListener().setSliderValue(slider.getValue()));

        EMPTY_FIELD.addChangeListener(e -> mainPanel.getMazePanel().getListener().setAClass(EmptyField.class));
        BRIDGE.addChangeListener(e -> mainPanel.getMazePanel().getListener().setAClass(Bridge.class));
        GOAL.addChangeListener(e -> mainPanel.getMazePanel().getListener().setAClass(Goal.class));
        NO_FLY_ZONE.addChangeListener(e -> mainPanel.getMazePanel().getListener().setAClass(NoFlyZone.class));
        START.addChangeListener(e -> mainPanel.getMazePanel().getListener().setAClass(Start.class));
        WALL.addChangeListener(e -> mainPanel.getMazePanel().getListener().setAClass(Wall.class));
        WATER.addChangeListener(e -> mainPanel.getMazePanel().getListener().setAClass(Water.class));

        PEDESTRIAN.addItemListener(e -> mainPanel.getMazePanel().setMovable(User.getMovable(User.PEDESTRIAN)));
        AIRPLANE.addItemListener(e -> mainPanel.getMazePanel().setMovable(User.getMovable(User.AIRPLANE)));
        AMPHIBIOUS.addItemListener(e -> mainPanel.getMazePanel().setMovable(User.getMovable(User.AMPHIBIOUS)));
        BOAT.addItemListener(e -> mainPanel.getMazePanel().setMovable(User.getMovable(User.BOAT)));
    }

    void addCreateAndSolveAction(HeadActionListener listener) {
        NEW_MAZE_BUTTON.addActionListener(listener);
        SOLVE_BUTTON.addActionListener(listener);
    }

    MazeToggleButton getPEDESTRIAN() {
        return PEDESTRIAN;
    }

    MazeToggleButton getAIRPLANE() {
        return AIRPLANE;
    }

    MazeToggleButton getAMPHIBIOUS() {
        return AMPHIBIOUS;
    }

    MazeToggleButton getBOAT() {
        return BOAT;
    }

    HeadButton getNEW_MAZE_BUTTON() {
        return NEW_MAZE_BUTTON;
    }

    HeadButton getSOLVE_BUTTON() {
        return SOLVE_BUTTON;
    }
}
