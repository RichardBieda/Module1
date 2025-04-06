package Maze;

import Maze.Fields.Field;
import Maze.Graphics.ConsoleView;

public class DisplayConsole implements Displayable {

    private final static String COUNTY = " %d \n";
    private final static String COUNTX_1 = " %d ";
    private final static String COUNTX_10 = "%d ";
    private final static String COUNTX = "%d";

    @Override
    public String display(Maze maze) {
        StringBuilder sb = new StringBuilder();
        Field row = maze.getInitialField();
        Field column = row;
        for (int i = 0; i < maze.getY(); i++) {
            for (int j = 0; j < maze.getX(); j++) {
                sb.append(ConsoleView.getSign(column));
                column = column.getRight();
            }
            String numberY = String.format(COUNTY, i);
            sb.append(numberY);
            row = row.getBelow();
            column = row;
        }
        for (int i = 0; i < maze.getX(); i++) {
                if (i < 10) {
                    String numberX1 = String.format(COUNTX_1, i);
                    sb.append(numberX1);
                } else if (i < 100){
                    String numberX1 = String.format(COUNTX_10, i);
                    sb.append(numberX1);
                } else {
                    String numberX1 = String.format(COUNTX, i);
                    sb.append(numberX1);
                }
            }
        return sb.toString();
    }
}
