package Maze;
import Maze.MazeLabels.Field;
import Maze.MazeLabels.EmptyField;

public class Maze {

    private final static int MIN_MAZE_SIZE = 1;
    private final static int MAX_MAZE_SIZE = 50;
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

    public static void checkMazeSize(int sizeY, int sizeX) {
        if (sizeY < MIN_MAZE_SIZE || sizeX < MIN_MAZE_SIZE || sizeY > MAX_MAZE_SIZE || sizeX > MAX_MAZE_SIZE) {
            throw new InvalidSizeException(InvalidSizeException.INVALID_MAZE_SIZE);
        }
    }
}
