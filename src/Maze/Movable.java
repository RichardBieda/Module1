package Maze;

import Maze.FieldLabel.Field;

public interface Movable {

    //Remember Start is a Barrier
    boolean canMove(Field field);
}
