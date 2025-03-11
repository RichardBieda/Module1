package Module1_Final_Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

//This class is the Main class it contains methods and variables for testings.
public class Main {

    public static void main(String[] args) {

        //CipherApp ca = new CipherApp(5);
        BruteForce b = new BruteForce(4);
        b.doBruteForce("ab", 3);
        System.out.println("dic");
    }
}
