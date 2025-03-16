package Labyrinth;

class Destination extends Field {

    static final String SIGN = " D ";
    Destination(int x, int y) {
        super(x, y);
    }

    @Override
    String getSign() {
        return SIGN;
    }
}
