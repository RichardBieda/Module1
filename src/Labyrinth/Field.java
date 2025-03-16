package Labyrinth;

class Field {


    static final String SIGN = " . ";
    int x;
    int y;

    Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getSign() {
        return SIGN;
    }
}
