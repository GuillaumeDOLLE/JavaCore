package javacore.chapter05.object.exercise;

public class AlphabetVowelSearcher {

    public static void main(String[] args) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String vowels = "aeiouy";

//        for (int index = 0; index < alphabet.length(); index++) {
//            char cr = alphabet.charAt(index);
//            for (int i = 0; i < vowels.length(); i++) {
//                if (cr == vowels.charAt(i)) {
//                    System.out.println("Voyelle trouvée : " + cr + " à la position : " + index);
//                }
//
//            }
//        }

        for (int index = 0; index < alphabet.length(); index++) {
            char cr = alphabet.charAt(index);
            for (int i = 0; i < vowels.length(); i++) {
                if (cr == vowels.charAt(i)) {
                    int vowelIndex = alphabet.indexOf(cr);
                    System.out.println("Voyelle trouvée : " + cr + " à la position : " + vowelIndex);
                }
            }

        }

    }

}
