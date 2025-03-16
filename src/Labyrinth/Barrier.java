package Labyrinth;

class Barrier extends Field {

    static final String SIGN = " X ";
    Barrier(int x, int y) {
        super(x, y);
    }

    @Override
    String getSign() {
        return SIGN;
    }
}
