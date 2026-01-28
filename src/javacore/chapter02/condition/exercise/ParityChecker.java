package javacore.chapter02.condition.exercise;

public class ParityChecker {

    public static void main(String[] args) {

        int number = 2026;
        long longNumber = 3333777799999L;

        if (number % 2 == 0) {
            System.out.println(number + " est un nombre pair");
        }
        else {
            System.out.println(number + " est un nombre impair");
        }

        if (longNumber % 2 == 0) {
            System.out.println(longNumber + " est un nombre pair");
        }
        else {
            System.out.println(longNumber + " est un nombre impair");
        }

    }

}
