package Module1_Final_Project;

public class CryptoMessenger {

    private final CaesarCipher caesarCipher;

    public CryptoMessenger(String fileName, int key) {
        this.caesarCipher = new CaesarCipher(fileName, key);
    }
}
