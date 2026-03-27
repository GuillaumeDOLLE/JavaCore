package javacore.chapter05.object.project;

import java.util.Scanner;

public class SubstitutionCipher {

    public static final String CIPHER_TEXT = "chiffrement";
    public static final String DECIPHER_TEXT = "déchiffrement";

    public static String cipher(String textToEncrypt, String alphabet, String substitutionAlphabet, int cipherIterations) {

        for (int index = 0; index < cipherIterations; index++) {
            String tempEncryptedText = textToEncrypt;

            textToEncrypt = cipher(tempEncryptedText, alphabet, substitutionAlphabet);
        }

        return textToEncrypt;
    }

    public static String decipher(String textToDecrypt, String alphabet, String substitutionAlphabet, int decipherIterations) {

        for (int index = 0; index < decipherIterations; index++) {
            String tempDecryptedText = textToDecrypt;

            textToDecrypt = decipher(tempDecryptedText, alphabet, substitutionAlphabet);
        }

        return textToDecrypt;
    }

    public static String decipher(String textToDecrypt, String alphabet, String substitutionAlphabet) {
        char currentChar = ' ';
        char currentSubChar = ' ';
        String currentLatinLetter = "";
        String currentSubLetter = "";
        String tempDecryptedText = textToDecrypt;

        for (int i = 0; i < substitutionAlphabet.length(); i++) {
            currentSubChar = substitutionAlphabet.charAt(i);

            currentSubLetter = "" + currentSubChar;

            tempDecryptedText = tempDecryptedText.replaceAll(currentSubLetter, "_" + i + "_");

        }

        String textDecrypted = tempDecryptedText;

        for (int i = 0; i < alphabet.length(); i++) {
            currentChar = alphabet.charAt(i);

            currentLatinLetter = "" + currentChar;

            textDecrypted = textDecrypted.replaceAll("_" + i + "_", currentLatinLetter);
        }

        textToDecrypt = textDecrypted;
        return textToDecrypt;
    }

    public static String cipher(String textToEncrypt, String alphabet, String substitutionAlphabet) {
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

    public static String promptUserText(Scanner scan) {
        System.out.print("Veuillez entrer un texte en minuscule : ");

        final int LIMIT_ATTEMPTS = 5;
        int attempts = 1;
        String userEntryText;
        boolean loopCondition;

        do {
            userEntryText = scan.nextLine().toLowerCase();
            if (isValidEntryText(userEntryText)) {
                return userEntryText;
            }
            else {
                System.out.print("Ce texte est invalide, veuillez saisir un nouveau texte");
                attempts++;
                loopCondition = attempts <= LIMIT_ATTEMPTS;
                if (!loopCondition) {
                    System.out.print("\nVous avez épuisé toutes vos tentatives, vous ne prenez pas ça au sérieux, au revoir.");
                    userEntryText = "";
                }
            }
        } while (loopCondition);

        return userEntryText;
    }

    public static String promptUserAction(Scanner scan) {
        System.out.print("Veuillez choisir l'action à effectuer (chiffrement / déchiffrement) : ");

        final int LIMIT_ATTEMPTS = 5;
        int attempts = 1;
        String userEntryAction;
        boolean loopCondition;

        do {
            userEntryAction = scan.nextLine().toLowerCase().trim();
            if (isValidEntryAction(userEntryAction)) {
                return userEntryAction;
            }
            else {
                System.out.print("Cette action est invalide, veuillez saisir une nouvelle action : ");
                attempts++;
                loopCondition = attempts <= LIMIT_ATTEMPTS;
                if (!loopCondition) {
                    System.out.print("\nVous avez épuisé toutes vos tentatives, vous ne prenez pas ça au sérieux, au revoir.");
                    userEntryAction = "";
                }
            }
        } while (loopCondition);

        return userEntryAction;

    }

    public static int promptUserIterations(Scanner scan) {
        System.out.print("Veuillez saisir un nombre afin de connaitre le nombre d'itérations nécessaires pour votre action : ");

        final int LIMIT_ATTEMPTS = 5;
        int attempts = 1;
        int userEntryIterations;
        boolean loopCondition;

        do {
            userEntryIterations = scan.nextInt();
            if (isValidEntryIteration(userEntryIterations)) {
                return userEntryIterations;
            }
            else {
                System.out.print("Cette valeur est invalide, veuillez saisir une nouvelle valeur : ");
                attempts++;
                loopCondition = attempts <= LIMIT_ATTEMPTS;
                if (!loopCondition) {
                    System.out.print("\nVous avez épuisé toutes vos tentatives, vous ne prenez pas ça au sérieux, le nombre d'itérations par défaut va être appliqué (1).");
                    userEntryIterations = 1;
                }
            }
        } while (loopCondition);

        return userEntryIterations;
    }

    public static boolean isValidEntryText(String userText) {
        return userText.matches(".*[a-zA-Z].*");
    }

    public static boolean isValidEntryAction(String userAction) {
        return userAction.equals(CIPHER_TEXT) || userAction.equals(DECIPHER_TEXT);
    }

    public static boolean isValidEntryIteration(int userIteration) {
        return userIteration > 0;
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
        Scanner scanner = new Scanner(System.in);
        String userEntryText = promptUserText(scanner);

        String userEntryAction = promptUserAction(scanner);

        int userEntryIterations = promptUserIterations(scanner);


        if (userEntryAction.equals(CIPHER_TEXT)) {
            String userTextEncrypted = cipher(userEntryText, latinAlphabet, substitutionAlphabet, userEntryIterations);
            System.out.println(userTextEncrypted);
        }
        else if (userEntryAction.equals(DECIPHER_TEXT)){
            String userTextDecrypted = decipher(userEntryText, latinAlphabet, substitutionAlphabet, userEntryIterations);
            System.out.println(userTextDecrypted);
        }
        else {
            System.err.print("Cette action n'est pas prévue par le programme.");
        }

    }

}
