package Module1_Final_Project;

public class Main {

    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ', '!', '?', ',', '.','0','1','2','3','4','5','6','7','8','9'};
    static int length = alphabet.length;

    public static void main(String[] args) {

        System.out.println(alphabet.length);
        System.out.println(encrypt("az", 261));
    }

    static String encrypt(String input, int code) {
        if (code == 0) {
            return input;
        }
        if (code < 0) {
            code = ~code;
        }
        while (code > 26) {
            code %= 26;
        }

        byte[] wordChar = input.getBytes();

        for (int i = 0; i < wordChar.length; i++) {
            int newValue = code + wordChar[i] < 123 ? code + wordChar[i] : code + wordChar[i] - 26;
            wordChar[i] = (byte) newValue;
        }
        String result = new String(wordChar);
        return result;
    }

}
