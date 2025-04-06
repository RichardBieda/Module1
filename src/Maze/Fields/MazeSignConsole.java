package Maze.Fields;

enum MazeSignConsole {

    WALL(" X "),
    DESTINATION(" D "),
    PATH(" + "),
    START(" S "),
    WATER(" \u2248 "),
    NoFlyZone(" § ");

    private final String SIGN;

    MazeSignConsole(String sign) {
        this.SIGN = sign;
    }

    static String getSign(Field field) {
        return switch (field) {
            case Start start -> START.SIGN;
            case Wall wall -> WALL.SIGN;
            case Water water -> WATER.SIGN;
            case NoFlyZone noFlyZone -> NoFlyZone.SIGN;
            case Path path -> PATH.SIGN;
            case Destination destination -> DESTINATION.SIGN;
            case null, default -> " ¸ ";
        };
    }
}
