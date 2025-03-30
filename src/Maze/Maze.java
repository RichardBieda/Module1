package Maze;

import java.util.ArrayList;
import java.util.List;

public final class Maze {

    private final int sizeY;
    private final int sizeX;
    final Field[][] fieldArray;
    private Field start;

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
                fieldArray[i][j] = new Field(j, i);
            }
        }
    }

    void findPath() {
        Field tmp = start;
        List<Field> fieldList = new ArrayList<>();
        fieldList.add(tmp);
        bfs(fieldList);
    }

    private void bfs(List<Field> list) {
        List<Field> tmpList = new ArrayList<>();
        for (Field x : list) {
            if (x.below(sizeY) && !(x instanceof Barrier) && !x.getIsChecked()) {
                fieldArray[x.getY() -1][x.getX()].setIsChecked(true);
                fieldArray[x.getY() -1][x.getX()].setCaller(x);
            }
            if (x.left() && !(x instanceof Barrier) && !x.getIsChecked()) {
                fieldArray[x.getY()][x.getX() -1].setIsChecked(true);
                fieldArray[x.getY()][x.getX() -1].setCaller(x);
            }
            if (x.right(sizeX) && !(x instanceof Barrier) && !x.getIsChecked()) {
                fieldArray[x.getY()][x.getX() +1].setIsChecked(true);
                fieldArray[x.getY()][x.getX() +1].setCaller(x);
            }
            if (x.above() && !(x instanceof Barrier) && !x.getIsChecked()) {
                fieldArray[x.getY() +1][x.getX()].setIsChecked(true);
                fieldArray[x.getY() +1][x.getX()].setCaller(x);
            }
        }
    }
}
