package Maze;

class Destination extends Field {

    static final String SIGN = " D ";
    Destination(int y, int x) {
        super(y, x);
    }

    @Override
    String getSign() {
        return SIGN;
    }
}
