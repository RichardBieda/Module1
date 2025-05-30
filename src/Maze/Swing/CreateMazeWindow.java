package Maze.Swing;

import javax.swing.*;
import java.awt.*;

class CreateMazeWindow extends JFrame {
    private final static String WINDOW_TEXT = "Maze creator";
    private final static String WIDTH_TEXT = "width x :";
    private final static String HEIGHT_TEXT = "height y :";
    private final static String CREATE = "create";
    private final static String EXIT = "exit";
    private final static int WIDTH = 320;
    private final static int HEIGHT = 180;
    private final JTextField intWidth;
    private final JTextField intHeight;
    private final JButton createButton;
    private final JButton exitButton;

    CreateMazeWindow(JComponent jComponent) {
        super(WINDOW_TEXT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(jComponent);
        getContentPane().setBackground(MainFrame.DEFAULT_BACKGROUND);
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(3, 2));

        JLabel width = new JLabel(WIDTH_TEXT);
        width.setBackground(MainFrame.DEFAULT_BACKGROUND);
        width.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        width.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel height = new JLabel(HEIGHT_TEXT);
        height.setBackground(MainFrame.DEFAULT_BACKGROUND);
        height.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        height.setHorizontalAlignment(SwingConstants.CENTER);

        intWidth = new JTextField();
        intWidth.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
        intHeight = new JTextField();
        intHeight.setFont(new Font(Font.DIALOG, Font.BOLD, 25));

        createButton = new HeadButton(CREATE);

        exitButton = new HeadButton(EXIT);

        add(width);
        add(intWidth);
        add(height);
        add(intHeight);
        add(createButton);
        add(exitButton);

        setVisible(true);
    }

    JTextField getIntWidth() {
        return intWidth;
    }

    JTextField getIntHeight() {
        return intHeight;
    }

    JButton getCreateButton() {
        return createButton;
    }
    JButton getExitButton() {return exitButton; }
}
