package Maze;

import Maze.Exceptions.InvalidSizeException;
import Maze.FieldLabel.EmptyField;
import Maze.FieldLabel.Field;

public final class Maze {

    private Maze() {}

    public static Field[][] createNewMaze(int y, int x) {
        Field[][] result = new Field[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                Field tmp = new EmptyField();
                tmp.setFX(j);
                tmp.setFY(i);
                result[i][j] = tmp;
            }
        }
        return result;
    }

    public void checkMazeSize(int sizeY, int sizeX) {
        if (sizeY < 1 || sizeX < 1 || sizeY > 50 || sizeX > 50) {
            throw new InvalidSizeException(InvalidSizeException.INVALID_MAZE_SIZE);
        }
    }
}
