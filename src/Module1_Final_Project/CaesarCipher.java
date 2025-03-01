package Module1_Final_Project;

final class CaesarCipher {

    private final FileManager fileManager;
    private final int key;

    CaesarCipher(String name, int key) {
        this.fileManager = new FileManager(name);
        this.key = key;
    }

}
