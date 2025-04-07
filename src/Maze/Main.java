package Maze;

import Maze.Exceptions.PathNotFoundException;
import Maze.User.*;


public class Main {

    public static void main(String[] args) {

        Maze m = new Maze(20, 40);

        m.setDestination(19, 0);
        m.setStart(0, 39);

        m.setHorizontalWall(7, 6, 15);
        m.setHorizontalWall(9, 0, 19);
        m.setVerticalWall(9, 26, 11);

        m.setVerticalWater(0, 28, 8);
        m.setHorizontalWater(7, 22, 5);
        m.setVerticalWater(7, 21, 13);
        m.setVerticalWater(15, 34, 5);
        m.setHorizontalWater(14, 34, 6);

        m.setBridge(14, 35, 1);
        m.setBridge(7, 27, 1);
        m.setVerticalNoFlyZone(14, 13, 6);

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

        m.setDestination(16, 36);
        m.setStart(5, 5);

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
