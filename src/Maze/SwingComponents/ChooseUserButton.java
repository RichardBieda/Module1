package Maze.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class ChooseUserButton extends JRadioButton {

    ChooseUserButton(String text) {
        super(text);
        setBackground(MazeUI.DEFAULT_BACKGROUND);
        setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        setOpaque(true);
    }
}
