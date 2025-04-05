package Maze;

class PathNotFoundException extends Exception {

    static final String NO_PATH_FOUND = "Unable to reach destination";
    PathNotFoundException(String message) {
        super(message);
    }

    PathNotFoundException(Throwable cause) {
        super(cause);
    }
}
