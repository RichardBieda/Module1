package Maze;

enum MazeSignConsole {

    FIELD(" . "),
    BARRIER(" X "),
    DESTINATION(" D "),
    PATH(" + "),
    START(" S ");

    private String SIGN;

    MazeSignConsole(String sign) {
        this.SIGN = sign;
    }

    static String getSign(Field field) {
        if (field instanceof Start) {
            return START.SIGN;
        } else if (field instanceof Barrier) {
            return BARRIER.SIGN;
        } else if (field instanceof Path) {
            return PATH.SIGN;
        } else if (field instanceof Destination) {
            return DESTINATION.SIGN;
        } else {
            return " . ";
        }
    }
}
