package javacore.chapter03.loop.exercise;

public class AlphabetPrinter {

    public static void main(String[] args) {

        char letter = 'A';

        // 122 is the 'z' char unicode
        while (letter <= 122) {

            // 97 is the 'a' char unicode
            if (letter >= 97) {
                System.out.printf(letter + " ");
            }
            letter++;
        }

    }

}
