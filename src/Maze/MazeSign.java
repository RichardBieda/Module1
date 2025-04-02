package Maze;

enum MazeSign {

    FIELD(" . "),
    BARRIER(" X "),
    DESTINATION(" D "),
    PATH(" + "),
    START(" S ");

    private String SIGN;

    MazeSign(String sign) {
        this.SIGN = sign;
    }

    static String getSign(Field field) {
        String result = "";
        if (field instanceof Start) {
            result = START.SIGN;
        } else if (field instanceof Barrier) {
            result = BARRIER.SIGN;
        } else if (field instanceof Path) {
            result = PATH.SIGN;
        } else if (field instanceof Destination) {
            result = DESTINATION.SIGN;
        } else if (field instanceof Field) {
            result = FIELD.SIGN;
        }
        return result;
    }
}
