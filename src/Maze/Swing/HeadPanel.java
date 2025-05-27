package Maze.Swing;

import javax.swing.*;
import java.awt.*;
import Maze.User.*;

class HeadPanel extends JPanel {

    private final static String TITLE = "create aMAZEing paths";
    private final static String NEW_MAZE_BUTTON_TEXT = "create new maze";
    private final static String SOLVE_BUTTON_TEXT = "solve maze";
    private final static int DEFAULT_HEADPANEL_WIDTH = 1600;
    private final static int DEFAULT_HEADPANEL_HEIGHT = 180;
    private final HeadButton NEW_MAZE_BUTTON;
    private final HeadButton SOLVE_BUTTON;
    private final UserButton PEDESTRIAN;
    private final UserButton AIRPLANE;
    private final UserButton AMPHIBIOUS;
    private final UserButton BOAT;

    HeadPanel() {
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(2, 0));
        setOpaque(true);
//        setSize(new Dimension(DEFAULT_HEADPANEL_WIDTH, DEFAULT_HEADPANEL_HEIGHT));
        setPreferredSize(new Dimension(DEFAULT_HEADPANEL_WIDTH, DEFAULT_HEADPANEL_HEIGHT));
//        setMaximumSize(new Dimension(DEFAULT_HEADPANEL_WIDTH, DEFAULT_HEADPANEL_HEIGHT));
//        setMinimumSize(new Dimension(DEFAULT_HEADPANEL_WIDTH, DEFAULT_HEADPANEL_HEIGHT));

        //create upper panel
        JPanel UPPER_PANEL = new JPanel();
        UPPER_PANEL.setOpaque(true);
        UPPER_PANEL.setBackground(MainFrame.DEFAULT_BACKGROUND);
        //create lower panel
        JPanel LOWER_PANEL = new JPanel();
        LOWER_PANEL.setBackground(MainFrame.DEFAULT_BACKGROUND);
        LOWER_PANEL.setLayout(new GridLayout(2, 0));
        LOWER_PANEL.setOpaque(true);
        //create lower panel 1
        JPanel LOWER_PANEL_ONE = new JPanel();
        LOWER_PANEL_ONE.setBackground(MainFrame.DEFAULT_BACKGROUND);
        LOWER_PANEL_ONE.setOpaque(true);
        //create lower panel 2
        JPanel LOWER_PANEL_TWO = new JPanel();
        LOWER_PANEL_TWO.setBackground(MainFrame.DEFAULT_BACKGROUND);
        LOWER_PANEL_TWO.setOpaque(true);
        //create titel label
        JLabel titelLabel = new JLabel(TITLE);
        titelLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 65));
        titelLabel.setHorizontalAlignment(JTextField.CENTER);
        titelLabel.setBackground(MainFrame.DEFAULT_BACKGROUND);
        //assign buttons
        NEW_MAZE_BUTTON = new HeadButton(NEW_MAZE_BUTTON_TEXT);
        SOLVE_BUTTON = new HeadButton(SOLVE_BUTTON_TEXT);
        PEDESTRIAN = new UserButton(User.PEDESTRIAN.name());
        AIRPLANE = new UserButton(User.AIRPLANE.name());
        AMPHIBIOUS = new UserButton(User.AMPHIBIOUS.name());
        BOAT = new UserButton(User.BOAT.name());
        //create button grout for users
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(PEDESTRIAN);
        buttonGroup.add(AIRPLANE);
        buttonGroup.add(AMPHIBIOUS);
        buttonGroup.add(BOAT);
        PEDESTRIAN.setSelected(true);
        //insert titel to upper panel
        UPPER_PANEL.add(titelLabel);
        //insert head buttons to lower panel 1
        LOWER_PANEL_ONE.add(NEW_MAZE_BUTTON);
        LOWER_PANEL_ONE.add(SOLVE_BUTTON);
        //insert radio buttons to lower panel 2
        LOWER_PANEL_TWO.add(PEDESTRIAN);
        LOWER_PANEL_TWO.add(AIRPLANE);
        LOWER_PANEL_TWO.add(AMPHIBIOUS);
        LOWER_PANEL_TWO.add(BOAT);
        //insert both lower panels to lower panle
        LOWER_PANEL.add(LOWER_PANEL_ONE);
        LOWER_PANEL.add(LOWER_PANEL_TWO);
        //insert upper and lower panel to head panel
        add(UPPER_PANEL);
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
