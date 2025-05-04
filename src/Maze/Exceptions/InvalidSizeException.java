package Maze.Exceptions;

public class InvalidSizeException extends RuntimeException {

    public static final String INVALID_MAZE_SIZE = "Maze size is invalid, cannot be greater than 999";
    public static final String INVALID_COORDINATES = "Chosen maze coordinates are invalid";
    public InvalidSizeException(String message) {
        super(message);
    }
}
