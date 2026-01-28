package javacore.chapter02.condition.exercise;

public class NumberComparison {

    public static void main(String[] args) {

        int number1 = 30;
        int number2 = 2026;

        if (number1 > number2) {
            System.out.println(number1);
        }
        else if (number1 < number2) {
            System.out.println(number2);
        }
        else {
            System.out.println(number1 + " et " + number2 + " ont la même valeur");
        }

    }

}
