package Maze;

import Maze.Exceptions.PathNotFoundException;
import Maze.Interfaces.Movable;
import Maze.User.Amphibious;
import Maze.User.Pedestrian;

public class Main {

    public static void main(String[] args) {

        Maze m = new Maze(11, 11);

        m.setDestination(0, 0);
        m.setStart(4, 8);

        m.setVerticalWall(2, 5, 7);
        m.setHorizontalWall(5, 2, 7);
        m.setVerticalWater(0, 3, 4);

        Movable user = new Pedestrian();


        try {
            new MazeSolver(user).solve(m.getStart(), m.getDestination());
        } catch (PathNotFoundException | NullPointerException e) {
            System.out.println(e);
        }
        m.showMaze();
    }
}
