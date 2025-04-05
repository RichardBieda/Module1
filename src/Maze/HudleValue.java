package Maze;

enum HudleValue {

    FIELD(0),
    BARRIER(1),
    PATH(0);

    private int VALUE;

    HudleValue(int value) {
        VALUE = value;
    }

    static int getValue(Field field) {
        if (field instanceof Barrier) {
            return BARRIER.VALUE;
        } else if (field instanceof Path) {
            return PATH.VALUE;
        } else {
            return 0;
        }
    }
}
