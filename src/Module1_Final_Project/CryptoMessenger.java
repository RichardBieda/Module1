package Module1_Final_Project;

import java.util.Scanner;

public class CryptoMessenger {

    private final CaesarCipher caesarCipher;
    private final FileManager fileManager;
    private final String USER_NAME;


    public CryptoMessenger(String userName, int key) {
        this.caesarCipher = new CaesarCipher(key);
        this.fileManager = new FileManager(userName);
        this.USER_NAME = userName;
    }
}
