package Maze;

public class Main {

    public static void main(String[] args) {

        Maze m = new Maze(11, 11);
        m.setStart(6, 6);
        m.setDestination(6, 8);
        m.setVerticalBarrier(2, 5, 7);
        m.setHorizontalBarrier(5, 2, 7);
        m.findPath();

        m.showMaze();
    }
}
