package Maze;

public class Main {

    public static void main(String[] args) {

        Maze l = new Maze(10, 10);
        l.fieldArray[4][5] = new Barrier(4, 5);
        l.fieldArray[4][6] = new Barrier(4, 6);
        l.fieldArray[4][4] = new Barrier(4, 4);
        l.fieldArray[5][5] = new Barrier(5, 5);
        l.fieldArray[6][5] = new Barrier(6, 5);
        l.showLabyrinth();
        System.out.println("\n");
        l.setStart(5, 4);
        l.setDestination(3, 6);
        l.findPath();
        l.showLabyrinth();
    }
}
