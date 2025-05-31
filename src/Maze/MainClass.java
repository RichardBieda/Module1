package Maze;

import javax.swing.*;
import Maze.Swing.MainFrame;

class MainClass {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(MainFrame::new);
    }
}
