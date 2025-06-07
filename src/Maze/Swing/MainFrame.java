package Maze.Swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final static String TITLE = "Maze";
    final static Color DEFAULT_BACKGROUND = new Color(235, 235, 255);
    private final static Image BRIDGE_ICON = new ImageIcon("src\\Maze\\Files\\BRIDGE.png").getImage();
    private final static Image FINNISH_ICON = new ImageIcon("src\\Maze\\Files\\FINNISH.png").getImage();
    private final static Image HOME_ICON = new ImageIcon("src\\Maze\\Files\\HOME.png").getImage();
    private final static Image NO_FLY_ZONE_ICON = new ImageIcon("src\\Maze\\Files\\NO_FLY_ZONE.png").getImage();
    private final static Image WALL_ICON = new ImageIcon("src\\Maze\\Files\\WALL.png").getImage();
    private final static Image WATER_ICON = new ImageIcon("src\\Maze\\Files\\WATER.png").getImage();


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

