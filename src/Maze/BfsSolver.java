package Maze;

import Maze.Swing.Cell;
import Maze.User.Movable;
import java.util.ArrayList;
import java.util.List;

public class BfsSolver {

    private Cell[][] fields;
    private Movable user;
    private int goalY;
    private int goalX;
    private int startY;
    private int startX;
    private List<Cell> paths = new ArrayList<>();

    public BfsSolver() {
    }

    public void solve(Cell[][] fields, Cell start, Cell goal, Movable user) throws PathNotFoundException {
        this.fields = fields;
        this.goalY = goal.getCY();
        this.goalX = goal.getCX();
        this.startY = start.getCY();
        this.startX = start.getCX();
        this.user = user;
        List<Cell> neighbors = new ArrayList<>();
        neighbors.add(fields[startY][startX]);
        System.out.println(fields.length);
        System.out.println(fields[0].length);
        System.out.println("start doBFS");
        doBfs(neighbors);
        System.out.println("end doBFS");
        determinePath();
    }

    private void doBfs(List<Cell> neighbors) {
        List<Cell> tmpList = new ArrayList<>();
        for (Cell x : neighbors) {
            int fx = x.getCX();
            int fy = x.getCY();
            if (checkDestination(x)) {
                neighbors.clear();
                return;
            }
            //check below
            if (fy +1 < fields.length) {
                if (user.canMove(fields[fy+1][fx].getField()) && !fields[fy+1][fx].isChecked()) {
                    fields[fy+1][fx].setChecked(true);
                    fields[fy+1][fx].setCaller(fields[fy][fx]);
                    tmpList.add(fields[fy+1][fx]);
                }
            }
            //check left
            if (fx -1 >= 0) {
                if (user.canMove(fields[fy][fx-1].getField()) && !fields[fy][fx-1].isChecked()) {
                    fields[fy][fx-1].setChecked(true);
                    fields[fy][fx-1].setCaller(fields[fy][fx]);
                    tmpList.add(fields[fy][fx-1]);
                }
            }
            //check right
            if (fx +1 < fields[fy].length) {
                if (user.canMove(fields[fy][fx+1].getField()) && !fields[fy][fx+1].isChecked()) {
                    fields[fy][fx+1].setChecked(true);
                    fields[fy][fx+1].setCaller(fields[fy][fx]);
                    tmpList.add(fields[fy][fx+1]);
                }
            }
            //check above
            if (fy -1 >= 0) {
                if (user.canMove(fields[fy-1][fx].getField()) && !fields[fy-1][fx].isChecked()) {
                    fields[fy-1][fx].setChecked(true);
                    fields[fy-1][fx].setCaller(fields[fy][fx]);
                    tmpList.add(fields[fy-1][fx]);
                }
            }
        }
        neighbors = tmpList;
        if (!neighbors.isEmpty()) {
            doBfs(neighbors);
        }
        System.out.println("doBFS finished");
    }

    private void determinePath() throws PathNotFoundException {
        if (fields[goalY][goalX].getCaller() == null) {
            throw new PathNotFoundException(PathNotFoundException.NO_PATH_FOUND);
        }
        int rounds = 0;
        Cell tmp = fields[goalY][goalX].getCaller();
        System.out.println("goalC: " + fields[goalY][goalX].getCaller().getCY() + ", " + fields[goalY][goalX].getCaller().getCX());
        while (tmp != null && tmp != fields[startY][startX]) {
            paths.add(fields[tmp.getCY()][tmp.getCX()]);
            System.out.println("WC: " + fields[tmp.getCY()][tmp.getCX()].getCaller().getCY() + ", " + fields[tmp.getCY()][tmp.getCX()].getCaller().getCX());
            tmp = fields[tmp.getCY()][tmp.getCX()].getCaller();
            if (++rounds > fields.length * fields[0].length) break;
        }
    }

    private boolean checkDestination(Cell c) {
        System.out.println("checkDestination");
        int y = c.getCY();
        int x = c.getCX();
        //test above bound
        if (y -1 >= 0) {
            if (fields[y-1][x] == fields[goalY][goalX]) {
                fields[goalY][goalX].setCaller(fields[y][x]);
                System.out.println("found");
                return true;
            }
        }
        //test right bound
        if (x +1 < fields[y].length) {
            if (fields[y][x+1] == fields[goalY][goalX]) {
                fields[goalY][goalX].setCaller(fields[y][x]);
                System.out.println("found");
                return true;
            }
        }
        //test below bound
        if (y +1 < fields.length) {
            if (fields[y+1][x] == fields[goalY][goalX]) {
                fields[goalY][goalX].setCaller(fields[y][x]);
                System.out.println("found");
                return true;
            }
        }
        //test left bound
        if (x -1 >= 0) {
            if (fields[y][x-1] == fields[goalY][goalX]) {
                fields[goalY][goalX].setCaller(fields[y][x]);
                System.out.println("found");
                return true;
            }
        }
        return false;
    }

    public List<Cell> getPaths() {
        return paths;
    }
}

