package AutoCorrector;

public class Main {

    public static void main(String[] args) {

        /*
        insert your path
        typ a semicolon on the end of your word if you want it inserted to the dictionary
        typ end; to save the new words in the file and close the programm
        there are 2 constructors:
        new AutoCorrector(Path path);
        new AutoCorrector(Path path, int tolerance);
        the tolerance is the allowed number of wrongs, standard is 2
         */
        AutoCorrector autoCorrector = new AutoCorrector("ZZFile_Folder\\AutoCorrector\\ENGLISH_DICT");
    }
}
