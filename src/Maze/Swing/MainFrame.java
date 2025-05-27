package Maze.Swing;

import Maze.InvalidSizeException;
import Maze.Maze;
import Maze.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private final static String TITLE = "Maze";
    final static Color DEFAULT_BACKGROUND = new Color(235, 235, 255);
    private final MainPanel mainPanel;

    public MainFrame() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(DEFAULT_BACKGROUND);
        setBackground(DEFAULT_BACKGROUND);

        mainPanel = new MainPanel();
        addHeadPanelAction();

        add(mainPanel);
        pack();
        setVisible(true);
    }

    private void addHeadPanelAction() {
        mainPanel.getHeadPanel().getNEW_MAZE_BUTTON().addActionListener(e -> newMazeButtonPressed());
        mainPanel.getHeadPanel().getSOLVE_BUTTON().addActionListener(e -> solveButtonPressed());
        mainPanel.getHeadPanel().getPEDESTRIAN().addActionListener(e -> mainPanel.getMazePanel().setMovable(User.getMovable(User.PEDESTRIAN)));
        mainPanel.getHeadPanel().getAIRPLANE().addActionListener(e -> mainPanel.getMazePanel().setMovable(User.getMovable(User.AIRPLANE)));
        mainPanel.getHeadPanel().getAMPHIBIOUS().addActionListener(e -> mainPanel.getMazePanel().setMovable(User.getMovable(User.AMPHIBIOUS)));
        mainPanel.getHeadPanel().getBOAT().addActionListener(e -> mainPanel.getMazePanel().setMovable(User.getMovable(User.BOAT)));
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

