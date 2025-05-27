package Maze.Swing;

import javax.swing.*;
import java.awt.*;

public class UserButton extends JRadioButton {

    UserButton(String text) {
        super(text);
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        setFocusable(false);
        setOpaque(true);
    }
}
