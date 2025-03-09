package Module1_Final_Project.BruteForce;

final class BruteForce {

    private static final char[] ALPHA = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','m','x','y','z',' ','!','?',',','.','\'',':','0','1','2','3','4','5','6','7','8','9'};
    private static final int LENGTH = ALPHA.length;
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
