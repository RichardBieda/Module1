package Maze.SwingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HeadButton extends JButton {

    HeadButton(String text) {
        super(text);
        setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        setBackground(MazeUI.DEFAULT_BACKGROUND);
        setFocusable(false);
        setOpaque(true);
    }
}
