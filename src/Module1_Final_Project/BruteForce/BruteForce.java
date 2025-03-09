package Module1_Final_Project.BruteForce;

final class BruteForce {

    private final Dictionary DICTIONARY;
    private int range;

    BruteForce(String dictionaryPath, int range) {
        this.DICTIONARY = new Dictionary(dictionaryPath);
        this.range = range;
    }

    void doBruteForce(String encryptedString, int range) {
        char[] input = encryptedString.toCharArray();

        for (int i = 0; i < input.length; i++) {

        }
    }

}
