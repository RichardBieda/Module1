package Maze;

public class Main {

    public static void main(String[] args) {

        Maze l = new Maze(5, 5);
        l.fieldArray[3][2] = new Barrier(4, 4);
        l.fieldArray[3][3] = new Barrier(5, 4);
        l.fieldArray[3][1] = new Barrier(5, 4);
        l.fieldArray[2][2] = new Barrier(5, 4);
        l.fieldArray[4][2] = new Barrier(5, 4);
        l.showLabyrinth();
        System.out.println("\n");
        l.setStart(1, 1);
        l.setDestination(4, 3);
        l.findPath();
        l.showLabyrinth();
    }
}
