package javacore.chapter05.object.project;

public class SubstitutionCipher {

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
        char currentChar = ' ';
        char currentSubChar = ' ';

        String textEncrypted = "";

        // loop text
        for (int textIndex = 0; textIndex < textToEncrypt.length(); textIndex++) {
            // find each char
            currentChar = textToEncrypt.charAt(textIndex);

            if (currentChar == ' ' || currentChar == '!') {
                currentSubChar = currentChar;
            }
            else {
                int currentCharIndex = 0;
                // find char index from latin alphabet
                currentCharIndex = latinAlphabet.indexOf(currentChar);
                // find sub char with latin alphabet index
                currentSubChar = substitutionAlphabet.charAt(currentCharIndex);
            }
            // Rebuilding of the text from each substitution char
            textEncrypted += currentSubChar;
        }

        System.out.println("Final encrypted text : " + textEncrypted);
    }

}
