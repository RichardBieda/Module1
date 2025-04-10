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

        m.setDestination(0, 0);
        m.setStart(10, 15);

        m.setVerticalField(1, 8, 6, Wall.class);
        m.setVerticalField(8, 8, 8, Wall.class);
//
        m.setVerticalField(0, 10, 7, Water.class);
        m.setHorizontalField(7, 7, 4, Water.class);
        m.setVerticalField(7, 6, 9, Water.class);
//
        m.setVerticalField(7, 9, 1, Bridge.class);
        m.setVerticalField(1, 10, 1, Bridge.class);
        m.setVerticalField(7, 4, 4, NoFlyZone.class);

        Movable user = new Amphibious();
        MazeSolver solver = new MazeSolver(user);
        try {
            solver.solve(m);
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }
        DisplayConsole dis = new DisplayConsole();
        System.out.println(dis.display(m));
        System.out.println("steps count: " + solver.getSteps());

        m.setDestination(10, 2);
        m.setStart(0, 15);

        Movable user1 = new Pedestrian();
        MazeSolver solver1 = new MazeSolver(user1);
        try {
            solver1.solve(m);
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }
        System.out.println(dis.display(m));
        System.out.println("steps count: " + solver1.getSteps());
    }
}
