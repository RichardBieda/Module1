package Maze;

import Maze.Exceptions.PathNotFoundException;
import Maze.User.*;


public class Main {

    public static void main(String[] args) {

        Maze m = new Maze(11, 11);

        m.setDestination(5, 1);
        m.setStart(4, 9);

        m.setVerticalWall(2, 5, 7);
        m.setHorizontalWall(5, 2, 7);

        m.setVerticalWater(0, 3, 4);

        m.setVerticalNoFlyZone(3, 6, 5);

        Movable user = new Pedestrian();


        try {
            new MazeSolver(user).solve(m.getStart(), m.getDestination());
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }

        Displayable dis = new ConsoleDisplay();
        dis.display(m.getInitialField());
    }
}
