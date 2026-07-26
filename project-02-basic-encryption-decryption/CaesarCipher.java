import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {

        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {

            if (Character.isUpperCase(character)) {

                char encrypted = (char) (((character - 'A' + shift) % 26) + 'A');
                result.append(encrypted);

            }
            else if (Character.isLowerCase(character)) {

                char encrypted = (char) (((character - 'a' + shift) % 26) + 'a');
                result.append(encrypted);

            }
            else {

                result.append(character);

            }
        }

        return result.toString();
    }


    public static String decrypt(String text, int shift) {

        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {

            if (Character.isUpperCase(character)) {

                char decrypted = (char) (((character - 'A' - shift + 26) % 26) + 'A');
                result.append(decrypted);

            }
            else if (Character.isLowerCase(character)) {

                char decrypted = (char) (((character - 'a' - shift + 26) % 26) + 'a');
                result.append(decrypted);

            }
            else {

                result.append(character);

            }
        }

        return result.toString();
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("===== Caesar Cipher Encryption System =====");


        System.out.print("Enter message: ");
        String message = scanner.nextLine();


        System.out.print("Enter shift key: ");
        int shift = scanner.nextInt();


        String encryptedText = encrypt(message, shift);

        String decryptedText = decrypt(encryptedText, shift);


        System.out.println("\nOriginal Message:");
        System.out.println(message);


        System.out.println("\nEncrypted Message:");
        System.out.println(encryptedText);


        System.out.println("\nDecrypted Message:");
        System.out.println(decryptedText);


        scanner.close();
    }
}