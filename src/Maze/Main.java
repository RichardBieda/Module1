package Maze;

import Maze.Exceptions.PathNotFoundException;
import Maze.User.*;


public class Main {

    public static void main(String[] args) {

        Maze m = new Maze(11, 11);

        m.setDestination(2, 0);
        m.setStart(0, 6);

        m.setVerticalWall(2, 5, 4);
        m.setHorizontalWall(1, 1, 5);

//        m.setVerticalWater(0, 3, 4);
//        m.setHorizontalWater(6, 5, 4);

//        m.setVerticalNoFlyZone(3, 6, 5);

        Movable user = new Pedestrian();


        try {
            new MazeSolver(user).solve(m);
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }

        m.showMaze();
//        Displayable dis = new ConsoleDisplay();
//        dis.display(m.getInitialField());

//        m.setDestination(2, 4);
//        m.showMaze();

        m.setStart(2, 0);
        m.setDestination(2, 4);
        try {
            new MazeSolver(user).solve(m);
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }
        m.showMaze();

        m.setStart(1, 6);
        m.setDestination(6, 6);
        m.setHorizontalWater(5, 5, 6);
        try {
            new MazeSolver(new Amphibious()).solve(m);
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }
        m.showMaze();

        m.setStart(1, 6);
        m.setDestination(4, 9);
        m.setHorizontalWater(5, 5, 6);
        try {
            new MazeSolver(new Airplane()).solve(m);
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }
        m.showMaze();
    }
}
