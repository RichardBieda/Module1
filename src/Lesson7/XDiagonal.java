package Lesson7;

public class XDiagonal {

    public static void main(String[] args) {

        int[][] matrix = {
                {4, 8, 4, 7, 0, 7},
                {1, 9, 5, 1, 7, 6},
                {6, 3, 4, 1, 5, 3},
                {1, 9, 5, 1, 7, 8},
                {4, 8, 4, 9, 1, 2},
                {5, 6, 1, 7, 3, 4},
        };
//        int[][] matrix = {
//                {4, 8, 4, 7, 0},
//                {1, 9, 5, 1, 7},
//                {6, 3, 4, 1, 5},
//                {1, 9, 5, 1, 7},
//                {4, 8, 4, 9, 0},
//        };
        //Sum below both diagonals
        int belowX = 0;
        for (int i = (matrix.length/2) +1; i < matrix.length; i++) { //it is unnecessary to count the first half of arrays.
            for (int j = matrix[i].length -i; j < i ; j++) {
                belowX += matrix[i][j];
            }
        }
        System.out.println("The sum of number below X is: " + belowX);
        //------------------------------------------------------------------------
        //Sum above both diagonals

        int aboveX = 0;
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = i+1; j < matrix[i].length-1 -i; j++) {
                aboveX += matrix[i][j];
            }
        }
        System.out.println("The sum of number above X is: " + aboveX);

    }
}
