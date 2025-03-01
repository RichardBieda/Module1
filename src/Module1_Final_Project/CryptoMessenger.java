package Module1_Final_Project;

public class CryptoMessenger {

    private final CaesarCipher caesarCipher;

    public CryptoMessenger(String fileNameIn, String fileNameOut, int key) {
        this.caesarCipher = new CaesarCipher(fileNameIn, fileNameOut, key);
    }
}
