package Maze;
import Maze.SwingComponents.DisplayUi;

public class MazeApp {

    private DisplayUi displayUi;
    MazeApp() {
        displayUi = new DisplayUi();
    }
    public static void main(String[] args) {
        new MazeApp();
    }
}