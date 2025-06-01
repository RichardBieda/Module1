package Maze.User;
import Maze.Fields.*;

public class Airplane implements Movable {
    @Override
    public boolean canMove(Field field) {
        return !(field instanceof NoFlyZone);
    }
}
