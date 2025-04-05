package Maze;

public class Main {

    public static void main(String[] args) {

        Maze m = new Maze(11, 11);

        m.setDestination(0, 0);
        m.setStart(6, 8);

        m.setVerticalBarrier(2, 5, 7);
        m.setHorizontalBarrier(5, 2, 7);



        try {
            new MazeSolver().solve(m.getStart(), m.getDestination());
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }
        m.showMaze();
    }
}
