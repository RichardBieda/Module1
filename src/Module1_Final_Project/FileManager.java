package Module1_Final_Project;

import java.nio.file.Path;
import java.nio.file.Files;

public class FileManager {

    private final String inputFile;
    private final String outputFile;

    FileManager(String input, String output) {

        Path inputPath = Path.of(this.inputFile = input);
        Path outputPath = Path.of(this.outputFile = output);
    }

    private void loadFile(Path path) {
        try {

        }
    }
}
