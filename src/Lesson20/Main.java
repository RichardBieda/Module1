package Lesson20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        //insert your path
        //end your word with a semicolon to save the word in the tree
        //write end; to close the programm and save the new words in file
        //the tolerance is the number of permissible wrongs in your word, 2 is the standard tolerance
        //There are 2 constructors
        //new AutoCorrector(Path path); and new AutoCorrector(Path path, int tolerance);
        AutoCorrector autoCorrector = new AutoCorrector("C:\\Users\\Richard\\Module1\\src\\ENGLISH_DICT");
    }
}
