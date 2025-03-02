package Module1_Final_Project;

import java.util.Scanner;

public class CryptoMessenger {

    private final CaesarCipher caesarCipher;
    private final FileManager fileManager;

    public CryptoMessenger(String userName, int key) {
        this.caesarCipher = new CaesarCipher(key);
        this.fileManager = new FileManager(userName);
        start();
    }

    private void start() {
        showFilesOverview();
        while (true) {

        }
    }

    private void showFilesOverview() {
        System.out.println("Decrypted files");
        System.out.println(fileManager.getDecryptedList());
        System.out.println("Encrypted files");
        System.out.println(fileManager.getEncryptedList());
    }
}
