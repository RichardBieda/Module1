package SwingConcurrency;

import javax.swing.*;
import java.awt.*;

public class ProgressDemo {

    ProgressDemo() {
        JFrame frame = new JFrame("Progress Demo");
        JButton button = new JButton("Start");
        button.setPreferredSize(new Dimension(200, 200));
        JProgressBar bar = new JProgressBar();
        bar.setStringPainted(true);
        bar.setPreferredSize(new Dimension(200, 200));

        bar.setOpaque(true);

        button.addActionListener((e) -> {
            button.setEnabled(false);
            SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    System.out.println("ActionListener, SwingWorker, diInBackGround- " + Thread.currentThread().getName());
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(50);
                        publish(i);
                    }
                    return null;
                }
                @Override
                protected void process(java.util.List<Integer> chunks) {
                    int tmp = chunks.get(chunks.size() - 1);
                    bar.setValue(tmp);
                    System.out.println("ActionListener, SwingWorker, process - " + Thread.currentThread().getName());
                }
                @Override
                protected void done() {
                    frame.repaint();
                    button.setEnabled(true);
                    System.out.println("ActionListener, SwingWorker, done - " + Thread.currentThread().getName());
                }
            };
            worker.execute();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(bar);
        frame.add(button);
        frame.pack();
        frame.setVisible(true);
        System.out.println("end of frame constructor - " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("main method - " + Thread.currentThread().getName());
        SwingUtilities.invokeLater(ProgressDemo::new);
    }
}
