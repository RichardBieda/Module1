package Maze;

class Field {

    static final String SIGN = " . ";
    private Field caller;
    private boolean isChecked;
    private final int y;
    private final int x;

    Field(int y, int x) {
        this.y = y;
        this.x = x;
    }

    int getY() {
        return y;
    }

    int getX() {
        return x;
    }

    String getSign() {
        return SIGN;
    }

    void setIsChecked(boolean checked) {
        isChecked = checked;
    }

    boolean getIsChecked() {
        return isChecked;
    }

    Field getCaller() {
        return this.caller;
    }

    void setCaller(Field field) {
        this.caller = field;
    }

    boolean below(int maxY) {
        return y + 1 < maxY;
    }

    boolean right(int maxX) {
        return x + 1 < maxX;
    }

    boolean left() {
        return x - 1 > -1;
    }

    boolean above() {
        return y - 1 > -1;
    }

}
