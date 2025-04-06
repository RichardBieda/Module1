package Maze.Fields;

enum MazeSignConsole {

    WALL(" X ", 0),
    DESTINATION(" D ", 1),
    PATH(" + ", 2),
    START(" S ", 3),
    WATER(" \u2248 ", 4),
    NoFlyZone(" § ", 5),
    EMPTY_FIELD(" . ", 6);

    private final String SIGN;

    MazeSignConsole(String sign, int number) {
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
