//import Maze.Exceptions.PathNotFoundException;
//import Maze.Fields.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

//class MazeSolver {
//
//    private final Movable user;
//    private int steps;
//    MazeSolver(Movable user) {
//        this.user = user;
//    }
//
//    void solve(Maze maze) throws PathNotFoundException {
//        List<Field> childList = new ArrayList<>();
//        try {
//            childList.add(maze.getStart());
//            doBfs(childList, maze.getDestination());
//            insertPathToMaze(maze);
//        } catch (NullPointerException e) {
//            throw new PathNotFoundException(e);
//        }
//    }
//
//    int getSteps() {
//        int result = steps;
//        steps = 0;
//        return result;
//    }
//
//    private void doBfs(List<Field> childList, Field destination) {
//        List<Field> tmpList = new ArrayList<>();
//        for (Field x : childList) {
//            if (checkDestination(x, destination)) {
//                childList.clear();
//                return;
//            }
//            Field below = x.getBelow();
//            if (below != null && user.canMove(below) && !below.getIsChecked()) {
//                below.setIsChecked(true);
//                below.setCaller(x);
//                tmpList.add(below);
//            }
//            Field left = x.getLeft();
//            if (left != null && user.canMove(left) && !left.getIsChecked()) {
//                left.setIsChecked(true);
//                left.setCaller(x);
//                tmpList.add(left);
//            }
//            Field right = x.getRight();
//            if (right != null && user.canMove(right) && !right.getIsChecked()) {
//                right.setIsChecked(true);
//                right.setCaller(x);
//                tmpList.add(right);
//            }
//            Field above = x.getAbove();
//            if (above != null && user.canMove(above) && !above.getIsChecked()) {
//                above.setIsChecked(true);
//                above.setCaller(x);
//                tmpList.add(above);
//            }
//        }
//        childList = tmpList;
//        if (!childList.isEmpty()) {
//            doBfs(childList, destination);
//        }
//    }
//
//    private boolean checkDestination(Field field, Field destination) {
//        if (field.getAbove() == destination || field.getRight() == destination || field.getBelow() == destination || field.getLeft() == destination) {
//            destination.setCaller(field);
//            return true;
//        }
//        return false;
//    }
//
//    private void insertPathToMaze(Maze maze) throws PathNotFoundException {
//        Field tmp = maze.getDestination().getCaller();
//        if (tmp == null) {
//            throw new PathNotFoundException(PathNotFoundException.NO_PATH_FOUND);
//        }
//        Map<Field, Field> resetMap = new HashMap<>();
//        while (tmp != maze.getStart()) {
//            Field path = new Path();
//            if (tmp == maze.getInitialField()) {
//                maze.setInitialField(path);
//            }
//            resetMap.put(path, tmp);
//            tmp.replaceFieldBy(path);
//            tmp = tmp.getCaller();
//            steps++;
//        }
//        maze.setResetMap(resetMap);
//        maze.setIsSolved(true);
//    }
//}
