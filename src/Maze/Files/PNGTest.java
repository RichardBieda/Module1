package Maze.Files;

import javax.swing.*;
import java.awt.*;

class PNGTest extends JFrame {

    static Image icon = new ImageIcon("src\\Maze\\Files\\HOME.png").getImage();

    PNGTest() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new APanel());
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PNGTest::new);
     }

     class APanel extends JPanel {

        APanel() {
            setPreferredSize(new Dimension(400, 400));
            setLayout(new GridBagLayout());
        }

        @Override
         protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(icon, 0, 0, getWidth(), getHeight(), this);
        }
     }
}
