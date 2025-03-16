package Labyrinth;

public class Main {

    public static void main(String[] args) {

        Labyrinth l = new Labyrinth(10, 10);
        l.fieldArray[4][9] = new Barrier(4, 4);
        l.fieldArray[5][9] = new Barrier(5, 4);
        l.fieldArray[5][8] = new Barrier(5, 4);
        l.showLabyrinth();
    }
}
