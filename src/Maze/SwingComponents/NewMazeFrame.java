package Maze.SwingComponents;
import javax.swing.*;
import java.awt.*;

class NewMazeFrame extends JFrame {

    private final static String WINDOW_TEXT = "Maze creator";
    private final static String WIDTH_TEXT = "width x :";
    private final static String HEIGHT_TEXT = "height y :";
    private final static String CREATE = "create";
    private final static String EXIT = "exit";

    private final JTextField intWidth;
    private final JTextField intHeight;
    private final JButton createButton;
    private final JButton exitButton;

    NewMazeFrame(JComponent jComponent) {
        super(WINDOW_TEXT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(jComponent);
        getContentPane().setBackground(MazeUI.DEFAULT_BACKGROUND);
        setSize(320, 180);
        setLayout(new GridLayout(3, 2));

        JLabel width = new JLabel(WIDTH_TEXT);
        width.setBackground(MazeUI.DEFAULT_BACKGROUND);
        width.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        width.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel height = new JLabel(HEIGHT_TEXT);
        height.setBackground(MazeUI.DEFAULT_BACKGROUND);
        height.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
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
}
