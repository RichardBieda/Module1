package Module1_Final_Project;

import java.util.Scanner;

public class CryptoMessenger {

    private final CaesarCipher caesarCipher;


    public CryptoMessenger(int key) {
        this.caesarCipher = new CaesarCipher(key);
    }
}
