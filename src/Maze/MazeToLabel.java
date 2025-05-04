package Maze;

import Maze.Fields.Field;
import Maze.SwingComponents.MazeLabel;

public class MazeToLabel {

    private final Maze maze;
    public MazeToLabel(int y, int x) {
       maze = new Maze(y, x);
   }

   public MazeLabel[][] getLabels() {
        MazeLabel[][] result = new MazeLabel[maze.getY()][maze.getX()];
       Field tmp = maze.getInitialField();
       Field row = tmp;
       for (int i = 0; i < maze.getY(); i++) {
           for (int j = 0; j < maze.getX(); j++) {
               result[i][j] = new MazeLabel(i, j);
               tmp = tmp.getRight();
           }
           row = row.getBelow();
           tmp = row;
       }
        return result;
   }
}
