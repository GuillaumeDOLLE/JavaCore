package javacore.chapter05.object.project;

import java.util.Map;
import java.util.Scanner;

public class SubstitutionCipher {

    String alphabet;
    String substitutionAlphabet;

    public SubstitutionCipher(String alphabet, String substitutionAlphabet) {
        this.alphabet = alphabet;
        this.substitutionAlphabet = substitutionAlphabet;
    }

    public static class PromptConfig {
        String startMessage;
        String errorMessage;
        String endMessage;
        EntryType type;
        int limitAttempts;

        public PromptConfig(String startMessage, String errorMessage, String endMessage, EntryType type, int limitAttempts) {
            this.startMessage = startMessage;
            this.errorMessage = errorMessage;
            this.endMessage = endMessage;
            this.type = type;
            this.limitAttempts = limitAttempts;

            // This instantly returns the exception from getDefaultValue because TEXT is the first type to get called
//            this.getDefaultValue();
        }

        private static PromptConfig buildConfig(PromptPreset preset) {
            return new PromptConfig(
                    preset.startMsg,
                    preset.errorMsg,
                    preset.endMsg,
                    preset.entryType,
                    preset.limitAttempts
            );
        }

        public static PromptConfig textConfig() {
            return buildConfig(PromptPreset.TEXT);
        }

        public static PromptConfig actionConfig() {
            return buildConfig(PromptPreset.ACTION);
        }

        public static PromptConfig iterationConfig() {
            return buildConfig(PromptPreset.ITERATION);
        }

        public static PromptConfig alphabetConfig() {
            return buildConfig(PromptPreset.ALPHABET);
        }

        public int getDefaultValue() {
            if (type == EntryType.ITERATION) {
                return 1;
            }
            throw new IllegalStateException("Aucune valeur par défaut pour " + type);
        }

        public boolean isValid(Object value) {
            if (this.type == EntryType.TEXT) {
                return isValidEntryText((String) value);
            }
            if (this.type == EntryType.ACTION) {
                return isValidEntryAction((String) value);
            }

            if (this.type == EntryType.ITERATION) {
                return value != null && isValidEntryIteration((Integer) value);
            }

            if (this.type == EntryType.ALPHABET) {
                return isValidAlphabet((String) value);
            }

            return false;
        }

        private enum PromptPreset {
            TEXT(
                    "Veuillez entrer un texte en minuscule : ",
                    "Ce texte est invalide, veuillez saisir un nouveau texte : ",
                    "\nVous avez épuisé toutes vos tentatives, au revoir.",
                    EntryType.TEXT,
                    5
            ),
            ACTION(
                    "Veuillez choisir l'action à effectuer (c pour chiffrement / d pour déchiffrement) : ",
                    "Cette action est invalide, veuillez saisir une nouvelle action : ",
                    "\n Vous avez épuisé toutes vos tentatives, au revoir.",
                    EntryType.ACTION,
                    5
            ),
            ITERATION(
                    "Veuillez saisir un nombre afin de connaitre le nombre d'itérations nécessaires pour votre action : ",
                    "Cette valeur est invalide, veuillez saisir une nouvelle valeur : ",
                    "\nVous avez épuisé toutes vos tentatives, le nombre d'itérations par défaut va être appliqué (1).",
                    EntryType.ITERATION,
                    5
            ),
            ALPHABET(
                    "Veuillez saisir un alphabet de substitution, veillez à entrer les 26 caractères de l'alphabet dans l'ordre que vous voulez, sans faire de doublons : ",
                    "Cet alphabet est invalide, veuillez saisir un nouvel alphabet : ",
                    "\nVous avez épuisé toutes vos tentatives, au revoir.",
                    EntryType.ALPHABET,
                    5
            );

            final String startMsg;
            final String errorMsg;
            final String endMsg;
            final EntryType entryType;
            final int limitAttempts;

            PromptPreset(String startMessage, String errorMessage, String endMessage, EntryType entryType, int limitAttempts) {
                this.startMsg = startMessage;
                this.errorMsg = errorMessage;
                this.endMsg = endMessage;
                this.entryType = entryType;
                this.limitAttempts = limitAttempts;
            }
        }
    }

    public enum EntryType {
        TEXT,
        ACTION,
        ITERATION,
        ALPHABET,
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

    public Object readValue(Scanner scan, EntryType type) {
        if (type == EntryType.TEXT) {
            return scan.nextLine().toLowerCase();
        }

        if (type == EntryType.ACTION || type == EntryType.ALPHABET) {
            return scan.nextLine().toLowerCase().trim();
        }

        if (type == EntryType.ITERATION) {
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

        return null;
    }

    public Object promptUser(Scanner scan, PromptConfig config) {
        System.out.print(config.startMessage);

        int attempts = 1;

        while (attempts <= config.limitAttempts) {
            Object value = readValue(scan, config.type);

            if (config.isValid(value)) {
                return value;
            }

            if (attempts >= config.limitAttempts) {
                System.out.print(config.endMessage);
                return config.getDefaultValue();
            }

            System.out.print(config.errorMessage);
            attempts++;
        }
        // should never happen
        return null;
    }

    public String promptUserText(Scanner scan) {
        PromptConfig config = PromptConfig.textConfig();

        return (String) promptUser(scan, config);
    }

    public String promptUserAction(Scanner scan) {
        PromptConfig config = PromptConfig.actionConfig();

        return (String) promptUser(scan, config);

    }

    public int promptUserIterations(Scanner scan) {
        PromptConfig config = PromptConfig.iterationConfig();

        return (int) promptUser(scan, config);
    }

    public String promptUserAlphabet(Scanner scan) {
        PromptConfig config = PromptConfig.alphabetConfig();

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
        SubstitutionCipher subCipher1 = new SubstitutionCipher(latinAlphabet, substitutionAlphabet);

        Scanner scanner = new Scanner(System.in);
        String userTextToEncrypt = subCipher1.promptUserText(scanner);

        String userCipherOrDecipher = subCipher1.promptUserAction(scanner);

        int userCipherIterations = subCipher1.promptUserIterations(scanner);

        subCipher1.substitutionAlphabet = subCipher1.promptUserAlphabet(scanner);

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
