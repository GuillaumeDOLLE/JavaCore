package javacore.chapter03.loop.exercise;

public class AlphabetPrinter {

    public static void main(String[] args) {

        char letter = 'A';

        while (letter <= 122) {
            System.out.printf(letter + " ");
            letter++;
        }

    }

}
