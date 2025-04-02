package Maze;

class Field {

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
        return MazeSign.getSign(this);
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
}
