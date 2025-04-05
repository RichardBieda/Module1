package Maze;

import java.util.ArrayList;
import java.util.List;

public final class Maze {

    private final int Y;
    private final int X;
    private Field initialField;
    private Field start;
    private Field destination;

    public Maze(int verticalSize, int horizontalSize) {
        checkMazeSize(verticalSize, horizontalSize);
        Y = verticalSize;
        X = horizontalSize;
        createMaze();
    }

    private void checkMazeSize(int sizeY, int sizeX) {
        if (sizeY < 1 || sizeX < 1) {
            throw new InvalidSizeException("Your maze size is invalid");
        }
    }

    private void checkCoordinates(int sizeY, int sizeX) {
        if (sizeY < 0 || sizeX < 0 || sizeY > Y || sizeX > X) {
            throw new InvalidSizeException("Your coordinates are invalid");
        }
    }

    void setStart(int y, int x) {
        checkCoordinates(y, x);
        start = new Start();
        Field tmp = getDesiredField(y, x);
        if (tmp == initialField) {
            initialField = start;
        }
        tmp.replaceFieldBy(start);
    }

    void setDestination(int y, int x) {
        checkCoordinates(y, x);
        destination = new Destination();
        Field tmp = getDesiredField(y, x);
        if (tmp == initialField) {
            initialField = destination;
        }
        tmp.replaceFieldBy(destination);
    }

    private Field getDesiredField(int y, int x) {
        Field result = initialField;
        for (int i = 0; i < y; i++) {
            result = result.getBelow();
        }
        for (int i = 0; i < x; i++) {
            result = result.getRight();
        }
        return result;
    }

    void showMaze() {
        StringBuilder sb = new StringBuilder();
        Field row = initialField;
        Field column = row;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                sb.append(column.getSign());
                column = column.getRight();
            }
            sb.append(" " + i + "\n");
            row = row.getBelow();
            column = row;
        }
        for (int i = 0; i < X; i++) {
            if (i < 10) {
                sb.append(" " + i + " ");
            } else {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    private void createMaze() {
        initialField = new Field();
        Field right = initialField;
        //sets the first row with fields without field.above
        for (int i = 0; i < X-1; i++) {
            right.setRight(new Field());
            right.getRight().setLeft(right);
            right = right.getRight();
        }
        Field firstInRow = initialField;
        Field row = initialField;
        Field column = initialField;
        for (int i = 0; i < Y-1; i++) {
            //sets the first field int the next row
            firstInRow.setBelow(new Field());
            firstInRow.getBelow().setAbove(firstInRow);
            firstInRow = firstInRow.getBelow();
            column = firstInRow;
            for (int j = 0; j < X-1; j++) {
                //sets the column of the next row including field.above
                column.setRight(new Field());
                column.getRight().setLeft(column);
                column = column.getRight();
                row = row.getRight();
                column.setAbove(row);
                row.setBelow(column);
            }
            row = firstInRow;
            column = firstInRow;
        }
    }

    void setHorizontalBarrier(int y, int x, int length) {
        checkCoordinates(y, x);
        Field tmp = getDesiredField(y, x);
        while (length-- > 0 && tmp != null) {
            tmp.replaceFieldBy(new Barrier());
            tmp = tmp.getRight();
        }
    }

    void setVerticalBarrier(int y, int x, int length) {
        checkCoordinates(y, x);
        Field tmp = getDesiredField(y, x);
        while (length-- > 0 && tmp != null) {
            tmp.replaceFieldBy(new Barrier());
            tmp = tmp.getBelow();
        }
    }

    void findPath() {
        List<Field> childList = new ArrayList<>();
        childList.add(start);
        doBfs(childList);
        insertPathToMaze();
    }

    private void doBfs(List<Field> childList) {
        List<Field> tmpList = new ArrayList<>();
        for (Field x : childList) {
            if (checkDestination(x)) {
                childList.clear();
                return;
            }
            Field below = x.getBelow();
            if (below != null && !(below instanceof Barrier) && !below.getIsChecked()) {
                below.setIsChecked(true);
                below.setCaller(x);
                tmpList.add(below);
            }
            Field left = x.getLeft();
            if (left != null && !(left instanceof Barrier) && !left.getIsChecked()) {
                left.setIsChecked(true);
                left.setCaller(x);
                tmpList.add(left);
            }
            Field right = x.getRight();
            if (right != null && !(right instanceof Barrier) && !right.getIsChecked()) {
                right.setIsChecked(true);
                right.setCaller(x);
                tmpList.add(right);
            }
            Field above = x.getAbove();
            if (above != null && !(above instanceof Barrier) && !above.getIsChecked()) {
                above.setIsChecked(true);
                above.setCaller(x);
                tmpList.add(above);
            }
        }
        childList = tmpList;
        if (!childList.isEmpty()) {
            doBfs(childList);
        }
    }

    private boolean checkDestination(Field field) {
        if (field.getAbove() == destination || field.getRight() == destination || field.getBelow() == destination || field.getLeft() == destination) {
            destination.setCaller(field);
            return true;
        }
        return false;
    }

    private void insertPathToMaze() {
        Field tmp = destination.getCaller();
        if (tmp == null) {
            System.out.println("destination not reached!");
            return;
        }
        while (tmp != start) {
            tmp.replaceFieldBy(new Path());
            tmp = tmp.getCaller();
        }
    }
}
