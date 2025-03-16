package Labyrinth;

class Start extends Barrier {

    static final String SIGN = " S ";
    Start(int x, int y) {
        super(x, y);
    }


    @Override
    String getSign() {
        return SIGN;
    }
}
