package Maze.Swing;

import javax.swing.*;
import java.awt.*;

class HeadPanel extends JPanel {

    private final static String TITLE = "find aMAZEing paths";
    private final static int DEFAULT_HEADPANEL_WIDTH = 1600;
    private final static int DEFAULT_HEADPANEL_HEIGHT = 180;

    HeadPanel() {
        setBackground(MainFrame.DEFAULT_BACKGROUND);
        setLayout(new GridBagLayout());
        setOpaque(true);
        setPreferredSize(new Dimension(DEFAULT_HEADPANEL_WIDTH, DEFAULT_HEADPANEL_HEIGHT));

        JLabel titelLabel = new JLabel(TITLE);
        titelLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 85));
        titelLabel.setHorizontalAlignment(JTextField.CENTER);
        titelLabel.setBackground(MainFrame.DEFAULT_BACKGROUND);

        add(titelLabel);
    }
}
