package Labyrinth;

class Start extends Field {

    static final String SIGN = " S ";
    Start(int x, int y) {
        super(x, y);
    }


    @Override
    String getSign() {
        return SIGN;
    }
}
