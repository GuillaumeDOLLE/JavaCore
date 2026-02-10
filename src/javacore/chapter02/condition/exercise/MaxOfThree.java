package javacore.chapter02.condition.exercise;

public class MaxOfThree {

    public static void main(String[] args) {

        int a = 333;
        int b = 403;
        int c = 33;

        if (a == b || a == c || b == c) {
            if (a == b && b == c) {
                System.err.println("Toutes les valeurs sont égales, il n'y en a pas une plus grande que les autres.");
            }
            else if (a == b) {
                System.err.println("Les valeurs de a et b sont égales.");
            }
            else if (b == c) {
                System.err.println("Les valeurs de b et c sont égales.");
            }
            else {
                System.err.println("Les valeurs de a et c sont égales.");
            }
        }
        else if (a > b && a > c) {
            System.out.println("a est plus grand que b et c");
        }
        else if (b > a && b > c) {
            System.out.println("b est plus grand que a et c");
        }
        else {
            System.out.println("c est plus grand que a et b");
        }
    }
}
