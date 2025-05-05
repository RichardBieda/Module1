package Maze.User;

public enum User {

    AIRPLANE("Airplane"),
    AMPHIBIOUS("Amphibious"),
    BOAT("Boat"),
    PEDESTRIAN("Pedestrian");

    private String userTyp;
    User(String userTyp) {
        this.userTyp = userTyp;
    }
}
