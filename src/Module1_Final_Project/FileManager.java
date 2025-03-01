package Module1_Final_Project;

import java.nio.file.Path;
import java.nio.file.Files;

public class FileManager {

    private final String incomingFile;
    private final String outgoingFile;


    FileManager(String fileNameIn, String fileNameOut) {
       this.incomingFile = fileNameIn;
       this.outgoingFile = fileNameOut;

    }

    private void loadFile(Path path) {

    }
}
