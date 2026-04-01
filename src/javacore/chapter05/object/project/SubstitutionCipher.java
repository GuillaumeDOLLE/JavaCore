package javacore.chapter05.object.project;

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
        Object defaultValue;

        public PromptConfig(String startMessage, String errorMessage, String endMessage, EntryType type, Object defaultValue) {
            this.startMessage = startMessage;
            this.errorMessage = errorMessage;
            this.endMessage = endMessage;
            this.type = type;
            this.defaultValue = defaultValue;
        }

        private static PromptConfig buildConfig(PromptPreset preset) {
            return new PromptConfig(
                    preset.startMsg,
                    preset.errorMsg,
                    preset.endMsg,
                    preset.entryType,
                    preset.defaultVal
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

        private enum PromptPreset {
            TEXT(
                    "Veuillez entrer un texte en minuscule : ",
                    "Ce texte est invalide, veuillez saisir un nouveau texte : ",
                    "\nVous avez épuisé toutes vos tentatives, au revoir.",
                    EntryType.TEXT,
                    null
            ),
            ACTION(
                    "Veuillez choisir l'action à effectuer (c pour chiffrement / d pour déchiffrement) : ",
                    "Cette action est invalide, veuillez saisir une nouvelle action : ",
                    "\n Vous avez épuisé toutes vos tentatives, au revoir.",
                    EntryType.ACTION,
                    ""
            ),
            ITERATION(
                    "Veuillez saisir un nombre afin de connaitre le nombre d'itérations nécessaires pour votre action : ",
                    "Cette valeur est invalide, veuillez saisir une nouvelle valeur : ",
                    "\nVous avez épuisé toutes vos tentatives, le nombre d'itérations par défaut va être appliqué (1).",
                    EntryType.ITERATION,
                    1
            ),
            ALPHABET(
                    "Veuillez saisir un alphabet de substitution, veillez à entrer les 26 caractères de l'alphabet dans l'ordre que vous voulez, sans faire de doublons : ",
                    "Cet alphabet est invalide, veuillez saisir un nouvel alphabet : ",
                    "\nVous avez épuisé toutes vos tentatives, au revoir.",
                    EntryType.ALPHABET,
                    ""
            );

            final String startMsg;
            final String errorMsg;
            final String endMsg;
            final EntryType entryType;
            final Object defaultVal;

            PromptPreset(String startMessage, String errorMessage, String endMessage, EntryType entryType, Object defaultValue) {
                this.startMsg = startMessage;
                this.errorMsg = errorMessage;
                this.endMsg = endMessage;
                this.entryType = entryType;
                this.defaultVal = defaultValue;

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

    public static final int LIMIT_ATTEMPTS = 5;

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

    public boolean isValid(Object value, EntryType type) {
        if (type == EntryType.TEXT) {
            return isValidEntryText((String) value);
        }

        if (type == EntryType.ACTION) {
            return isValidEntryAction((String) value);
        }

        if (type == EntryType.ITERATION) {
            return value == null ? false : isValidEntryIteration((Integer) value);
        }

        if (type == EntryType.ALPHABET) {
            return isValidAlphabet((String) value);
        }

        return false;
    }

    public Object promptUser(Scanner scan, PromptConfig config) {
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

    public boolean isValidEntryText(String userText) {
        return userText.matches("[a-zA-Z ]*");
    }

    public boolean isValidEntryAction(String userAction) {
        return userAction.equals(CIPHER_TEXT) || userAction.equals(DECIPHER_TEXT);
    }

    public boolean isValidEntryIteration(int userIteration) {
        return userIteration > 0;
    }

    public boolean isValidAlphabet(String userAlphabet) {

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
        String userEntryText = subCipher1.promptUserText(scanner);

        String userEntryAction = subCipher1.promptUserAction(scanner);

        int userEntryIterations = subCipher1.promptUserIterations(scanner);

        subCipher1.substitutionAlphabet = subCipher1.promptUserAlphabet(scanner);



        if (userEntryAction.equals(CIPHER_TEXT)) {
            String userTextEncrypted = subCipher1.cipher(userEntryText, subCipher1.alphabet, subCipher1.substitutionAlphabet, userEntryIterations);
            System.out.println("Voici le texte \"" + userEntryText + "\" chiffré : " + userTextEncrypted);
        }
        else if (userEntryAction.equals(DECIPHER_TEXT)){
            // Decipher = cipher while swapping order of the two alphabet
            String userTextDecrypted = subCipher1.cipher(userEntryText, subCipher1.substitutionAlphabet, subCipher1.alphabet, userEntryIterations);
            System.out.println("Voici le texte \"" + userEntryText + "\" déchiffré : " + userTextDecrypted);
        }
        else {
            System.err.print("Cette action n'est pas prévue par le programme.");
        }

    }

}
