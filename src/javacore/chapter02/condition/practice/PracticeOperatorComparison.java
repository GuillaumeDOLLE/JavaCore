package javacore.chapter02.condition.practice;

public class PracticeOperatorComparison {

    public static void main(String[] args) {

        int a = 30;
        int b = 40;

        boolean isEqual = a == b;
        System.out.println("Est-ce que " + a + " == " + b + " : " + isEqual);

        boolean isNotEqual = a != b;
        System.out.println("Est-ce que " + a + " != " + b + " : " + isNotEqual);

        boolean isLessThan = a < b;
        System.out.println("Est-ce que " + a + " < " + b + " : " + isLessThan);

        boolean isLessThanOrEqual = a <= b;
        System.out.println("Est-ce que " + a + " <= " + b + " : " + isLessThanOrEqual);

        boolean isGreaterThan = a > b;
        System.out.println("Est-ce que " + a + " > " + b + " : " + isGreaterThan);

        boolean isGreaterThanOrEqual = a >= b;
        System.out.println("Est-ce que " + a + " >= " + b + " : " + isGreaterThanOrEqual);

        boolean priorityTest = 10 + a == 40;
        System.out.println("Test de priorité (10 + a == 40) : " + priorityTest);

        boolean isDoubleLessThanInt = 5.5 < 6;
        System.out.println("Test inter-type (5.5 < 6) : " + isDoubleLessThanInt);

    }

}
