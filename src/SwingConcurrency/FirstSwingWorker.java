package SwingConcurrency;

import javax.swing.*;
import java.awt.*;

public class FirstSwingWorker {

    FirstSwingWorker() {
        JFrame frame = new JFrame("Blocking Demo");

        JButton button = new JButton("Button");
        button.setPreferredSize(new Dimension(200, 200));

        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(200, 200));
        label.setBackground(Color.BLUE);
        label.setOpaque(true);

        button.addActionListener((e) -> {
            button.setEnabled(false);
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    Thread.sleep(5000);
                    if (label.getBackground().equals(Color.BLUE)) {
                        label.setBackground(Color.black);
                    } else {
                        label.setBackground(Color.BLUE);
                    }
                    System.out.println("ActionListener, SwingWorker - " + Thread.currentThread().getName());
                    return null;
                }
                @Override
                protected void done() {
                    frame.repaint();
                    button.setEnabled(true);
                }
            };
            worker.execute();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
        System.out.println("end of frame constructor - " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("main method - " + Thread.currentThread().getName());
        SwingUtilities.invokeLater(FirstSwingWorker::new);
    }
}
