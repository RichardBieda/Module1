package Maze.Swing;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Maze.Fields.*;
 class FieldChangeListener implements ChangeListener {

    private MenuPanel menuPanel;
    private MazePanel mazePanel;

    FieldChangeListener(MainPanel mainPanel) {
        this.menuPanel = mainPanel.getMenuPanel();
        this.mazePanel = mainPanel.getMazePanel();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == menuPanel.getEMPTY_FIELD()) {
            sliderHelper();
            menuPanel.setFClass(EmptyField.class);
        } else if (e.getSource() == menuPanel.getWATER()) {
            sliderHelper();
            menuPanel.setFClass(Water.class);
        } else if (e.getSource() == menuPanel.getWALL()) {
            sliderHelper();
            menuPanel.setFClass(Wall.class);
        } else if (e.getSource() == menuPanel.getNO_FLY_ZONE()) {
            sliderHelper();
            menuPanel.setFClass(NoFlyZone.class);
        } else if (e.getSource() == menuPanel.getBRIDGE()) {
            sliderHelper();
            menuPanel.setFClass(Bridge.class);
        } else if (e.getSource() == menuPanel.getSTART()) {
            menuPanel.setFClass(Start.class);
            uniqueFields(menuPanel.getSTART());
        } else if (e.getSource() == menuPanel.getGOAL()) {
            menuPanel.setFClass(Goal.class);
            uniqueFields(menuPanel.getGOAL());
        }
    }

    private void uniqueFields(MazeToggleButton button) {
        menuPanel.getSlider().setValue(1);
        menuPanel.getSlider().setEnabled(false);
    }

    private void sliderHelper() {
        menuPanel.getSlider().setEnabled(true);
    }
}