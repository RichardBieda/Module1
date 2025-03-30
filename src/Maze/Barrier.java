package Maze;

class Barrier extends Field {

    static final String SIGN = " X ";
    Barrier(int y, int x) {
        super(y, x);
    }

    @Override
    String getSign() {
        return SIGN;
    }
}
