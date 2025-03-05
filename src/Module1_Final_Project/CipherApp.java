package Module1_Final_Project;

import java.util.List;
import java.util.Scanner;

public class CipherApp {

    private final FileManager fileManager;
    private final Scanner scan = new Scanner(System.in);
    private final int key;

    public CipherApp(int key) {
        this.fileManager = new FileManager();
        this.key = validateKey(key);
        start();
    }
    public CipherApp(String pathString, boolean isDecrypted, int key) {
        this.fileManager = new FileManager(pathString, isDecrypted);
        this.key = validateKey(key);
        start();
    }

    private void start() {
        showMenu();
    }

    private void showMenu() {
        if (fileManager.hasPathField()) {
            doDecryption();
        }
        System.out.println("[ 1 ] write a new file   [ 2 ] insert file path to decrypt");
    }


    private void doEncryption() {

    }
    private void doDecryption() {
        List<String> decryptList = fileManager.getFileContent();
        List<String> readyList = CaesarCipher.doDecryption(decryptList, key);
        fileManager.writeFileContent(readyList, true);
    }

    private int validateKey(int key) {
        if (key < 1) {
            System.out.println("your key shall be greater 0, insert new one");
            if (scan.hasNextInt()) {
                key = validateKey(scan.nextInt());
            } else {
                scan.next();
                validateKey(key);
            }
        }
        return key;
    }
}
