package Maze.SwingComponents;

import Maze.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HeadPanel extends JPanel  {

    private final static String TITLE = "create aMAZEing paths";
    private final static String NEW_MAZE_BUTTON_TEXT = "create new maze";
    private final static String SOLVE_BUTTON_TEXT = "solve maze";
    private final HeadButton NEW_MAZE_BUTTON;
    private final HeadButton SOLVE_BUTTON;
    private final UserButton PEDESTRIAN;
    private final UserButton AIRPLANE;
    private final UserButton AMPHIBIOUS;
    private final UserButton BOAT;

    HeadPanel() {
        setBackground(MazeUI.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(2, 0));
        setOpaque(true);

        JLabel UPPER_LABEL = new JLabel(TITLE);
        UPPER_LABEL.setFont(new Font(Font.SERIF, Font.ITALIC, 65));
        UPPER_LABEL.setHorizontalAlignment(JTextField.CENTER);

        JPanel LOWER_PANEL = new JPanel();
        LOWER_PANEL.setBackground(MazeUI.DEFAULT_BACKGROUND);
        LOWER_PANEL.setLayout(new GridLayout(2, 0));

        JPanel LOWER_PANEL_ONE = new JPanel();
        LOWER_PANEL_ONE.setBackground(MazeUI.DEFAULT_BACKGROUND);
        NEW_MAZE_BUTTON = new HeadButton(NEW_MAZE_BUTTON_TEXT);
        SOLVE_BUTTON = new HeadButton(SOLVE_BUTTON_TEXT);
        LOWER_PANEL_ONE.add(NEW_MAZE_BUTTON);
        LOWER_PANEL_ONE.add(SOLVE_BUTTON);

        JPanel LOWER_PANEL_TWO = new JPanel();
        LOWER_PANEL_TWO.setBackground(MazeUI.DEFAULT_BACKGROUND);
        PEDESTRIAN = new UserButton(User.PEDESTRIAN.name());
        AIRPLANE = new UserButton(User.AIRPLANE.name());
        AMPHIBIOUS = new UserButton(User.AMPHIBIOUS.name());
        BOAT = new UserButton(User.BOAT.name());
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(PEDESTRIAN);
        buttonGroup.add(AIRPLANE);
        buttonGroup.add(AMPHIBIOUS);
        buttonGroup.add(BOAT);
        PEDESTRIAN.setSelected(true);

        LOWER_PANEL_TWO.add(PEDESTRIAN);
        LOWER_PANEL_TWO.add(AIRPLANE);
        LOWER_PANEL_TWO.add(AMPHIBIOUS);
        LOWER_PANEL_TWO.add(BOAT);

        LOWER_PANEL.add(LOWER_PANEL_ONE);
        LOWER_PANEL.add(LOWER_PANEL_TWO);
        add(UPPER_LABEL);
        add(LOWER_PANEL);
    }

    HeadButton getNEW_MAZE_BUTTON() {
        return NEW_MAZE_BUTTON;
    }

    HeadButton getSOLVE_BUTTON() {
        return SOLVE_BUTTON;
    }

    UserButton getPEDESTRIAN() {
        return PEDESTRIAN;
    }

     UserButton getAIRPLANE() {
        return AIRPLANE;
    }

    UserButton getAMPHIBIOUS() {
        return AMPHIBIOUS;
    }

    UserButton getBOAT() {
        return BOAT;
    }
}
