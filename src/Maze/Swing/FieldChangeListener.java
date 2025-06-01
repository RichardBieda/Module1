package Maze.Swing;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Maze.Look;

 class FieldChangeListener implements ChangeListener {

    private MenuPanel menuPanel;


    FieldChangeListener(MainPanel mainPanel) {
        this.menuPanel = mainPanel.getMenuPanel();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == menuPanel.getEMPTY_FIELD()) {
            sliderHelper();
            menuPanel.setLooks(Look.EMPTY_FIELD);
        } else if (e.getSource() == menuPanel.getWATER()) {
            sliderHelper();
            menuPanel.setLooks(Look.WATER);
        } else if (e.getSource() == menuPanel.getWALL()) {
            sliderHelper();
            menuPanel.setLooks(Look.WALL);
        } else if (e.getSource() == menuPanel.getNO_FLY_ZONE()) {
            sliderHelper();
            menuPanel.setLooks(Look.NO_FLY_ZONE);
        } else if (e.getSource() == menuPanel.getBRIDGE()) {
            sliderHelper();
            menuPanel.setLooks(Look.BRIDGE);
        } else if (e.getSource() == menuPanel.getSTART()) {
            menuPanel.setLooks(Look.START);
            uniqueFields(menuPanel.getSTART());
        } else if (e.getSource() == menuPanel.getGOAL()) {
            menuPanel.setLooks(Look.GOAL);
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