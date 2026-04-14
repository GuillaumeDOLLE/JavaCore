package javacore.chapter05.object.project;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public abstract class PromptConfig<T> {
    String startMessage;
    String errorMessage;
    String endMessage;
    int limitAttempts;

    protected PromptConfig(String startMessage, String errorMessage, String endMessage, int limitAttempts) {
        this.startMessage = startMessage;
        this.errorMessage = errorMessage;
        this.endMessage = endMessage;
        this.limitAttempts = limitAttempts;
    }

    public abstract T readValue(Scanner scanner);
    public abstract boolean isValid(T value);
    public final boolean hasDefaultValue() {
        try {
            getDefaultValue();
        } catch (IllegalStateException err) {
            return false;
        }
        return true;
    }
    public T getDefaultValue() {
        throw new IllegalStateException("Aucune valeur par défaut pour ce type");
    };

    static class PromptConfigText extends PromptConfig<String> {

        static final String START_MESSAGE = "Veuillez entrer un texte en minuscule : ";
        static final String ERROR_MESSAGE = "Ce texte est invalide, veuillez saisir un nouveau texte : ";
        static final String END_MESSAGE = "Vous avez épuisé toutes vos tentatives, au revoir.";
        static final int LIMIT_ATTEMPTS = 5;

        PromptConfigText() {
            super(START_MESSAGE, ERROR_MESSAGE, END_MESSAGE, LIMIT_ATTEMPTS);
        }

        @Override
        public String readValue(Scanner scan) {
            return scan.nextLine().toLowerCase();
        }
        
        @Override
        public boolean isValid(String value) {
            return value.matches("[a-z ]*");
        }

    }

    static class PromptConfigAction extends PromptConfig<String> {

        static final String START_MESSAGE = "Veuillez choisir l'action à effectuer (c pour chiffrement / d pour déchiffrement) : ";
        static final String ERROR_MESSAGE = "Cette action est invalide, veuillez saisir une nouvelle action : ";
        static final String END_MESSAGE = "Vous avez épuisé toutes vos tentatives, au revoir.";
        static final int LIMIT_ATTEMPTS = 5;

        PromptConfigAction() {
            super(START_MESSAGE, ERROR_MESSAGE, END_MESSAGE, LIMIT_ATTEMPTS);
        }

        @Override
        public String readValue(Scanner scan) {
            return scan.nextLine().toLowerCase().trim();
        }
        
        @Override
        public boolean isValid(String value) {
            return value.equals(SubCipher.CIPHER_TEXT) || value.equals(SubCipher.DECIPHER_TEXT);
        }

    }

    static class PromptConfigIteration extends PromptConfig<Integer> {

        static final String START_MESSAGE = "Veuillez saisir un nombre afin de connaitre le nombre d'itérations nécessaires pour votre action : ";
        static final String ERROR_MESSAGE = "Cette valeur est invalide, veuillez saisir une nouvelle valeur : ";
        static final String END_MESSAGE = "Vous avez épuisé toutes vos tentatives, le nombre d'itérations par défaut va être appliqué (1).";
        static final int LIMIT_ATTEMPTS = 5;

        PromptConfigIteration() {
            super(START_MESSAGE, ERROR_MESSAGE, END_MESSAGE, LIMIT_ATTEMPTS);
        }

        @Override
        public Integer readValue(Scanner scan) {
            try {
                String value = scan.nextLine().trim();
                return parseInt(value);
            }
            catch (NumberFormatException e) {
                return null;
            }
        }
        
        @Override
        public boolean isValid(Integer value) {
            return value != null && value > 0;
        }

        @Override
        public Integer getDefaultValue() {
            return 1;
        }
    }

    static class PromptConfigAlphabet extends PromptConfig<String> {

        static final String START_MESSAGE = "Veuillez saisir un alphabet de substitution, veillez à entrer les 26 caractères de l'alphabet dans l'ordre que vous voulez, sans faire de doublons : ";
        static final String ERROR_MESSAGE = "Cet alphabet est invalide, veuillez saisir un nouvel alphabet : ";
        static final String END_MESSAGE = "Vous avez épuisé toutes vos tentatives, au revoir.";
        static final int LIMIT_ATTEMPTS = 5;

        PromptConfigAlphabet() {
            super(START_MESSAGE, ERROR_MESSAGE, END_MESSAGE, LIMIT_ATTEMPTS);
        }
        
        @Override
        public String readValue(Scanner scan) {
            return scan.nextLine().toLowerCase().trim();
        }

        @Override
        public boolean isValid(String value) {
            if (!value.matches("[a-z]{26}")) return false;

            for (int i = 0; i < value.length(); i++) {
                char currentChar = value.charAt(i);
                // check duplicate with index
                int potentialDuplicateIndex = value.indexOf(currentChar, i + 1);
                if (potentialDuplicateIndex != -1) {
                    // duplicate found
                    return false;
                }
            }

            return true;
        }

    }

    public enum EntryType {
        TEXT,
        ACTION,
        ITERATION,
        ALPHABET
    }
    
}
