package Module1_Final_Project;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

final class FileManager {

    private static final Path ROOT_FOLDER = Path.of("File_Folder");
    private static final Path MESSENGER_FOLDER = Path.of(ROOT_FOLDER + "\\Crypto_Messenger");
    private static final String ENCRYPTED_FILE = "_ENCRYPTED";
    private static final String DECRYPTED_FILE = "_DECRYPTED";

    static {
        if (Files.notExists(ROOT_FOLDER)) {
            try {
                Files.createDirectory(ROOT_FOLDER);
            } catch (IOException e) {
                throw new NotAbleToCreateFolderException("Unable to create the root folder");
            }
        }
        if (Files.notExists(MESSENGER_FOLDER)) {
            try {
                Files.createDirectory(MESSENGER_FOLDER);
            } catch (IOException e) {
                throw new NotAbleToCreateFolderException("Unable to create the App folder");
            }
        }
    }

    private final Path USER_PATH;
    private final List<Path> ENCRYTED_LIST = new ArrayList<>();
    private final List<Path> DECRYTED_LIST = new ArrayList<>();
    FileManager(String userName) {
        this.USER_PATH = Path.of(MESSENGER_FOLDER + "\\" + userName);
        if (Files.notExists(USER_PATH)) {
            try {
                Files.createDirectory(USER_PATH);
            } catch (IOException e) {
                throw new NotAbleToCreateFolderException("Unable to create user folder for user: " + userName);
            }
        }
        loadPathsToLists();
    }

    private void loadPathsToLists() {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(USER_PATH)) {
            for (Path p : paths) {
                if (p.getFileName().toString().endsWith(ENCRYPTED_FILE)) {
                    ENCRYTED_LIST.add(p.getFileName());
                } else if (p.getFileName().toString().endsWith(DECRYPTED_FILE)) {
                    DECRYTED_LIST.add(p.getFileName());
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    List<Path> getEncryptedList() {
        return ENCRYTED_LIST;
    }

    List<Path> getDecryptedList() {
        return DECRYTED_LIST;
    }
}
