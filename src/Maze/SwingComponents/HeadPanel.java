package Maze.SwingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HeadPanel extends JPanel {

    private final static String TITLE = "create aMAZEing paths";
    private final static String NEW_MAZE_BUTTON_TEXT = "create new maze";
    private final static String SOLVE_BUTTON_TEXT = "solve maze";
    private final JLabel UPPER_LABEL;
    private final JPanel LOWER_PANEL;
    private final HeadButton NEW_MAZE_BUTTON;
    private final HeadButton SOLVE_BUTTON;

    HeadPanel() {
        setBackground(MazeUI.DEFAULT_BACKGROUND);
        setLayout(new GridLayout(2, 0));
        setOpaque(true);

        UPPER_LABEL = new JLabel(TITLE);
        UPPER_LABEL.setFont(new Font(Font.SERIF, Font.ITALIC, 45));
        UPPER_LABEL.setHorizontalAlignment(JTextField.CENTER);

        LOWER_PANEL = new JPanel();
        LOWER_PANEL.setBackground(MazeUI.DEFAULT_BACKGROUND);

        NEW_MAZE_BUTTON = new HeadButton(NEW_MAZE_BUTTON_TEXT);
        SOLVE_BUTTON = new HeadButton(SOLVE_BUTTON_TEXT);

        LOWER_PANEL.add(NEW_MAZE_BUTTON);
        LOWER_PANEL.add(SOLVE_BUTTON);

        add(UPPER_LABEL);
        add(LOWER_PANEL);
    }

    HeadButton getNEW_MAZE_BUTTON() {
        return NEW_MAZE_BUTTON;
    }

    HeadButton getSOLVE_BUTTON() {
        return SOLVE_BUTTON;
    }
}
