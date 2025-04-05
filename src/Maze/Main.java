package Maze;

public class Main {

    public static void main(String[] args) {

        Maze m = new Maze(11, 11);

        m.setDestination(0, 0);
        m.setStart(4, 8);

        m.setVerticalWall(2, 5, 7);
        m.setHorizontalWall(5, 2, 7);
        m.setVerticalWater(0, 3, 4);


        try {
            new MazeSolver().solve(m.getStart(), m.getDestination());
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }
        m.showMaze();
    }
}
