package javacore.chapter05.object.project;

import java.util.Scanner;

public class SubCipher {

    String alphabet;
    String substitutionAlphabet;

    public SubCipher(String alphabet, String substitutionAlphabet) {
        this.alphabet = alphabet;
        this.substitutionAlphabet = substitutionAlphabet;
    }

    public static final String CIPHER_TEXT = "c";
    public static final String DECIPHER_TEXT = "d";

    public String cipher(String textToEncrypt, String alphabet, String substitutionAlphabet, int cipherIterations) {

        for (int index = 0; index < cipherIterations; index++) {
            String tempEncryptedText = textToEncrypt;

            textToEncrypt = cipher(tempEncryptedText, alphabet, substitutionAlphabet);
        }

        return textToEncrypt;
    }

    public String cipher(String textToEncrypt, String alphabet, String substitutionAlphabet) {
        char currentChar = ' ';
        char currentSubChar = ' ';
        String currentLatinLetter = "";
        String currentSubLetter = "";
        String tempEncryptedText = textToEncrypt;

        // first encrypt
        for (int i = 0; i < alphabet.length(); i++) {
            currentChar = alphabet.charAt(i);

            currentLatinLetter = "" + currentChar;

            tempEncryptedText = tempEncryptedText.replaceAll(currentLatinLetter, "_" + i + "_");

        }

        String textEncrypted = tempEncryptedText;

        // second encrypt to exclude overlapping replacements
        for (int i = 0; i < substitutionAlphabet.length(); i++) {
            currentSubChar = substitutionAlphabet.charAt(i);

            currentSubLetter = "" + currentSubChar;

            textEncrypted = textEncrypted.replaceAll("_" + i + "_", currentSubLetter);
        }

        textToEncrypt = textEncrypted;
        return textToEncrypt;
    }


    public static void main(String[] args) {

        /**
         * Alphabet Standard (Latin)
         */
        String latinAlphabet = "abcdefghijklmnopqrstuvwxyz";

        /**
         *  Alphabet de Substitution
         */
        String substitutionAlphabet = "ntrhwbgeyjzlsoaqdmcuvfpxik";

        /**
         *  Texte à chiffrer
         */
        String textToEncrypt = "ce message secret ne doit pas arriver entre de mauvaises mains !";

        // Ecrivez le code ci-dessous
        SubCipher subCipher1 = new SubCipher(latinAlphabet, substitutionAlphabet);

        Scanner scanner = new Scanner(System.in);

        String userTextToEncrypt = PromptService.prompt(scanner, PromptFactory.createPrompt(PromptConfig.EntryType.TEXT));

        String userCipherOrDecipher = PromptService.prompt(scanner, PromptFactory.createPrompt(PromptConfig.EntryType.ACTION));

        int userCipherIterations = PromptService.prompt(scanner, PromptFactory.createPrompt(PromptConfig.EntryType.ITERATION));

        subCipher1.substitutionAlphabet = PromptService.prompt(scanner, PromptFactory.createPrompt(PromptConfig.EntryType.ALPHABET));

        String alphabet = "";
        String subAlphabet = "";

        if (userCipherOrDecipher.equals(CIPHER_TEXT)) {
            alphabet = subCipher1.alphabet;
            subAlphabet = subCipher1.substitutionAlphabet;
        }
        else if (userCipherOrDecipher.equals(DECIPHER_TEXT)){
            // Decipher = cipher while swapping order of the two alphabet
            alphabet = subCipher1.substitutionAlphabet;
            subAlphabet = subCipher1.alphabet;
        }
        else {
            System.err.print("Cette action n'est pas prévue par le programme.");
        }

        String userTextCrypted = subCipher1.cipher(userTextToEncrypt, alphabet, subAlphabet, userCipherIterations);
        System.out.println("Voici le texte \"" + userTextToEncrypt + "\" chiffré : " + userTextCrypted);

    }

}
