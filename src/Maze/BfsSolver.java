package Maze;

import Maze.MazeLabels.Field;
import Maze.MazeLabels.Path;
import Maze.Swing.FieldButton;
import Maze.User.Movable;
import java.util.ArrayList;
import java.util.List;

public class BfsSolver {

    private FieldButton[][] fields;
    private int width;
    private int height;
    private Movable user;
    private FieldButton goal;
    private FieldButton start;

    public BfsSolver() {
    }

    public void solve(FieldButton[][] fields, FieldButton start, FieldButton goal, Movable user) {
        System.out.println("start solve");
        this.fields = fields;
        this.width = fields[0].length;
        this.height = fields.length;
        this.user = user;
        this.goal = goal;
        this.start = start;
        List<FieldButton> neighbors = new ArrayList<>();
        neighbors.add(this.start);
        System.out.println("start doBFS");
        doBfs(neighbors);
        System.out.println("end doBFS");
    }

    private void doBfs(List<FieldButton> neighbors) {
        List<FieldButton> tmpList = new ArrayList<>();
        for (FieldButton x : neighbors) {
            if (checkDestination(x)) {
                neighbors.clear();
                return;
            }
            if (isBelow(x)) {
                FieldButton belowField = below(x);
                System.out.println(belowField.getFY() + " " + belowField.getFX());
                if (user.canMove(belowField.getField()) && !belowField.isChecked()) {
                    belowField.setChecked(true);
                    belowField.setCaller(x);
                    tmpList.add(belowField);
                }
            }
            if (isLeft(x)) {
                FieldButton leftField = left(x);
                System.out.println(leftField.getFY() + " " + leftField.getFX());
                if (user.canMove(leftField.getField()) && !leftField.isChecked()) {
                    leftField.setChecked(true);
                    leftField.setCaller(x);
                    tmpList.add(leftField);
                }
            }
            if (isRight(x)) {
                FieldButton rightField = right(x);
                System.out.println(rightField.getFY() + " " + rightField.getFX());
                if (user.canMove(rightField.getField()) && !rightField.isChecked()) {
                    rightField.setChecked(true);
                    rightField.setCaller(x);
                    tmpList.add(rightField);
                }
            }
            if (isAbove(x)) {
                FieldButton aboveField = above(x);
                System.out.println(aboveField.getFY() + " " + aboveField.getFX());
                if (user.canMove(aboveField.getField()) && !aboveField.isChecked()) {
                    aboveField.setChecked(true);
                    aboveField.setCaller(x);
                    tmpList.add(aboveField);
                }
            }
        }
        neighbors = tmpList;
        if (!neighbors.isEmpty()) {
            doBfs(neighbors);
        }
    }

   public void insertPathToMaze() throws PathNotFoundException {
        FieldButton tmp = goal.getCaller();
        if (tmp == null) {
            System.out.println("path exception");
            throw new PathNotFoundException(PathNotFoundException.NO_PATH_FOUND);
        }
        while (tmp != start) {
            System.out.println("while: " + tmp.getCaller());
            Field path = new Path();
            tmp.setField(path);
            tmp = tmp.getCaller();
        }
       for (int i = 0; i < fields.length; i++) {
           for (int j = 0; j < fields[i].length; j++) {
               System.out.print(" " + fields[i][j]);
           }
           System.out.println();
       }
    }

    private boolean checkDestination(FieldButton field) {
        System.out.println("checkDestination");
        if (isAbove(field)) {
            if (above(field) == goal) {
                goal.setCaller(field);
                return true;
            }
        }
        if (isRight(field)) {
            if (right(field) == goal) {
                goal.setCaller(field);
                return true;
            }
        }
        if (isBelow(field)) {
            if (below(field) == goal) {
                goal.setCaller(field);
                return true;
            }
        }
        if (isLeft(field)) {
            if (left(field) == goal) {
                goal.setCaller(field);
                return true;
            }
        }

        return false;
    }

    private boolean isAbove(FieldButton field) {
        return field.getFY() -1 >= 0;
    }

    private boolean isRight(FieldButton field) {
        return field.getFX() +1 < width;
    }

    private boolean isBelow(FieldButton field) {
        return field.getFY() +1 < height;
    }

    private boolean isLeft(FieldButton field) {
        return field.getFX() >= 0;
    }
    private FieldButton above(FieldButton field) {
        return fields[field.getFY() -1][field.getFX()];
    }

    private FieldButton right(FieldButton field) {
        return fields[field.getFY()][field.getFX() +1];
    }

    private FieldButton below(FieldButton field) {
        return fields[field.getFY() +1][field.getFX()];
    }

    private FieldButton left(FieldButton field) {
        return fields[field.getFY()][field.getFX() -1];
    }
}

