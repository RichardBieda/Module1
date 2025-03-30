package Maze;

class Start extends Barrier {

    static final String SIGN = " S ";
    Start(int y, int x) {
        super(y, x);
    }


    @Override
    String getSign() {
        return SIGN;
    }
}
