import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuChoice;

        do {
            showMenu();
            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    encodeMenuOption();
                    break;
                case 2:
                    decodeMenuOption();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (menuChoice != 3);
    }

    /**
     * Loops over the plaintext, converting it to ciphertext using the supplied key
     * @param plainText the text to be encrypted
     * @param key the encryption key
     * @return the encoded cipher text
     */
    public static String encode (String plainText, String key) {
        String cipherText = "";

        // Expand the key, so it is longer than the plain text
        while (key.length() < plainText.length()) {
            key = key.concat(key);
        }

        for (int i = 0; i < plainText.length(); i++) {
            int plainTextNum = ((int) plainText.charAt(i) - 64);
            int keyNum = ((int) key.charAt(i)) - 65;
            int cipherNum = ((plainTextNum + keyNum) % 26) + 64;
            if (cipherNum < 65) {
                cipherNum = cipherNum + 26;
            }
            cipherText = cipherText.concat(String.valueOf(Character.toChars(cipherNum)));
        }
        return cipherText;
    }

    /**
     * Loops over the cipher text, converting it to plaintext using the supplied key
     * @param cipherText the text to be decrypted
     * @param key the encryption key
     * @return the decoded plaintext
     */
    public static String decode (String cipherText, String key) {
        String plainText = "";

        // Expand the key, so it is longer than the cipher text
        while (key.length() < cipherText.length()) {
            key = key.concat(key);
        }

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

    /**
     * Gets user input and invokes encode function
     */
    public static void encodeMenuOption () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text to be encoded (only letters): ");
        String plaintext = scanner.nextLine().toUpperCase().replaceAll("[^a-zA-Z]", "");

        System.out.print("Enter the encryption key (only letters): ");
        String key = scanner.nextLine().toUpperCase().replaceAll("[^a-zA-Z]", "");

        String cipherText = encode(plaintext, key);
        System.out.println("The encrypted text is: " + cipherText);
    }

    /**
     * Gets user input and invokes decode function
     */
    public static void decodeMenuOption () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text to be decoded (only letters): ");
        String ciphertext = scanner.nextLine().toUpperCase().replaceAll("[^a-zA-Z]", "");

        System.out.print("Enter the encryption key (only letters): ");
        String key = scanner.nextLine().toUpperCase().replaceAll("[^a-zA-Z]", "");

        String plaintext = decode(ciphertext, key);
        System.out.println("The decrypted text is: " + plaintext);
    }

    public static void showMenu () {
        System.out.println("1. Create cipher");
        System.out.println("2. Decode cipher");
        System.out.println("3. Quit");
        System.out.print("> ");
    }
}

