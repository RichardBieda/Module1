package Maze.SwingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeadButton extends JButton {

    HeadButton(String text) {
        super(text);
        setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        setBackground(new Color(235, 235, 255));
        setFocusable(false);
        setOpaque(true);
    }
}
