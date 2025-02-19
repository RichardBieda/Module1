package Lesson20;

class EditingDistance {

    //This is my version of Levenshtein-distance with adjacent transposition from Wikipedia
    //I changed its behavior a bit
     static int distance(String s1, String s2) {
        int[][] matrix = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            matrix[i][0] = i;

        }
        for (int j = 0; j <= s2.length(); j++) {
            matrix[0][j] = j;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    matrix[i][j] = Math.min(Math.min(matrix[i][j-1], matrix[i-1][j-1]), matrix[i-1][j]);
                } else if ((i < s1.length()-1 && j < s2.length() -1) && (s1.charAt(i-1) == s2.charAt(j) && s1.charAt(i) == s2.charAt(j-1))) {
                    matrix[i][j] = Math.min(Math.min(matrix[i][j-1], matrix[i-1][j-1]), matrix[i-1][j]);
                } else {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);
                }
            }
        }
        return matrix[s1.length()][s2.length()];
    }
}
