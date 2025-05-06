package Maze.SwingComponents;

import javax.swing.*;
import java.awt.*;

class UserButton extends JRadioButton {


    UserButton(String text) {
        super(text);
        setBackground(MazeUI.DEFAULT_BACKGROUND);
        setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        setFocusable(false);
        setOpaque(true);
    }
}
