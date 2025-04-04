package Maze;

import java.util.*;

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
        initialField = new Field();
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
        replacer(y, x, start);
    }

    void setDestination(int y, int x) {
        checkCoordinates(y, x);
        destination = new Destination();
        replacer(y, x, destination);
    }

    private void replacer(int y, int x, Field field) {
        Field tmp = initialField;
        for (int i = 0; i < y; i++) {
            tmp = tmp.getBelow();
        }
        for (int i = 0; i < x; i++) {
            tmp = tmp.getRight();
        }
        tmp.replaceFieldBy(field);
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
        Field[][] arr = new Field[Y][X];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = new Field();
            }
        }
        arr[0][0] = initialField;

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (i == 0) {
                    if (j == 0) {
                        arr[i][j].setNeighbors(null, arr[i][j + 1], arr[i + 1][j], null);
                    } else if (j == X -1) {
                        arr[i][j].setNeighbors(null, null, arr[i + 1][j], arr[i][j - 1]);
                    } else {
                        arr[i][j].setNeighbors(null, arr[i][j + 1], arr[i + 1][j], arr[i][j - 1]);
                    }
                } else if (i == Y -1) {
                    if (j == 0) {
                        arr[i][j].setNeighbors(arr[i - 1][j], arr[i][j + 1], null, null);
                    } else if (j == X -1) {
                        arr[i][j].setNeighbors(arr[i - 1][j], null, null, arr[i][j - 1]);
                    } else {
                        arr[i][j].setNeighbors(arr[i - 1][j], arr[i][j + 1], null, arr[i][j - 1]);
                    }
                } else {
                    if (j == 0) {
                        arr[i][j].setNeighbors(arr[i - 1][j], arr[i][j + 1], arr[i + 1][j], null);
                    } else if (j == X -1) {
                        arr[i][j].setNeighbors(arr[i - 1][j], null, arr[i + 1][j], arr[i][j - 1]);
                    } else {
                        arr[i][j].setNeighbors(arr[i - 1][j], arr[i][j + 1], arr[i + 1][j], arr[i][j - 1]);
                    }
                }
            }
        }
    }

//    void findPath() {
//        List<int[]> childList = new ArrayList<>();
//        childList.add(start);
//        bfs(childList);
//        insertPathToMaze();
//    }

//    private void bfs(List<int[]> bfsList) {
//        List<int[]> tmpList = new ArrayList<>();
//        for (int[] tmp : bfsList) {
//            if (tmp[0] +1 < sizeY) { //down
//                Field child = fieldArray[tmp[0] +1][tmp[1]];
//                if (child == destination) {
//                    destination.setCaller(fieldArray[tmp[0]][tmp[1]]);
//                    bfsList.clear();
//                    return;
//                }
//                if (!(child instanceof Barrier) && !child.getIsChecked()) {
//                    child.setIsChecked(true);
//                    child.setCaller(fieldArray[tmp[0]][tmp[1]]);
//                    tmpList.add(new int[] {tmp[0] +1, tmp[1]});
//                }
//            }
//            if (tmp[1] +1 < sizeX) {//right
//                Field child = fieldArray[tmp[0]][tmp[1] +1];
//                if (child == destination) {
//                    destination.setCaller(fieldArray[tmp[0]][tmp[1]]);
//                    bfsList.clear();
//                    return;
//                }
//                if (!(child instanceof Barrier) && !child.getIsChecked()) {
//                    child.setIsChecked(true);
//                    child.setCaller(fieldArray[tmp[0]][tmp[1]]);
//                    tmpList.add(new int[] {tmp[0], tmp[1] +1});
//                }
//            }
//            if (tmp[1] -1 > -1) {//left
//                Field child = fieldArray[tmp[0]][tmp[1] -1];
//                if (child == destination) {
//                    destination.setCaller(fieldArray[tmp[0]][tmp[1]]);
//                    bfsList.clear();
//                    return;
//                }
//                if (!(child instanceof Barrier) && !child.getIsChecked()) {
//                    child.setIsChecked(true);
//                    child.setCaller(fieldArray[tmp[0]][tmp[1]]);
//                    tmpList.add(new int[] {tmp[0], tmp[1] -1});
//                }
//            }
//            if (tmp[0] -1 > -1) {//up
//                Field child = fieldArray[tmp[0] -1][tmp[1]];
//                if (child == destination) {
//                    destination.setCaller(fieldArray[tmp[0]][tmp[1]]);
//                    bfsList.clear();
//                    return;
//                }
//                if (!(child instanceof Barrier) && !child.getIsChecked()) {
//                    child.setIsChecked(true);
//                    child.setCaller(fieldArray[tmp[0]][tmp[1]]);
//                    tmpList.add(new int[] {tmp[0] -1, tmp[1]});
//                }
//            }
//        }
//        bfsList = tmpList;
//        if (!bfsList.isEmpty()) {
//            bfs(bfsList);
//        }
//    }

//    private void insertPathToMaze() {
//        Field tmp = destination.getCaller();
//        while (tmp != fieldArray[start[0]][start[1]]) {
//
//        }
//    }

//    private void setPaths() {
//        List<Field> list = new ArrayList<>();
//        Field tmp = destination.getCaller();
//        while (tmp != fieldArray[start[0]][start[1]]) {
//            list.add(tmp);
//            tmp = tmp.getCaller();
//        }
//        for (Field x : list) {
//            Field path = new Path();
//            path.setCaller(x.getCaller());
//            fieldArray[x.getY()][x.getX()] = path;
//        }
//    }
}
