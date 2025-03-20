package Labyrinth;

public class WrongPath extends Barrier {

    static final String SIGN = " . ";
    WrongPath(int x, int y) {
        super(x, y);
    }

    @Override
    String getSign() {
        return SIGN;
    }
}
