package Maze.SwingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeadPanel extends JPanel {

    private final JLabel UPPER_LABEL;
    private final JPanel LOWER_PANEL;
    private final HeadButton NEW_MAZE_BUTTON;
    private final HeadButton SOLVE_BUTTON;
    HeadPanel() {
        setBackground(new Color(235, 235, 255));
        setLayout(new GridLayout(2, 0));
        setOpaque(true);

        UPPER_LABEL = new JLabel("create aMAZEing paths");
        UPPER_LABEL.setFont(new Font(Font.SERIF, Font.ITALIC, 45));
        UPPER_LABEL.setHorizontalAlignment(JTextField.CENTER);

        LOWER_PANEL = new JPanel();
        LOWER_PANEL.setBackground(new Color(235, 235, 255));

        NEW_MAZE_BUTTON = new HeadButton("create new maze");
        SOLVE_BUTTON = new HeadButton("solve maze");

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
