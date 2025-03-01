package Module1_Final_Project;

public class CaesarCipher {

    private final FileManager fileManager;
    private final int key;

    CaesarCipher(String fileNameIn, String fileNameOut, int key) {
        this.fileManager = new FileManager(fileNameIn, fileNameOut);
        this.key = key;
    }

}
