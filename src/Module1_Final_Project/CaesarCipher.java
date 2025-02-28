package Module1_Final_Project;

public class CaesarCipher {

    private final FileManager fileManager;
    private final int key;

    CaesarCipher(String fileName, int key) {
        this.fileManager = new FileManager(fileName);
        this.key = key;
    }

}
