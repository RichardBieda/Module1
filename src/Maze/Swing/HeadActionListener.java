package Maze.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Maze.InvalidSizeException;

class HeadActionListener implements ActionListener {

    private final MainFrame frame;

    HeadActionListener(MainFrame frame) {
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frame.getMainPanel().getMenuPanel().getNEW_MAZE_BUTTON()) {
            newMazeButtonPressed();
        } else if (e.getSource() == frame.getMainPanel().getMenuPanel().getSOLVE_BUTTON()) {
            solveButtonPressed();
        }
    }

    private void newMazeButtonPressed() {
        frame.getMainPanel().getMenuPanel().getNEW_MAZE_BUTTON().setEnabled(false);
        frame.getMainPanel().getMenuPanel().getSOLVE_BUTTON().setEnabled(false);
        CreateMazeWindow nmw = new CreateMazeWindow(frame.getMainPanel().getMenuPanel().getNEW_MAZE_BUTTON());
        nmw.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                frame.getMainPanel().getMenuPanel().getNEW_MAZE_BUTTON().setEnabled(true);
                frame.getMainPanel().getMenuPanel().getSOLVE_BUTTON().setEnabled(true);
            }
        });
        nmw.getCreateButton().addActionListener(e1 -> {
            try {
                int y = Integer.parseInt(nmw.getIntHeight().getText());
                int x = Integer.parseInt(nmw.getIntWidth().getText());
                MazePanel.checkMazeSize(y, x);
                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    MazePanel tmp = null;
                    @Override
                    protected Void doInBackground() throws Exception {
                        tmp = new MazePanel(x,y);
                        tmp.setFields();
                        return null;
                    }
                    @Override
                    protected void done() {
                        frame.getMainPanel().remove(frame.getMainPanel().getMazePanel());
                        frame.getMainPanel().setMazePanel(tmp);
                        frame.getMainPanel().setFrameLayout();
                        frame.getMainPanel().revalidate();
                        frame.getMainPanel().repaint();
                    }
                };
                worker.execute();
            } catch (NumberFormatException | InvalidSizeException e) {
                JLabel label = new JLabel("your input is invalid");
                label.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
                JOptionPane.showMessageDialog(nmw, label, "Something went wrong", JOptionPane.WARNING_MESSAGE);
            } finally {
                nmw.dispose();
            }
        });
        nmw.getExitButton().addActionListener(e -> {
            nmw.dispose();
        });
    }

    private void solveButtonPressed() {
//        System.out.println(mainPanel.getMenuPanel().getFieldClass());
//        System.out.println(mainPanel.getMazePanel().getMovable());
//        System.out.println(mainPanel.getMenuPanel().getOrientation());
//        System.out.println(mainPanel.getMenuPanel().getSliderValue());
        for (int i = 0; i < frame.getMainPanel().getMazePanel().getFields().length; i++) {
            for (int j = 0; j < frame.getMainPanel().getMazePanel().getFields()[i].length; j++) {
                System.out.print(frame.getMainPanel().getMazePanel().getFields()[i][j]);
            }
            System.out.println();
        }
    }
}
