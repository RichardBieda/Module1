package Maze.User;

public enum User {

    PEDESTRIAN(new Pedestrian()),
    AIRPLANE(new Airplane()),
    AMPHIBIOUS(new Amphibious()),
    BOAT(new Boat());

    private Movable movable;
    User(Movable movable) {
        this.movable = movable;
    }

    public static Movable getMovable(User user) {
        return user.movable;
    }
}
