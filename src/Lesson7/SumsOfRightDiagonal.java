package Lesson7;

public class SumsOfRightDiagonal {

    public static void main(String[] args) {

        int[][] matrix = {
                {4, 8, 4, 7, 0},
                {1, 9, 5, 1, 7},
                {6, 3, 4, 1, 5},
                {1, 9, 5, 1, 7},
                {4, 8, 4, 9, 0},
        };

        //Sum above the right diagonal
        int sumAboveRightDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length-1 -i; j++) {
                sumAboveRightDiagonal += matrix[i][j];
            }
        }
        System.out.println("The sum above the right diagonal is: " + sumAboveRightDiagonal);
        //----------------------------------------------------------------
        //Sum below the right diagonal
        int sumBelowRightDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length-1; j > matrix[i].length-1 -i; j--) {
                sumBelowRightDiagonal += matrix[i][j];
            }
        }
        System.out.println("The sum below the right diagonal is: " + sumBelowRightDiagonal);
    }
}
