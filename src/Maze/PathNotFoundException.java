package Maze;

public class PathNotFoundException extends Exception {

    public static final String NO_PATH_FOUND = "Unable to reach goal";
    public PathNotFoundException(String message) {
        super(message);
    }

    public PathNotFoundException(Throwable cause) {
        super(cause);
    }
}
