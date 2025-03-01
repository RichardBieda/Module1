package Module1_Final_Project;

import java.util.Scanner;

public class CryptoMessenger {

    private final CaesarCipher caesarCipher;
    private final Scanner scan = new Scanner(System.in);


    public CryptoMessenger(String name, int key) {
        while (FileManager.isNameTaken(name)) {
            System.out.println("your chat name is already taken, try a new one");
            name = scan.nextLine();
        }
        this.caesarCipher = new CaesarCipher(name, key);
    }
}
