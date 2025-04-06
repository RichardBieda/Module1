package Maze;

import Maze.Exceptions.InvalidSizeException;
import Maze.Fields.*;

import java.util.HashMap;
import java.util.Map;

class Maze {

    private final int Y;
    private final int X;
    private Field initialField;
    private Field start;
    private Field destination;
    private boolean isSolved = false;

    private Map<Field, Field> resetMap;

    Maze(int verticalSize, int horizontalSize) {
        checkMazeSize(verticalSize, horizontalSize);
        Y = verticalSize;
        X = horizontalSize;
        resetMap = new HashMap<>();
        createMaze();
    }

    private void checkMazeSize(int sizeY, int sizeX) {
        if (sizeY < 1 || sizeX < 1 || sizeY > 999 || sizeX > 999) {
            throw new InvalidSizeException(InvalidSizeException.INVALID_MAZE_SIZE);
        }
    }

    private void checkCoordinates(int sizeY, int sizeX) {
        if (sizeY < 0 || sizeX < 0 || sizeY > Y || sizeX > X) {
            throw new InvalidSizeException(InvalidSizeException.INVALID_COORDINATES);
        }
    }

    void setStart(int y, int x) {
        if (isSolved) {
            resetMaze();
        }
        if (start == null) {
            checkCoordinates(y, x);
            Field tmp = getDesiredField(y, x);
            start = new Start();
            tmp.replaceFieldBy(start);
            if (tmp == initialField) {initialField = start;}
            if (tmp == destination) {destination = null;}
        } else {
            start.replaceFieldBy(new EmptyField());
            start = null;
            setStart(y, x);
        }
    }

    void setDestination(int y, int x) {
        if (isSolved) {
            resetMaze();
        }
        if (destination == null) {
            checkCoordinates(y, x);
            Field tmp = getDesiredField(y, x);
            destination = new Destination();
            tmp.replaceFieldBy(destination);
            if (tmp == initialField) {initialField = destination;}
            if (tmp == start) {start = null;}
        } else {
            destination.replaceFieldBy(new EmptyField());
            destination = null;
            setDestination(y, x);
        }
    }

    void setInitialField(Field field) {
        initialField = field;
    }

    void setIsSolved(boolean solved) {
        isSolved = solved;
    }

    void setResetMap(Map<Field, Field> map) {
        resetMap = map;
    }

    Field getStart() {
        return start;
    }

    Field getDestination() {
        return destination;
    }

    Field getInitialField() {
        return initialField;
    }

    int getY() {
        return Y;
    }

    int getX() {
        return X;
    }

    boolean getIsSolved() {
        return isSolved;
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

    private void createMaze() {
        initialField = new EmptyField();
        Field right = initialField;
        //sets the first row with fields without field.above
        for (int i = 0; i < X-1; i++) {
            right.setRight(new EmptyField());
            right.getRight().setLeft(right);
            right = right.getRight();
        }
        Field firstInRow = initialField;
        Field row = initialField;
        Field column = initialField;
        for (int i = 0; i < Y-1; i++) {
            //sets the first field in the next row
            firstInRow.setBelow(new EmptyField());
            firstInRow.getBelow().setAbove(firstInRow);
            firstInRow = firstInRow.getBelow();
            column = firstInRow;
            for (int j = 0; j < X-1; j++) {
                //sets the column of the next row including field.above
                column.setRight(new EmptyField());
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

    private void resetMaze() {
        for(Map.Entry<Field, Field> fields : resetMap.entrySet()) {
            if (fields.getKey() == initialField) {
                initialField = fields.getValue();
            }
            fields.getKey().replaceFieldBy(fields.getValue());
        }
        Field tmp = initialField;
        Field row = tmp;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                tmp.setIsChecked(false);
                tmp.setCaller(null);
                tmp = tmp.getRight();
            }
            tmp = row;
            row = row.getBelow();
        }
        isSolved = false;
    }

    void setHorizontalWall(int y, int x, int length) {
        checkCoordinates(y, x);
        Field tmp = getDesiredField(y, x);
        while (length-- > 0 && tmp != null) {
            tmp.replaceFieldBy(new Wall());
            tmp = tmp.getRight();
        }
    }

    void setVerticalWall(int y, int x, int length) {
        checkCoordinates(y, x);
        Field tmp = getDesiredField(y, x);
        while (length-- > 0 && tmp != null) {
            tmp.replaceFieldBy(new Wall());
            tmp = tmp.getBelow();
        }
    }

    void setHorizontalWater(int y, int x, int length) {
        checkCoordinates(y, x);
        Field tmp = getDesiredField(y, x);
        while (length-- > 0 && tmp != null) {
            tmp.replaceFieldBy(new Water());
            tmp = tmp.getRight();
        }
    }

    void setVerticalWater(int y, int x, int length) {
        checkCoordinates(y, x);
        Field tmp = getDesiredField(y, x);
        while (length-- > 0 && tmp != null) {
            tmp.replaceFieldBy(new Water());
            tmp = tmp.getBelow();
        }
    }

    void setHorizontalNoFlyZone(int y, int x, int length) {
        checkCoordinates(y, x);
        Field tmp = getDesiredField(y, x);
        while (length-- > 0 && tmp != null) {
            tmp.replaceFieldBy(new NoFlyZone());
            tmp = tmp.getRight();
        }
    }

    void setVerticalNoFlyZone(int y, int x, int length) {
        checkCoordinates(y, x);
        Field tmp = getDesiredField(y, x);
        while (length-- > 0 && tmp != null) {
            tmp.replaceFieldBy(new NoFlyZone());
            tmp = tmp.getBelow();
        }
    }
}
