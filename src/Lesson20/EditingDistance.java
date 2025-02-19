package Lesson20;

class EditingDistance {

    //This is my version of Levenshtein-distance with adjacent transposition from Wikipedia
    //I changed its behavior by transpositions a bit
    //But Levenshtein distance sometimes gives a bad result for example, off and of is = 0 that's clearly wrong should be 1
    /*
       ""o f f                if the BKTree adds words (Strings) from file to the tree, it checks the distance to generate new nodes.
    "" 0 1 2 3                if the distance is 0 that means the tested words are equal, and this word will not be added because there shall be no duplicate words
    o  1 0 1 2                This is the reason why my file contains 9900 Strings, but 8887 are added to the BKTree (I tested it)
    f  2 1 0 0<- result       in those cases it could be tested whether the last char of the shorter word is equal to the missing ones.

    off - of                  the words on the left side are not added to the tree because the distance to the words on the left are 0
    too - to                  three is twice in the dictionary file
    ff - f                    there is no need for an extra test
    ee - e
    three - three
    thee - the
    tt - t
    tee - te
    oo - o
    thee - the
    ooo - o
    hh - h




     */
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
     static int distance2( String s1, String s2) {
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
                 } else if (i > 1 && j > 1 && s1.charAt(i-1) == s2.charAt(j-2) && s2.charAt(j-1) == s1.charAt(i-2)) {
                     matrix[i][j] = Math.min(Math.min(matrix[i][j-1], matrix[i-1][j-1]), matrix[i-1][j]);
                 } else {
                     matrix[i][j] = 1 + Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);
                 }
             }
         }
         return matrix[s1.length()][s2.length()];
    }
}
