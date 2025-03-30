package Maze;

public class Main {

    public static void main(String[] args) {

        Maze l = new Maze(10, 10);
        l.fieldArray[6][4] = new Barrier(4, 4);
        l.fieldArray[5][4] = new Barrier(5, 4);
        l.fieldArray[7][4] = new Barrier(5, 4);
        l.fieldArray[6][3] = new Barrier(5, 4);
        l.fieldArray[6][5] = new Barrier(5, 4);
        l.fieldArray[7][5] = new Destination(7, 5);
        l.showLabyrinth();
        System.out.println("\n");
        l.setStart(4, 3);
        l.showLabyrinth();
    }
}
