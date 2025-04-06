package Maze.Fields;

public abstract class Field {

    private Field caller;
    private boolean isChecked;
    private Field below, left, right, above;

    public Field() {
    }

    public void setIsChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public Field getCaller() {
        return caller;
    }

    public void setCaller(Field field) {
        caller = field;
    }

    public void setLeft(Field left) {
        this.left = left;
    }

    public void setRight(Field right) {
        this.right = right;
    }

    public void setAbove(Field above) {
        this.above = above;
    }

    public void setBelow(Field below) {
        this.below = below;
    }

    public void replaceFieldBy(Field newField) {
        newField.setCaller(getCaller());
        newField.setIsChecked(getIsChecked());

        if (getAbove() != null) {getAbove().setBelow(newField);}
        if (getRight() != null) {getRight().setLeft(newField);}
        if (getBelow() != null) {getBelow().setAbove(newField);}
        if (getLeft() != null) {getLeft().setRight(newField);}

        newField.setAbove(getAbove());
        newField.setRight(getRight());
        newField.setBelow(getBelow());
        newField.setLeft(getLeft());
    }

    public Field getRight() {
        return right;
    }

    public Field getBelow() {
        return below;
    }

    public Field getLeft() {
        return left;
    }

    public Field getAbove() {
        return above;
    }
}
