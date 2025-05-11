package SwingConcurrency;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.concurrent.Future;

class ExecutorSwingWorkerDemo extends JFrame {

    JButton startButton;
    JButton abbrechenButton;
    JTextArea textArea;
    SwingWorker<Void, String> worker;
    ExecutorSwingWorkerDemo(String text) {
        super(text);
        startButton = new JButton("Start");
        abbrechenButton = new JButton("abbrechen");
        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(abbrechenButton);
        textArea = new JTextArea(10, 30);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton.addActionListener(e -> {
            startButton.setEnabled(false);
            if (abbrechenButton.getText().equals("abgebrochen")) {abbrechenButton.setText("abbrechen");}
            textArea.setText("");
            worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    ExecutorService executor = Executors.newFixedThreadPool(3);
                    List<Callable<String>> tasks = new ArrayList<>();
                    for (int i = 1; i <= 5; i++) {
                        int taskId = i;
                        tasks.add(() -> {
                            Thread.sleep(1000 + (int) (Math.random() * 2000));
                            return "Task " + taskId + " fertig (Thread: " + Thread.currentThread().getName() + ")";
                        });
                    }
                    List<Future<String>> results = executor.invokeAll(tasks);
                    executor.shutdown();
                    for (Future<String> result : results) {
                        if(!isCancelled()) {publish(result.get());}
                    }
                    for (Future<String> result : results) {
                        if (isCancelled()) break;
                        publish(result.get());
                    }
                    return null;
                }
                @Override
                protected void process(java.util.List<String> chunks) {
                    for (String msg : chunks) {textArea.append(msg + "\n");}
                }
                @Override
                protected void done() {
                    if (isCancelled()) {
                        textArea.append("SwingWorker wurde abgebrochen.\n");
                        abbrechenButton.setText("abgebrochen");
                    } else {
                        textArea.append("Alle tasks abgeschlossen");
                    }
                    startButton.setEnabled(true);
                }
            };
            worker.execute();
            abbrechenButton.addActionListener(e1 -> {
                if (worker != null && !worker.isDone()) {
                    worker.cancel(true);
                }
            });
        });

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("mainMethode " + Thread.currentThread().getName());
        SwingUtilities.invokeLater(() -> new ExecutorSwingWorkerDemo("ExecutorSwingWorkerDemo"));
    }
}
