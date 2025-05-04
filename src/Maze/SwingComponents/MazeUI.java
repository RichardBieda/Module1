package Maze.SwingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.BOTH;

public class MazeUI extends JFrame implements ActionListener {

    private final static String TITLE = "Maze";
    private MazePanel mazePanel;
    private final HeadPanel headPanel;
    private final MenuPanel menuPanel;

    public MazeUI() {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(235, 235, 255));
        setSize(1200,900);
        setResizable(true);

        mazePanel = new MazePanel(10,10);
        Thread thread = new Thread(mazePanel);
        thread.start();

        headPanel = new HeadPanel();
        headPanel.getNEW_MAZE_BUTTON().addActionListener(this);
        headPanel.getSOLVE_BUTTON().addActionListener(this);

        menuPanel = new MenuPanel();

        setFrameLayout();

        setVisible(true);
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == headPanel.getNEW_MAZE_BUTTON()) {
            NewMazeFrame createFrame = new NewMazeFrame(headPanel.getNEW_MAZE_BUTTON());
            createFrame.createButton.addActionListener(e1 -> {
                getNewMaze(Integer.parseInt(createFrame.intHeight.getText()), Integer.parseInt(createFrame.intWidth.getText()));
                createFrame.dispose();
            });
        } else if (e.getSource() == headPanel.getSOLVE_BUTTON()) {
            solveMaze();
        }
    }

    private void getNewMaze(int y, int x) {
        remove(mazePanel);
        mazePanel = new MazePanel(y, x);
        setFrameLayout();
        Thread thread = new Thread(mazePanel);
        thread.start();
    }

    private void solveMaze() {
        System.out.println("ttttttttttt");
    }
}
