package Maze.Swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final static String TITLE = "Maze";
    public final static Color DEFAULT_BACKGROUND = new Color(235, 235, 255);
    public final static Image START_ICON = new ImageIcon("src\\Maze\\Files\\HOME.png").getImage();
    public final static Image GOAL_ICON = new ImageIcon("src\\Maze\\Files\\FINNISH.png").getImage();
    public final static Image BRIDGE_ICON = new ImageIcon("src\\Maze\\Files\\BRIDGE.png").getImage();
    public final static Image NO_FLY_ZONE_ICON = new ImageIcon("src\\Maze\\Files\\NO_FLY_ZONE.png").getImage();
    public final static Image WALL_ICON = new ImageIcon("src\\Maze\\Files\\WALL.png").getImage();
    public final static Image WATER_ICON = new ImageIcon("src\\Maze\\Files\\WATER.png").getImage();
    public final static Image BRIDGE_PATH_ICON = new ImageIcon("src\\Maze\\Files\\BRIDGE_PATH.png").getImage();
    public final static Image NO_FLY_ZONE_PATH_ICON = new ImageIcon("src\\Maze\\Files\\NO:FLY_ZONE_PATH.png").getImage();
    public final static Image WALL_PATH_ICON = new ImageIcon("src\\Maze\\Files\\WALL_PATH.png").getImage();
    public final static Image WATER_PATH_ICON = new ImageIcon("src\\Maze\\Files\\WATER_PATH.png").getImage();
    public final static Image EMPTY_FIELD_PATH_ICON = new ImageIcon("src\\Maze\\Files\\EMPTY_FIELD_PATH.png").getImage();




    public MainFrame() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(DEFAULT_BACKGROUND);
        setBackground(DEFAULT_BACKGROUND);

        MainPanel mainPanel = new MainPanel();
        setContentPane(mainPanel);

        //add(mainPanel);
        pack();
        setVisible(true);
    }
}

