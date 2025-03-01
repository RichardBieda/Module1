package Module1_Final_Project;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

final class FileManager {

    private static final String ROOT_FOLDER = "File_Folder";
    private static final String MESSENGER_FOLDER = ROOT_FOLDER + "\\Crypto_Messenger";

    static {
        Path root = Path.of(ROOT_FOLDER);
        Path messenger = Path.of(MESSENGER_FOLDER);
        if (Files.notExists(root)) {
            try {
                Files.createDirectory(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Files.notExists(messenger)) {
            try {
                Files.createDirectory(messenger);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private final String name;

    FileManager(String name) {
       this.name = name;
       insertChatToFolder();
    }

    private void insertChatToFolder() {
        Path path = Path.of(MESSENGER_FOLDER + "\\" + name);
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean isNameTaken(String name) {
        Path chatPartner = Path.of(MESSENGER_FOLDER + "\\" + name);
        if (Files.exists(chatPartner)) {
            return true;
        }
        return false;
    }

    private void loadFile(Path path) {

    }
}
