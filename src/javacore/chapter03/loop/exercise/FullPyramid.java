package javacore.chapter03.loop.exercise;

public class FullPyramid {

    public static void main(String[] args) {

        int numberOfRows = 12;

        for (int currentRow = 1; currentRow <= numberOfRows ; currentRow++) {

            for (int numberOfSpace = numberOfRows - currentRow ; numberOfSpace > 0 ; numberOfSpace--) {
                System.out.print(" ");
            }
            for (int numberOfAsterisk = 1 ; numberOfAsterisk <= 2 * currentRow - 1; numberOfAsterisk++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}

