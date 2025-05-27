package Maze.User;
import Maze.MazeLabels.*;

public class Airplane implements Movable {
    @Override
    public boolean canMove(Field field) {
        return !(field instanceof NoFlyZone);
    }
}
