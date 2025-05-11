package SwingConcurrency;

import javax.swing.*;
import java.awt.*;

public class CancelDemo {

    CancelDemo() {
        JFrame frame = new JFrame("Progress Demo");
        JButton button = new JButton("Start");
        JButton button2 = new JButton("abbrechen");
        button2.setPreferredSize(new Dimension(200, 200));
        button.setPreferredSize(new Dimension(200, 200));
        JProgressBar bar = new JProgressBar();
        bar.setStringPainted(true);
        bar.setPreferredSize(new Dimension(200, 200));
        bar.setOpaque(true);

        button.addActionListener((e) -> {
            if (button2.getText().equals("abgebrochen")) {button2.setText("abbrechen");}
            button.setEnabled(false);
            SwingWorker<Void,Integer> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    System.out.println("ActionListener, SwingWorker, diInBackGround- " + Thread.currentThread().getName());
                    for (int i = 0; i <= 100; i++) {
                        if (isCancelled()) break;
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
                    if (isCancelled()) {button2.setText("abgebrochen");}
                    frame.repaint();
                    button.setEnabled(true);
                    System.out.println("ActionListener, SwingWorker, done - " + Thread.currentThread().getName());
                }
            };
            button2.addActionListener(e1 -> worker.cancel(true));
            System.out.println("end of ActionListener - " + Thread.currentThread().getName());
            worker.execute();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(bar);
        frame.add(button);
        frame.add(button2);
        frame.pack();
        frame.setVisible(true);
        System.out.println("end of frame constructor - " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("main method - " + Thread.currentThread().getName());
        SwingUtilities.invokeLater(CancelDemo::new);
    }
}
