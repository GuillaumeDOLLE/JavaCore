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
//
//        String textEncrypted = "";
//
//        // loop text
//        for (int textIndex = 0; textIndex < textToEncrypt.length(); textIndex++) {
//            // find each char
//            currentChar = textToEncrypt.charAt(textIndex);
//
//            if (currentChar == ' ' || currentChar == '!') {
//                currentSubChar = currentChar;
//            }
//            else {
//                int currentCharIndex = 0;
//                // find char index from latin alphabet
//                currentCharIndex = latinAlphabet.indexOf(currentChar);
//                // find sub char with latin alphabet index
//                currentSubChar = substitutionAlphabet.charAt(currentCharIndex);
//            }
//            // Rebuilding of the text from each substitution char
//            textEncrypted += currentSubChar;
//        }


        String currentLatinLetter = "";
        String currentSubLetter = "";
        String newTextToEncrypt = textToEncrypt;

        for (int i = 0; i < latinAlphabet.length(); i++) {
            currentChar = latinAlphabet.charAt(i);

            currentLatinLetter = "" + currentChar;

            newTextToEncrypt = newTextToEncrypt.replaceAll(currentLatinLetter, "_" + i + "_");

        }
        // first encrypt
        System.out.println("text encrypted : " + newTextToEncrypt);

        String textEncrypted = newTextToEncrypt;

        for (int i = 0; i < substitutionAlphabet.length(); i++) {
            currentSubChar = substitutionAlphabet.charAt(i);

            currentSubLetter = "" + currentSubChar;

            textEncrypted = textEncrypted.replaceAll("_" + i + "_", currentSubLetter);
        }

        // second encrypt to exclude overlapping replacements
        System.out.println("Final encrypted text : " + textEncrypted);
    }

}
