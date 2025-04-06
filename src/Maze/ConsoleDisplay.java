package Maze;

import Maze.Fields.Field;

public class ConsoleDisplay implements Displayable {
    @Override
    public void display(Field field) {
            StringBuilder sb = new StringBuilder();
            Field row = field;
            Field column = row;

//            for (int i = 0; i < Y; i++) {
//                for (int j = 0; j < X; j++) {
//                    sb.append(column.getSign());
//                    column = column.getRight();
//                }
//                sb.append(" " + i + "\n");
//                row = row.getBelow();
//                column = row;
//            }
//            for (int i = 0; i < X; i++) {
//                if (i < 10) {
//                    sb.append(" " + i + " ");
//                } else {
//                    sb.append(i + " ");
//                }
//            }
            System.out.println(sb);
    }
}
