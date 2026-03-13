package javacore.chapter04.function.exercise;

public class RecursiveFunction {

    public static void getNumbers(int number) {
        number++;
        System.out.println(number);
        if (number >= 10_000) {
            return;
        }
        getNumbers(number);
    }

    public static void main(String[] args) {
        int number = 0;
        getNumbers(number);
    }

}
