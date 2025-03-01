package Module1_Final_Project;

final class CaesarCipher {

    private final FileManager fileManager;
    private final int key;

    CaesarCipher(int key) {
        this.fileManager = new FileManager();
        this.key = key;
    }

}
