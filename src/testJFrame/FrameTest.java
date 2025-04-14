package testJFrame;

import javax.swing.*;

public class FrameTest extends JFrame {

    //Frame class
    FrameTest() {
        setTitle("Imported frame");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1200, 800);
    }
}
