package Module1_Final_Project;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

final class FileManager {

    private static final Path ROOT_FOLDER = Path.of("File_Folder");
    private static final Path MESSENGER_FOLDER = Path.of(ROOT_FOLDER + "\\Cipher_App");
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

    private final Path path;

    FileManager(String pathString, boolean isExistingFile) {
        this.path = Path.of(pathString);
        if (isExistingFile && !Files.isRegularFile(path)) {
            throw new IsNotRegularFileException("this file is not a file, or a wrong path is given");
        }
    }

    static String createPathString(boolean isDecrypted) {
        return isDecrypted ? DECRYPTED_FILE.toString() : ENCRYPTED_FILE.toString();
    }

    List<String> readFileContent() {
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

    void writeFileContent(List<String> list, boolean isDecrypted) {
        Path firstPath = isDecrypted ? DECRYPTED_FILE : ENCRYPTED_FILE;
        Path finalPath = Paths.get(firstPath.toString(), path.getFileName().toString());
        try {
            Files.write(finalPath, list);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
