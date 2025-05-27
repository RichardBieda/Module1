package Maze;

import javax.swing.*;
import Maze.Swing.MainFrame;

class MainClass {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(MainFrame::new);
        System.out.println(UIManager.getLookAndFeel());
    }
}
