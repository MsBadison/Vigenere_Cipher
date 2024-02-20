import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Create cipher");
        System.out.println("2. Decode cipher");
        System.out.println("3. Quit");
        System.out.print("> ");

        String menuChoice = scanner.nextLine();


    }
    public static String encode (String plainText, String key) {
        String cipher = "";
        for (int i = 0; i < plainText.length(); i++) {
            int plainTextNum = ((int) plainText.charAt(i) - 64);
            int keyNum = ((int) key.charAt(i)) - 65;
            int cipherNum = ((plainTextNum + keyNum) % 26) + 64;
            if (cipherNum < 65) {
                cipherNum = cipherNum + 26;
            }
            cipher = cipher.concat(String.valueOf(Character.toChars(cipherNum)));
        }
        return cipher;
    }

    public static String decode (String cipherText, String key) {
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int cipherTextNum = ((int) cipherText.charAt(i) + 65);
            int keyNum = ((int) key.charAt(i) + 65);
            int plainTextNum = ((cipherTextNum - keyNum) % 26) + 65;
            if (plainTextNum < 65) {
                plainTextNum = plainTextNum + 26;
            }
            plainText = plainText.concat(String.valueOf(Character.toChars(plainTextNum)));
        }
        return plainText;
    }
}
