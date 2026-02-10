package javacore.chapter02.condition.exercise;

public class MaxOfThree {

    public static void main(String[] args) {

        int a = 3;
        int b = 22;
        int c = 111;

        if (a > b && a > c) {
            System.out.println("a est plus grand que b et c");
        } else if (b > a && b > c) {
            System.out.println("b est plus grand que a et c");
        } else {
            System.out.println("c est plus grand que a et b");
        }
    }
}
