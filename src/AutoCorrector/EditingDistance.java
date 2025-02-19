package AutoCorrector;

class EditingDistance {

    /*

    This is my version of Levenshtein-distance with adjacent transposition from Wikipedia
    I changed its behavior a bit
    the levenshtein distance has drawbacks for example off and of give back 0, that is obviously wrong.

      "" o f f
    "" 0 1 2 3
     o 1 0 1 2
     f 2 1 0 0 <- result

    My file has 9900 Strings but 9889 are added to the dictionary.
    The words below on the left are the words who are not added, because the words on the right have a distance of 0 to them.

    off - of
    too - to
    aa - a
    ff - f
    ee - e
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
                } else if (i > 1 && j > 1 && s1.charAt(i-2) == s2.charAt(j-1) && s1.charAt(i-1) == s2.charAt(j-2)) {
                    matrix[i][j] = Math.min(Math.min(matrix[i][j-1], matrix[i-1][j-1]), matrix[i-1][j]);
                } else {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);
                }
            }
        }
        return matrix[s1.length()][s2.length()];
    }
}
