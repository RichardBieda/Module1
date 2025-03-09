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

    private int[] getIndexInAlpha(char[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = CaesarCipher.getIndex(input[i]);
        }
        return result;
    }

}
