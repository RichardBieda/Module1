package Maze;

import Maze.Exceptions.PathNotFoundException;
import Maze.Fields.Bridge;
import Maze.Fields.NoFlyZone;
import Maze.Fields.Wall;
import Maze.Fields.Water;
import Maze.User.*;


public class Main {

    public static void main(String[] args) {

        Maze m = new Maze(16, 16);

        m.setVerticalFields(1, 8, 6, Wall.class);
        m.setVerticalFields(8, 8, 8, Wall.class);
//
        m.setVerticalFields(0, 10, 7, Water.class);
        m.setHorizontalFields(7, 7, 4, Water.class);
        m.setVerticalFields(7, 6, 9, Water.class);
//
        m.setVerticalFields(7, 9, 1, Bridge.class);
        m.setVerticalFields(1, 10, 1, Bridge.class);
        m.setVerticalFields(7, 4, 4, NoFlyZone.class);

        m.setDestination(10, 2);
        m.setStart(0, 15);

        DisplayConsole dis = new DisplayConsole();
        System.out.println(dis.display(m));

        Movable user = new Pedestrian();
        MazeSolver solver = new MazeSolver(user);

        try {
            solver.solve(m);
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }

        System.out.println(dis.display(m));
        System.out.println("steps count: " + solver.getSteps());
    }
}
