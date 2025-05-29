package Maze.Swing;

import javax.swing.*;
import java.awt.*;

public class HeadButton extends JButton {

    HeadButton(String text) {
        super(text);
        setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        setBackground(Color.WHITE);
        setFocusable(false);
        setContentAreaFilled(true);
        setOpaque(true);
    }
}
