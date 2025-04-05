package Maze;

class InvalidSizeException extends RuntimeException {

    static final String INVALID_MAZE_SIZE = "Maze size is invalid";
    static final String INVALID_COORDINATES = "Chosen maze coordinates are invalid";
    InvalidSizeException(String message) {
        super(message);
    }
}
