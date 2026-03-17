package javacore.chapter04.function.exercise;

public class RecursiveFunction {

    public static void getNumbers(int number, final int MAX_NUMBER) {
        if (number < MAX_NUMBER) {
            number++;
            System.out.println(number);
            getNumbers(number, MAX_NUMBER);
        }
        return;
    }

    public static void main(String[] args) {
        final int MAX_NUMBER = 10_000;
        int number = 0;
        getNumbers(number, MAX_NUMBER);
    }

}
