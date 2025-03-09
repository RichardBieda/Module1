package Module1_Final_Project;

final class BruteForce {

    private static final char[] ALPHA = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','m','x','y','z',' ','!','?',',','.','\'',':','0','1','2','3','4','5','6','7','8','9'};
    private static final int LENGTH = ALPHA.length;
    private final Dictionary DICTIONARY;


    private final int range;

    BruteForce(int range) {
        this.DICTIONARY = new Dictionary();
        this.range = range;
    }

    void doBruteForce(String encryptedString, int range) {
        char[] input = encryptedString.toCharArray();
        range = Math.max(range, input.length);
        int[] combination = getIndexInAlpha(input);

        while (true) {
            for (int i = 0; i < LENGTH; i++) {
                input[0] = ALPHA[(++combination[0]) % LENGTH];
                DICTIONARY.checkMatch(range);
            }
            combination[0] -= LENGTH;
            for (int i = 1; i < input.length; i++) {
                input[i] = ALPHA[++combination[i] % LENGTH];
                if (input[i] != encryptedString.charAt(i)) {
                    break;
                }
                combination[i] -= LENGTH;
            }
        }
    }

    static int distance(char[] s1, char[] s2) {
        int[][] matrix = new int[s1.length +1][s2.length +1];

        for (int i = 0; i <= s1.length; i++) {
            matrix[i][0] = i;

        }
        for (int j = 0; j <= s2.length; j++) {
            matrix[0][j] = j;
        }
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i-1] == s2[j-1]) {
                    matrix[i][j] = Math.min(Math.min(matrix[i][j-1], matrix[i-1][j-1]), matrix[i-1][j]);
                } else {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);
                }
            }
        }
        return matrix[s1.length][s2.length];
    }

    private int[] getIndexInAlpha(char[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = CaesarCipher.getIndex(input[i]);
        }
        return result;
    }

}
