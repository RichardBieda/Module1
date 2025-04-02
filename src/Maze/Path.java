package Maze;

class Path extends Field {

    static final String SIGN = " + ";

    Path(int y, int x) {
        super(y, x);
    }

    @Override
    String getSign() {
        return SIGN;
    }
}
