package Module1_Final_Project;

import java.util.ArrayList;
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
        this.fileManager = new FileManager(pathString, true);
        this.KEY = validateKey(key);
        start();
    }

    private void start() {
        if (fileManager != null) {
            doDecryption();
        }
        boolean isNotFinished = true;
        while (isNotFinished) {
            isNotFinished = showMenu();
        }
    }

    private boolean showMenu() {
        System.out.println("[ 1 ] write a new file   [ 2 ] insert file path to decrypt   [ 3 ] BruteForce\nor press any key to end");
        String opt = scan.nextLine();
        switch (opt) {
            case "1" :
                writeANewFile();
                break;
            case "2" :
                insertFilePathToDecrypt();
                break;
            case "3" :
                bruteForce();
                break;
            default :
                return false;
        }
        return true;
    }

    private void bruteForce() {
        System.out.println("brute force is coming soon");
    }

    private void insertFilePathToDecrypt() {
        System.out.println("typ your file path");
        String filePath = scan.nextLine();
        fileManager = new FileManager(filePath, true);
        doDecryption();
    }
    private void writeANewFile() {
        System.out.println("your possible signs: " + CaesarCipher.ALPHABET);
        System.out.println("insert a file name!");
        String fileName = scan.nextLine();
        List<String> decryptList = new ArrayList<>();
        System.out.println("write your text!");
        String text = "";
        while (!(text = scan.nextLine()).isEmpty()) {
            decryptList.add(text.toLowerCase());
        }
        String firstPathPart = FileManager.createPathString(true);
        fileManager = new FileManager(firstPathPart + "\\" + fileName, false);
        fileManager.writeFileContent(decryptList, true);
        doEncryption(decryptList);
    }

    private void doEncryption(List<String> list) {
        List<String> encryptList = new CaesarCipher(KEY, list).doEncryption();
        fileManager.writeFileContent(encryptList, false);
    }
    private void doDecryption() {
        List<String> decryptList = fileManager.readFileContent();
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
