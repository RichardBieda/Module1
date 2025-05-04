package Maze.SwingComponents;
import javax.swing.*;
import java.awt.*;

public class NewMazeFrame extends JFrame {

    private final static String WINDOW_TEXT = "Maze creator";
    private final static String WIDTH_TEXT = "width x :";
    private final static String HEIGHT_TEXT = "height y :";
    private final static String CREATE = "create";
    private final static String EXIT = "exit";

    JTextField intWidth;
    JTextField intHeight;
    JButton createButton;

    NewMazeFrame(JComponent jComponent) {
        super(WINDOW_TEXT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(jComponent);
        getContentPane().setBackground(new Color(235, 235, 255));
        setSize(320, 180);
        setLayout(new GridLayout(3, 2));

        JLabel width = new JLabel(WIDTH_TEXT);
        width.setBackground(new Color(235, 235, 255));
        width.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        width.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel height = new JLabel(HEIGHT_TEXT);
        height.setBackground(new Color(235, 235, 255));
        height.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        height.setHorizontalAlignment(SwingConstants.CENTER);

        intWidth = new JTextField();
        intHeight = new JTextField();

        createButton = new HeadButton(CREATE);

        JButton exitButton = new HeadButton(EXIT);
        exitButton.addActionListener(e -> dispose());

        add(width);
        add(intWidth);
        add(height);
        add(intHeight);
        add(createButton);
        add(exitButton);

        setVisible(true);
    }
}
