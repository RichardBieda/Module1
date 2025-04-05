package Maze;

enum MazeSignConsole {

    WALL(" X "),
    DESTINATION(" D "),
    PATH(" + "),
    START(" S "),
    WATER(" \u2248 ");

    private String SIGN;

    MazeSignConsole(String sign) {
        this.SIGN = sign;
    }

    static String getSign(Field field) {
        if (field instanceof Start) {
            return START.SIGN;
        } else if (field instanceof Wall) {
            return WALL.SIGN;
        } else if (field instanceof Water) {
            return WATER.SIGN;
        }else if (field instanceof Path) {
            return PATH.SIGN;
        } else if (field instanceof Destination) {
            return DESTINATION.SIGN;
        } else {
            return " ¸ ";
        }
    }
}
