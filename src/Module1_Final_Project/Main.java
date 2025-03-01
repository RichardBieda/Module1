package Module1_Final_Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Main {

    static ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ', '!', '?', ',', '.','0','1','2','3','4','5','6','7','8','9'));
    static char[] alpha = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ', '!', '?', ',', '.','0','1','2','3','4','5','6','7','8','9'};
    static int length = alphabet.size();

    public static void main(String[] args) {

//        System.out.println(encrypt("john", 8));
//        bruteForce("abcde");
//        String x = String.valueOf(Objects.hash("richard"));
//        Path p2 = Path.of(x);
//        System.out.println(x);
//        Path path = Path.of("src");
//        Path p1 = path.toAbsolutePath();
//        Path abs = Paths.get(p1.toString(), p2.toString());
//        System.out.println(abs);
//
//        try {
//            Files.createFile(abs);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        Path end = Path.of("ZZFile_Folder\\Crypto_Messenger\\Outgoing_Files").toAbsolutePath();
//        try {
//            Files.createDirectory(end);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Path path = Path.of("File_Folder\\AutoCorrector\\ENGLISH_DICT");
//        Path path1 = Path.of("File_Folder\\Crypto_Messenger\\Encrypted_List");
//        List<String> list = null;
//        List<String> enl = new ArrayList<>();
//        try {
//            list = Files.readAllLines(path);
//            for (String x : list) {
//                enl.add(encrypt(x, 1));
//            }
//            Files.write(path1, enl);
//        } catch (IOException e) {
//
//        }
    }

    static String encrypt(String input, int code) {
        if (code == 0) {
            return input;
        }
        if (code < 0) {
            code = ~code+1;
        }
        while (code > length) {
            code %= length;
        }

        char[] wordChar = input.toCharArray();

        for (int i = 0; i < wordChar.length; i++) {
            int oldValue = alphabet.indexOf(wordChar[i]);
            int index = (oldValue + code) % length;
            wordChar[i] = alphabet.get(index);
        }
        String result = new String(wordChar);
        return result;
    }

    static void bruteForce(String input) {
        char[] suggest = input.toCharArray();
        int[] indexInAlphabet = new int[input.length()];
            for (int i = 0; i < indexInAlphabet.length; i++) {
                indexInAlphabet[i] = getIndex(suggest[i]);
            }
        Instant start = Instant.now();
        do  {

            for (int i = 0; i < length; i++) {
                suggest[0] = alpha[(++indexInAlphabet[0]) % length];
            }
            indexInAlphabet[0] -= length;
            for (int i = 1; i < suggest.length; i++) {
                suggest[i] = alpha[++indexInAlphabet[i] % length];
                if (suggest[i] != input.charAt(i)) {
                    break;
                }
                indexInAlphabet[i] -= length;
            }

        } while (!Arrays.equals(suggest, input.toCharArray()));
        Duration time = Duration.between(start, Instant.now());
        System.out.println(time.getSeconds() + "." + time.getNano());
    }

    static int getIndex(char c) {
        int result = -1;
        for (int i = 0; i < alpha.length; i++) {
            if (c == alpha[i]) {
                result = i;
                break;
            }
        }
        //Exception char not found
        return result;
    }

}
