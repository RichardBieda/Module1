package Module1_Final_Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* CipherApp is the root class in this programm, it has 2 constructors one is for immediately file decryption
* CipherApp(String path, int key) and CipherApp(int key).
*
* This programm creates a folder path in this Module File_Folder -> Cipher_App -> and two sub folders decrypted and encrypted.
*
* This class also contains the user interface with 3 options.
* typ 1 to write a new file, for that you have to insert a file name and then typ your message. After that 2 files will be created one is decrypted the other encrypted by your key.
* typ 2 to typ a new file path that shall be decrypted by your key, you will get a new file in the decrypted folder.
* */
public final class CipherApp {

    private FileManager fileManager;
    private final Scanner scan = new Scanner(System.in);
    private final int KEY;

    public CipherApp(int key) {
        validateKey(key);
        this.KEY = key;
        start();
    }
    public CipherApp(String pathString, int key) {
        validateKey(key);
        this.fileManager = new FileManager(pathString, true);
        this.KEY = key;
        start();
    }

    private void start() {
        if (fileManager != null) {
            try {
                getDecryption();
            } catch (IOException e) {
                System.out.println("file manager was unable to read the file content: " + e);
            }
        }
        boolean isNotFinished = true;
        while (isNotFinished) {
            isNotFinished = showMenu();
        }
        scan.close();
    }

    private boolean showMenu() {
        System.out.println("[ 1 ] write a new file   [ 2 ] insert file path to decrypt   [ 3 ] BruteForce\n[ or press any key to end ]");
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
        System.out.println("typ the encrypted String");
        String encrypt = scan.nextLine();
        System.out.println("choose how many rows shall be brute forced ");
        String row = scan.nextLine();
        int range = 0;
        boolean isInvalidRow = false;
        do {
            try {
                range = Integer.parseInt(row);
                if (range < 1) {
                    throw new NumberFormatException();
                }
                isInvalidRow = false;
            } catch (NumberFormatException e) {
                System.out.println("choose a number greater 0");
                isInvalidRow = true;
            }
        } while (isInvalidRow);
        new BruteForce(encrypt, range);
    }

    private void insertFilePathToDecrypt() {
        System.out.println("typ your file path");
        String filePath = scan.nextLine();
        try {
            fileManager = new FileManager(filePath, true);
        } catch (IsNotRegularFileException e) {
            System.out.println("there is something wrong with your file");
            return;
        }
        try {
            getDecryption();
        } catch (IOException e) {
            System.out.println("file manager was unable to read the file content: " + e);
        }
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
        getEncryption(decryptList);
    }

    private void getEncryption(List<String> list) {
        List<String> encryptList = new CaesarCipher(KEY, list).doEncryption();
        fileManager.writeFileContent(encryptList, false);
    }
    private void getDecryption() throws IOException {
        List<String> decryptList = fileManager.readFileContent();
        List<String> readyList = new CaesarCipher(KEY, decryptList).doDecryption();
        fileManager.writeFileContent(readyList, true);
    }

    private void validateKey(int key) {
        if (key < 1) {
            throw new NotValidKey("your key has to be a number greater 0");
        }
    }
}
