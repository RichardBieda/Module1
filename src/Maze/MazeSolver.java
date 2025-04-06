package Maze;

import Maze.Exceptions.PathNotFoundException;
import Maze.Fields.Barrier;
import Maze.Fields.Field;
import Maze.Fields.Path;
import Maze.Interfaces.Movable;

import java.util.ArrayList;
import java.util.List;

class MazeSolver {

    private final Movable user;
    MazeSolver(Movable user) {
        this.user = user;
    }

    void solve(Field startField, Field destination) throws PathNotFoundException {

        List<Field> childList = new ArrayList<>();
        try {
            childList.add(startField);
            doBfs(childList, destination);
            insertPathToMaze(startField, destination);
        } catch (NullPointerException e) {
            throw new PathNotFoundException(e);
        }
    }

    private void doBfs(List<Field> childList, Field destination) {
        List<Field> tmpList = new ArrayList<>();
        for (Field x : childList) {
            if (checkDestination(x, destination)) {
                childList.clear();
                return;
            }
            Field below = x.getBelow();
            if (below != null && user.canMove(below) && !below.getIsChecked()) {
                below.setIsChecked(true);
                below.setCaller(x);
                tmpList.add(below);
            }
            Field left = x.getLeft();
            if (left != null && user.canMove(left) && !left.getIsChecked()) {
                left.setIsChecked(true);
                left.setCaller(x);
                tmpList.add(left);
            }
            Field right = x.getRight();
            if (right != null && user.canMove(right) && !right.getIsChecked()) {
                right.setIsChecked(true);
                right.setCaller(x);
                tmpList.add(right);
            }
            Field above = x.getAbove();
            if (above != null && user.canMove(above) && !above.getIsChecked()) {
                above.setIsChecked(true);
                above.setCaller(x);
                tmpList.add(above);
            }
        }
        childList = tmpList;
        if (!childList.isEmpty()) {
            doBfs(childList, destination);
        }
    }

    private boolean checkDestination(Field field, Field destination) {
        if (field.getAbove() == destination || field.getRight() == destination || field.getBelow() == destination || field.getLeft() == destination) {
            destination.setCaller(field);
            return true;
        }
        return false;
    }

    private void insertPathToMaze(Field start, Field destination) throws PathNotFoundException{
        Field tmp = destination.getCaller();
        if (tmp == null) {
            throw new PathNotFoundException(PathNotFoundException.NO_PATH_FOUND);
        }
        while (tmp != start) {
            tmp.replaceFieldBy(new Path());
            tmp = tmp.getCaller();
        }
    }
}
