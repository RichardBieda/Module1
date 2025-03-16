package Labyrinth;

class Path extends Field {

    static final String SIGN = " + ";
    Path(int x, int y) {
        super(x, y);
    }

    @Override
    String getSign() {
        return SIGN;
    }
}
