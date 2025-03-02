package Module1_Final_Project;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Files;

final class FileManager {

    private static final Path ROOT_FOLDER = Path.of("File_Folder");
    private static final Path MESSENGER_FOLDER = Path.of(ROOT_FOLDER + "\\Crypto_Messenger");
    private static final String ENCRYPTED_FILE = "\\_ENCRYPTED";
    private static final String DECRYPTED_FILE = "\\_DECRYPTED";

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

    private final String USER_NAME;
    FileManager(String userName) {
        this.USER_NAME = userName;
        try {
            Files.createDirectory(Path.of(MESSENGER_FOLDER + "\\" + USER_NAME));
        } catch (FileAlreadyExistsException e) {
            throw new NotAbleToCreateFolderException("Unable to create the App folder, user name: " + USER_NAME + " already exists");
        } catch (IOException e) {
            throw new NotAbleToCreateFolderException("Unable to create user folder for user: " + USER_NAME);
        }
    }

    private void loadFile(Path path) {

    }
}
