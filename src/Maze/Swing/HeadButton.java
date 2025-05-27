package Maze.Swing;

import javax.swing.*;
import java.awt.*;

public class HeadButton extends JButton {

    HeadButton(String text) {
        super(text);
        setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setFocusable(false);
        setOpaque(true);
    }
}
