package Maze;

public class Main {

    public static void main(String[] args) {

        Maze m = new Maze(10, 10);
        System.out.println(Field.count);
        m.setStart(0, 8);
        m.setDestination(9, 1);
        m.showMaze();
    }
}
