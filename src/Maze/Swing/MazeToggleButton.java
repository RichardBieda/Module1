package Maze.Swing;

import javax.swing.*;
import java.awt.*;
 class MazeToggleButton extends JToggleButton {

    MazeToggleButton(String text) {
        super(text);
        setBackground(Color.WHITE);
        setForeground(Color.black);
        setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        setBorderPainted(true);
        setContentAreaFilled(true);
        setFocusable(false);
        setOpaque(true);
    }
}
