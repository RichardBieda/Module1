package Module1_Final_Project;

import java.util.List;
import java.util.Scanner;

public class CipherApp {

    private FileManager fileManager;
    private final Scanner scan = new Scanner(System.in);
    private final int KEY;

    public CipherApp(int key) {
        this.KEY = validateKey(key);
        start();
    }
    public CipherApp(String pathString, int key) {
        this.fileManager = new FileManager(pathString);
        this.KEY = validateKey(key);
        start();
    }

    private void start() {
        boolean isNotFinished = true;
        while (isNotFinished) {
            isNotFinished = showMenu();
        }
    }

    private boolean showMenu() {
        if (fileManager != null) {
            doDecryption();
        }
        System.out.println("[ 1 ] write a new file   [ 2 ] insert file path to decrypt   [ 3 ] BruteForce\nor press any key to end");
        String opt = scan.nextLine();
        switch (opt) {
            case "1" :
                System.out.println("your possible signs: " + CaesarCipher.ALPHABET);
                doEncryption();
                break;
            case "2" :
                //insert path
                //doDecryption();
                break;
            case "3" :
                //doBruteForce
                break;
            default :
                return false;
        }
        return true;
    }


    private void doEncryption() {

    }
    private void doDecryption() {
        List<String> decryptList = fileManager.getFileContent();
        List<String> readyList = new CaesarCipher(KEY, decryptList).doDecryption();
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
        return key % CaesarCipher.LENGTH;
    }
}
