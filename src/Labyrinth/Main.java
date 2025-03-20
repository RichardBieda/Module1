package Labyrinth;

public class Main {

    public static void main(String[] args) {

        Labyrinth l = new Labyrinth(10, 10);
//        l.fieldArray[6][4] = new Barrier(4, 4);
//        l.fieldArray[5][4] = new Barrier(5, 4);
//        l.fieldArray[7][4] = new Barrier(5, 4);
//        l.fieldArray[6][3] = new Barrier(5, 4);
//        l.fieldArray[6][5] = new Barrier(5, 4);
        l.fieldArray[5][5] = new WrongPath(5, 5);
        l.showLabyrinth();
//        int[][] arr = new int[8][10];
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = i;
//            }
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
    }
}
