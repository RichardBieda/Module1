package Maze;

import Maze.Swing.Cell;
import Maze.User.Movable;
import java.util.ArrayList;
import java.util.List;

public class BfsSolver {

    private final Cell[][] FIELDS;
    private final List<Cell> PATH = new ArrayList<>();
    private final Cell START;
    private final Cell GOAL;

    public BfsSolver(Cell[][] fields, Cell start, Cell goal) {
        this.FIELDS = fields;
        this.START = start;
        this.GOAL = goal;
    }

    public void solve(Movable user) throws PathNotFoundException {
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(START);
        doBfs(neighbors, user);
        determinePath();
    }

    private void doBfs(List<Cell> neighbors, Movable user) {
        List<Cell> tmpList = new ArrayList<>();
        for (Cell x : neighbors) {
            int fx = x.getCX();
            int fy = x.getCY();
            if (checkDestination(x)) {
                neighbors.clear();
                return;
            }
            //check below
            if (fy +1 < FIELDS.length) {
                if (user.canMove(FIELDS[fy+1][fx].getField()) && !FIELDS[fy+1][fx].isChecked()) {
                    FIELDS[fy+1][fx].setChecked(true);
                    FIELDS[fy+1][fx].setCaller(FIELDS[fy][fx]);
                    tmpList.add(FIELDS[fy+1][fx]);
                }
            }
            //check left
            if (fx -1 >= 0) {
                if (user.canMove(FIELDS[fy][fx-1].getField()) && !FIELDS[fy][fx-1].isChecked()) {
                    FIELDS[fy][fx-1].setChecked(true);
                    FIELDS[fy][fx-1].setCaller(FIELDS[fy][fx]);
                    tmpList.add(FIELDS[fy][fx-1]);
                }
            }
            //check right
            if (fx +1 < FIELDS[fy].length) {
                if (user.canMove(FIELDS[fy][fx+1].getField()) && !FIELDS[fy][fx+1].isChecked()) {
                    FIELDS[fy][fx+1].setChecked(true);
                    FIELDS[fy][fx+1].setCaller(FIELDS[fy][fx]);
                    tmpList.add(FIELDS[fy][fx+1]);
                }
            }
            //check above
            if (fy -1 >= 0) {
                if (user.canMove(FIELDS[fy-1][fx].getField()) && !FIELDS[fy-1][fx].isChecked()) {
                    FIELDS[fy-1][fx].setChecked(true);
                    FIELDS[fy-1][fx].setCaller(FIELDS[fy][fx]);
                    tmpList.add(FIELDS[fy-1][fx]);
                }
            }
        }
        neighbors = tmpList;
        if (!neighbors.isEmpty()) {
            doBfs(neighbors, user);
        }
    }


    private void determinePath() throws PathNotFoundException {
        if (GOAL.getCaller() == null) {
            throw new PathNotFoundException(PathNotFoundException.NO_PATH_FOUND);
        }
        int rounds = 0;
        Cell tmp = GOAL.getCaller();
        while (tmp != null && tmp != START) {
            PATH.add(tmp);
            tmp = tmp.getCaller();
            if (++rounds > FIELDS.length * FIELDS[0].length) break;
        }
    }

    private boolean checkDestination(Cell c) {
        int y = c.getCY();
        int x = c.getCX();
        //test above bound
        if (y -1 >= 0) {
            if (FIELDS[y-1][x] == GOAL) {
                GOAL.setCaller(c);
                return true;
            }
        }
        //test right bound
        if (x +1 < FIELDS[y].length) {
            if (FIELDS[y][x+1] == GOAL) {
                GOAL.setCaller(c);
                return true;
            }
        }
        //test below bound
        if (y +1 < FIELDS.length) {
            if (FIELDS[y+1][x] == GOAL) {
                GOAL.setCaller(c);
                return true;
            }
        }
        //test left bound
        if (x -1 >= 0) {
            if (FIELDS[y][x-1] == GOAL) {
                GOAL.setCaller(c);
                return true;
            }
        }
        return false;
    }

    public List<Cell> getPATH() {
        return PATH;
    }
}

