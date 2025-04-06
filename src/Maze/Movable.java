package Maze;

import Maze.Fields.Field;

public interface Movable {

    //Remember Start is a Barrier
    boolean canMove(Field field);
}
