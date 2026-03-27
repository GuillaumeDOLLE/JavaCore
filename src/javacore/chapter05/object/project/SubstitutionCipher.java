package javacore.chapter05.object.project;

import java.util.Scanner;

public class SubstitutionCipher {

    public static class PromptConfig {
        String startMessage;
        String errorMessage;
        String endMessage;
        String type;
        Object defaultValue;

        public PromptConfig(String startMessage, String errorMessage, String endMessage, String type, Object defaultValue) {
            this.startMessage = startMessage;
            this.errorMessage = errorMessage;
            this.endMessage = endMessage;
            this.type = type;
            this.defaultValue = defaultValue;
        }
    }

    public static final String CIPHER_TEXT = "c";
    public static final String DECIPHER_TEXT = "d";

    public static final String TEXT = "text";
    public static final String ACTION = "action";
    public static final String ITERATION = "iteration";
    public static final String ALPHABET = "alphabet";

    public static final int ALPHABET_LENGTH = 26;

    public static final int LIMIT_ATTEMPTS = 5;

    public static String cipher(String textToEncrypt, String alphabet, String substitutionAlphabet, int cipherIterations) {

        for (int index = 0; index < cipherIterations; index++) {
            String tempEncryptedText = textToEncrypt;

            textToEncrypt = cipher(tempEncryptedText, alphabet, substitutionAlphabet);
        }

        return textToEncrypt;
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

    public static Object promptUser(Scanner scan, PromptConfig config) {
        System.out.print(config.startMessage);

        int attempts = 1;

        while (attempts <= LIMIT_ATTEMPTS) {
            Object value = readValue(scan, config.type);

            if (isValid(value, config.type)) {
                return value;
            }

            if (attempts == LIMIT_ATTEMPTS) {
                System.out.print(config.endMessage);
                return config.defaultValue;
            }

            System.out.print(config.errorMessage);
            attempts++;
        }

        return config.defaultValue;
    }

    public static Object readValue(Scanner scan, String type) {
        if (type.equals(TEXT)) {
            return scan.nextLine().toLowerCase();
        }

        if (type.equals(ACTION)) {
            return scan.nextLine().toLowerCase().trim();
        }

        if (type.equals(ITERATION)) {
            // has to be an integer
            if (scan.hasNextInt()) {
                int value = scan.nextInt();
                // empty the buffer before returning the integer
                scan.nextLine();
                return value;
            }
            else {
                // empty the buffer if the user types whatever but an integer
                scan.nextLine();
                // null to tell invalid entry
                return null;
            }
        }

        if (type.equals(ALPHABET)) {
            return scan.nextLine().toLowerCase().trim();
        }

        return null;
    }

    public static boolean isValid(Object value, String type) {
        if (type.equals(TEXT)) {
            return isValidEntryText((String) value);
        }

        if (type.equals(ACTION)) {
            return isValidEntryAction((String) value);
        }

        if (type.equals(ITERATION)) {
            if (value == null) {
                return false;
            }
            return isValidEntryIteration((int) value);
        }

        if (type.equals(ALPHABET)) {
            return isValidAlphabet((String) value);
        }

        return false;
    }

    public static String promptUserText(Scanner scan) {
        PromptConfig config = new PromptConfig(
                "Veuillez entrer un texte en minuscule : ",
                "Ce texte est invalide, veuillez saisir un nouveau texte : ",
                "\nVous avez épuisé toutes vos tentatives, au revoir.",
                TEXT,
                null
        );

        return (String) promptUser(scan, config);
    }

    public static String promptUserAction(Scanner scan) {
        PromptConfig config = new PromptConfig(
                "Veuillez choisir l'action à effectuer (c pour chiffrement / d pour déchiffrement) : ",
                "Cette action est invalide, veuillez saisir une nouvelle action : ",
                "\n Vous avez épuisé toutes vos tentatives, au revoir.",
                ACTION,
                ""
        );

        return (String) promptUser(scan, config);

    }

    public static int promptUserIterations(Scanner scan) {
        PromptConfig config = new PromptConfig(
                "Veuillez saisir un nombre afin de connaitre le nombre d'itérations nécessaires pour votre action : ",
                "Cette valeur est invalide, veuillez saisir une nouvelle valeur : ",
                "\nVous avez épuisé toutes vos tentatives, le nombre d'itérations par défaut va être appliqué (1).",
                ITERATION,
                1
        );

        return (int) promptUser(scan, config);
    }

    public static String promptUserAlphabet(Scanner scan) {
        PromptConfig config = new PromptConfig(
                "Veuillez saisir un alphabet de substitution, veillez à entrer les 26 caractères" +
                        " de l'alphabet dans l'ordre que vous voulez, sans faire de doublons : ",
                "Cet alphabet est invalide, veuillez saisir un nouvel alphabet : ",
                "\nVous avez épuisé toutes vos tentatives, au revoir.",
                ALPHABET,
                ""
        );

        return (String) promptUser(scan, config);

    }

    public static boolean isValidEntryText(String userText) {
        return userText.matches("[a-zA-Z ]*");
    }

    public static boolean isValidEntryAction(String userAction) {
        return userAction.equals(CIPHER_TEXT) || userAction.equals(DECIPHER_TEXT);
    }

    public static boolean isValidEntryIteration(int userIteration) {
        return userIteration > 0;
    }

    public static boolean isValidAlphabet(String userAlphabet) {

        // check length and only letters in lower case
        if (!userAlphabet.matches("[a-z]{26}")) return false;

        for (int i = 0; i < userAlphabet.length(); i++) {
            char currentChar = userAlphabet.charAt(i);
            // check duplicate with index
            int potentialDuplicateIndex = userAlphabet.indexOf(currentChar, i + 1);
            if (potentialDuplicateIndex != -1) {
                // duplicate found
                return false;
            }
        }

        return true;
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

        String userSubstitutionAlphabet = promptUserAlphabet(scanner);


        if (userEntryAction.equals(CIPHER_TEXT)) {
            String userTextEncrypted = cipher(userEntryText, latinAlphabet, userSubstitutionAlphabet, userEntryIterations);
            System.out.println(userTextEncrypted);
        }
        else if (userEntryAction.equals(DECIPHER_TEXT)){
            // Decipher = cipher while swapping order of the two alphabet
            String userTextDecrypted = cipher(userEntryText, userSubstitutionAlphabet, latinAlphabet, userEntryIterations);
            System.out.println(userTextDecrypted);
        }
        else {
            System.err.print("Cette action n'est pas prévue par le programme.");
        }

    }

}
