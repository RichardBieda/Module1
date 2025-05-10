package SwingConcurrency;

import javax.swing.*;
import java.awt.*;

public class EDTDemo {

    EDTDemo() {
        JFrame frame = new JFrame("EDTDemo");

        JButton button = new JButton("Button");
        button.setPreferredSize(new Dimension(200, 200));

        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(200, 200));
        label.setBackground(Color.BLUE);
        label.setOpaque(true);

        button.addActionListener((e) -> {
            if (label.getBackground().equals(Color.BLUE)) {
                label.setBackground(Color.black);
            } else {
                label.setBackground(Color.BLUE);
            }
            System.out.println(Thread.currentThread().getName());
            frame.repaint();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        SwingUtilities.invokeLater(EDTDemo::new);
    }
}
