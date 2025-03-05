package Module1_Final_Project;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

final class FileManager {

    private static final Path ROOT_FOLDER = Path.of("File_Folder");
    private static final Path MESSENGER_FOLDER = Path.of(ROOT_FOLDER + "\\Crypto_Messenger");
    private static final Path ENCRYPTED_FILE = Path.of(MESSENGER_FOLDER + "\\ENCRYPTED");
    private static final Path DECRYPTED_FILE = Path.of(MESSENGER_FOLDER + "\\DECRYPTED");

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
        if (Files.notExists(ENCRYPTED_FILE)) {
            try {
                Files.createDirectory(ENCRYPTED_FILE);
            } catch (IOException e) {
                throw new NotAbleToCreateFolderException("Unable to create folder");
            }
        }
        if (Files.notExists(DECRYPTED_FILE)) {
            try {
                Files.createDirectory(DECRYPTED_FILE);
            } catch (IOException e) {
                throw new NotAbleToCreateFolderException("Unable to create folder");
            }
        }
    }

    private Path path;
    private boolean isDecrypted;

    FileManager() {}
    FileManager(String pathString, boolean isDecrypted) {
        this.path = Path.of(pathString);
        if (!Files.isRegularFile(path)) {
            throw new IsNotRegularFileException("this file is not a file, or a wrong path is given");
        }
        this.isDecrypted = isDecrypted;
    }

    void createNewFile(String pathString, boolean isDecrypted) {
        this.path = Path.of(pathString);
        if (!Files.isRegularFile(path)) {
            throw new IsNotRegularFileException("this file is not a file, or a wrong path is given");
        }
        this.isDecrypted = isDecrypted;
    }

    boolean hasPathField() {
        return path != null;
    }

    List<String> getFileContent() {
        List<String> result = null;
        try {
            result = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

    void writeFileContent(List<String> list, boolean isDecrypted) {
        Path firstPath = isDecrypted ? DECRYPTED_FILE : ENCRYPTED_FILE;
        Path secondPath = Paths.get(firstPath.toString(), path.getFileName().toString());
        try {
            Files.write(secondPath, list);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
