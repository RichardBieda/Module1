package Maze.SwingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.BOTH;

class MazeUI extends JFrame implements ActionListener {

    private final static int DEFAULT_WINDOW_WIDTH = 1600;
    private final static int DEFAULT_WINDOW_HEIGHT = 1125;
    private final static int DEFAULT_MAZE_SIZE = 10;
    private final static String TITLE = "Maze";
    final static Color DEFAULT_BACKGROUND = new Color(235, 235, 255);
    private MazePanel mazePanel;
    private final HeadPanel headPanel;
    private final MenuPanel menuPanel;

    MazeUI() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(DEFAULT_BACKGROUND);
        setSize(DEFAULT_WINDOW_WIDTH,DEFAULT_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(true);

        mazePanel = new MazePanel(DEFAULT_MAZE_SIZE, DEFAULT_MAZE_SIZE);
        mazePanel.addAllFields();

        headPanel = new HeadPanel();
        headPanel.getNEW_MAZE_BUTTON().addActionListener(this);
        headPanel.getSOLVE_BUTTON().addActionListener(this);

        menuPanel = new MenuPanel();

        setFrameLayout();
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == headPanel.getNEW_MAZE_BUTTON()) {
            NewMazeFrame createFrame = new NewMazeFrame(headPanel.getNEW_MAZE_BUTTON());
            createFrame.getCreateButton().addActionListener(e1 -> {
                setNewMazePanel(Integer.parseInt(createFrame.getIntHeight().getText()), Integer.parseInt(createFrame.getIntWidth().getText()));
                createFrame.dispose();
            });
        } else if (e.getSource() == headPanel.getSOLVE_BUTTON()) {
            solveMaze();
        }
    }

    private void setNewMazePanel(int y, int x) {
        remove(mazePanel);
        mazePanel = new MazePanel(y, x);
        Thread t = new Thread(mazePanel);
        setFrameLayout();
        t.start();
    }
//    private void setNewMazePanel() {
//        NewMazeFrame createFrame = new NewMazeFrame(headPanel.getNEW_MAZE_BUTTON());
//        createFrame.getCreateButton().addActionListener(e1 -> {
//            setNewMazePanel(Integer.parseInt(createFrame.getIntHeight().getText()), Integer.parseInt(createFrame.getIntWidth().getText()));
//            createFrame.dispose();
//        });
//    }

    private void solveMaze() {
        System.out.println("ttttttttttt");
    }

    private void setFrameLayout() {
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(grid);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 0.15;
        constraints.fill = BOTH;
        add(headPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.6;
        constraints.weighty = 0.85;
        constraints.fill = BOTH;
        add(mazePanel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0.4;
        constraints.weighty = 0.9;
        constraints.fill = BOTH;
        add(menuPanel, constraints);
    }
}
