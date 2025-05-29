package Maze.Swing;

import Maze.Maze;
import Maze.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import Maze.InvalidSizeException;

class HeadActionListener implements ActionListener {

    private final MainPanel mainPanel;

    HeadActionListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainPanel.getHeadPanel().getNEW_MAZE_BUTTON()) {
            newMazeButtonPressed();
        } else if (e.getSource() == mainPanel.getHeadPanel().getSOLVE_BUTTON()) {
            solveButtonPressed();
        } else if (e.getSource() == mainPanel.getHeadPanel().getPEDESTRIAN()) {
            mainPanel.getMazePanel().setMovable(User.getMovable(User.PEDESTRIAN));
            System.out.println(mainPanel.getMazePanel().getMovable());
        } else if (e.getSource() == mainPanel.getHeadPanel().getAIRPLANE()) {
            mainPanel.getMazePanel().setMovable(User.getMovable(User.AIRPLANE));
            System.out.println(mainPanel.getMazePanel().getMovable());
        } else if (e.getSource() == mainPanel.getHeadPanel().getAMPHIBIOUS()) {
            mainPanel.getMazePanel().setMovable(User.getMovable(User.AMPHIBIOUS));
            System.out.println(mainPanel.getMazePanel().getMovable());
        } else if (e.getSource() == mainPanel.getHeadPanel().getBOAT()) {
            mainPanel.getMazePanel().setMovable(User.getMovable(User.BOAT));
            System.out.println(mainPanel.getMazePanel().getMovable());
        }
    }

    private void newMazeButtonPressed() {
        mainPanel.getHeadPanel().getNEW_MAZE_BUTTON().setEnabled(false);
        mainPanel.getHeadPanel().getSOLVE_BUTTON().setEnabled(false);
        CreateMazeWindow nmw = new CreateMazeWindow(mainPanel.getHeadPanel().getNEW_MAZE_BUTTON());
        nmw.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                mainPanel.getHeadPanel().getNEW_MAZE_BUTTON().setEnabled(true);
                mainPanel.getHeadPanel().getSOLVE_BUTTON().setEnabled(true);
            }
        });
        nmw.getCreateButton().addActionListener(e1 -> {
            try {
                int y = Integer.parseInt(nmw.getIntHeight().getText());
                int x = Integer.parseInt(nmw.getIntWidth().getText());
                Maze.checkMazeSize(y, x);
                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    MazePanel tmp = null;
                    @Override
                    protected Void doInBackground() throws Exception {
                        System.out.println("newMazeButton doInBackground: " + Thread.currentThread());
                        tmp = new MazePanel(x, y);
                        tmp.addAllFields();
                        return null;
                    }
                    @Override
                    protected void done() {
                        mainPanel.remove(mainPanel.getMazePanel());
                        mainPanel.setMazePanel(tmp);
                        mainPanel.setFrameLayout();
                        mainPanel.revalidate();
                        mainPanel.repaint();
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
        System.out.println("ttttttttttt");
    }
}
