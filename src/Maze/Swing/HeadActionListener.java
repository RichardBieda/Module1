package Maze.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Maze.BfsSolver;
import Maze.InvalidSizeException;
import Maze.PathNotFoundException;

class HeadActionListener implements ActionListener {

    private final MainPanel mainPanel;

    HeadActionListener(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainPanel.getMenuPanel().getNEW_MAZE_BUTTON()) {
            newMazeButtonPressed();
        } else if (e.getSource() == mainPanel.getMenuPanel().getSOLVE_BUTTON()) {
            solveButtonPressed();
        }
    }

    private void newMazeButtonPressed() {
        mainPanel.getMenuPanel().getNEW_MAZE_BUTTON().setEnabled(false);
        mainPanel.getMenuPanel().getSOLVE_BUTTON().setEnabled(false);
        CreateMazeWindow nmw = new CreateMazeWindow(mainPanel.getMenuPanel().getNEW_MAZE_BUTTON());
        nmw.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                mainPanel.getMenuPanel().getNEW_MAZE_BUTTON().setEnabled(true);
                mainPanel.getMenuPanel().getSOLVE_BUTTON().setEnabled(true);
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
                        tmp = new MazePanel(x, y);
                        tmp.createMaze(x, y, new MazeActionListener(mainPanel));
                        return null;
                    }
                    @Override
                    protected void done() {
                        mainPanel.remove(mainPanel.getMazePanel());
                        mainPanel.setMazePanel(tmp);
                        mainPanel.setFrameLayout();
                        mainPanel.getMazePanel().repaint();
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
        System.out.println("\nGoal: " + mainPanel.getMazePanel().getGoal().getCY() + ", " +  mainPanel.getMazePanel().getGoal().getCX());
        System.out.println("Start: " + mainPanel.getMazePanel().getStart().getCY() + ", " +  mainPanel.getMazePanel().getStart().getCX());
        System.out.println("User: " + mainPanel.getMazePanel().getMovable());
        if (mainPanel.getMazePanel().getStart() == null || mainPanel.getMazePanel().getGoal() == null) {
            JLabel label = new JLabel("check your start and goal fields");
            label.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
            JOptionPane.showMessageDialog(mainPanel.getMenuPanel().getSOLVE_BUTTON(), label, "Something went wrong", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            BfsSolver solver;
            @Override
            protected Void doInBackground() throws Exception {
                solver = new BfsSolver();
                Cell start = mainPanel.getMazePanel().getStart();
                Cell goal = mainPanel.getMazePanel().getGoal();
                try {
                    solver.solve(mainPanel.getMazePanel().getFields(), start, goal, mainPanel.getMazePanel().getMovable());
                    mainPanel.getMazePanel().setCallerToNull();
                } catch (PathNotFoundException e) {
                    e.printStackTrace();
                    JLabel label = new JLabel("goal field is unreachable");
                    label.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
                    JOptionPane.showMessageDialog(null, label, "Something went wrong", JOptionPane.WARNING_MESSAGE);
                }
                return null;
            }

            @Override
            protected void done() {
                    mainPanel.getMazePanel().insertPathToMaze(solver.getPaths());
            }
        };
        worker.execute();
    }
}
