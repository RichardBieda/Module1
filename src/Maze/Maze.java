package Maze;

import java.util.ArrayList;
import java.util.List;

public final class Maze {

    private final int sizeY;
    private final int sizeX;
    final Field[][] fieldArray;
    private Field start;
    private Field destination;

    private List<Field> childList;

    public Maze(int sizeY, int sizeX) {
        checkSizes(sizeY, sizeX);
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        this.fieldArray = new Field[this.sizeY][this.sizeX];
        insertFields();
    }

    private void checkSizes(int sizeY, int sizeX) {
        if (sizeY < 1 && sizeX < 1) {
            throw new InvalidSizeException("Your maze size in invalid");
        }
    }

    void setStart(int y, int x) {
        checkSizes(y, x);
        start = new Start(y, x);
        fieldArray[y][x] = start;
    }

    void setDestination(int y, int x) {
        checkSizes(y, x);
        destination = new Destination(y, x);
        fieldArray[y][x] = destination;
    }

    void showLabyrinth() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                sb.append(fieldArray[i][j].getSign());
            }
            sb.append(" " + i + "\n");
        }
        for (int i = 0; i < sizeX; i++) {
            if (i < 10) {
                sb.append(" " + i + " ");
            } else {
                sb.append(i + " ");
            }
        }
        System.out.print(sb);
    }

    private void insertFields() {
        for (int i = 0; i < fieldArray.length; i++) {
            for (int j = 0; j < fieldArray[i].length; j++) {
                fieldArray[i][j] = new Field(i, j);
            }
        }
    }

    void findPath() {
        Field tmp = start;
        childList = new ArrayList<>();
        childList.add(tmp);
        bfs();
        setPaths();
    }

    private void bfs() {
        List<Field> tmpList = new ArrayList<>();
        for (Field x : childList) {
            if (x.getY() +1 < sizeY) {
                Field child = fieldArray[x.getY() +1][x.getX()];
                if (child == destination) {
                    destination.setCaller(x);
                    childList.clear();
                    return;
                }
                if (!(child instanceof Barrier) && !child.getIsChecked()) {
                    child.setIsChecked(true);
                    child.setCaller(x);
                    tmpList.add(child);
                }
            }
            if (x.getX() -1 > -1) {
                Field child = fieldArray[x.getY()][x.getX() -1];
                if (child == destination) {
                    destination.setCaller(x);
                    childList.clear();
                    return;
                }
                if (!(child instanceof Barrier) && !child.getIsChecked()) {
                    child.setIsChecked(true);
                    child.setCaller(x);
                    tmpList.add(child);
                }
            }
            if (x.getX() +1 < sizeX) {
                Field child = fieldArray[x.getY()][x.getX() +1];
                if (child == destination) {
                    destination.setCaller(x);
                    childList.clear();
                    return;
                }
                if (!(child instanceof Barrier) && !child.getIsChecked()) {
                    child.setIsChecked(true);
                    child.setCaller(x);
                    tmpList.add(child);
                }
            }
            if (x.getY() -1 > -1) {
                Field child = fieldArray[x.getY() -1][x.getX()];
                if (child == destination) {
                    destination.setCaller(x);
                    childList.clear();
                    return;
                }
                if (!(child instanceof Barrier) && !child.getIsChecked()) {
                    child.setIsChecked(true);
                    child.setCaller(x);
                    tmpList.add(child);
                }
            }
        }
        childList = tmpList;
        if (!childList.isEmpty()) {
            bfs();
        }
    }

    private void setPaths() {
        List<Field> list = new ArrayList<>();
        Field tmp = destination.getCaller();
        while (tmp != start) {
            list.add(tmp);
            tmp = tmp.getCaller();
        }
        for (Field x : list) {
            Field path = new Path(x.getY(), x.getX());
            path.setCaller(x.getCaller());
            fieldArray[x.getY()][x.getX()] = path;
        }
    }
}
