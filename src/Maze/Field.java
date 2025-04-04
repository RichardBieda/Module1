package Maze;

class Field {

    private Field caller;
    private boolean isChecked;
    private Field below, left, right, above;
    static int count = 0;

    Field() {
        ++count;
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
        return caller;
    }

    void setCaller(Field field) {
        caller = field;
    }

    void setLeft(Field left) {
        this.left = left;
    }

    void setRight(Field right) {
        this.right = right;
    }

    void setAbove(Field above) {
        this.above = above;
    }

    void setBelow(Field below) {
        this.below = below;
    }

    void setNeighbors(Field above, Field right, Field below, Field left) {
        this.above = above;
        this.right = right;
        this.below = below;
        this.left = left;
    }

    void replaceFieldBy(Field newField) {
        newField.setCaller(getCaller());
        newField.setIsChecked(getIsChecked());

        if (getAbove() != null) {getAbove().setBelow(newField);}
        if (getRight() != null) {getRight().setLeft(newField);}
        if (getBelow() != null) {getBelow().setAbove(newField);}
        if (getLeft() != null) {getLeft().setRight(newField);}

        newField.setNeighbors(getAbove(), getRight(), getBelow(), getLeft());
    }

    Field getRight() {
        return right;
    }

    Field getBelow() {
        return below;
    }

    Field getLeft() {
        return left;
    }

    Field getAbove() {
        return above;
    }
}
