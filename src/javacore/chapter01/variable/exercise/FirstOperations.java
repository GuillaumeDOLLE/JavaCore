package javacore.chapter01.variable.exercise;

public class FirstOperations {

    public static void main(String[] args) {

        System.out.println("N°1 -------------");
        int a = 15;
        int b = 7;

        int sum = a + b;
        System.out.println("La somme de a et b est egale a : " + sum);

        int subtraction = a - b;
        System.out.println("La soustraction de b à a est egale a : " + subtraction);

        int multiplication = a * b;
        System.out.println("La multiplication de a et b est egale a : " + multiplication);

        int division = a / b;
        System.out.println("La division de b à a est egale a : " + division);

        int modulo = a % b;
        System.out.println("Le reste de la division de b à a est de : "+ modulo);

        System.out.println("N°2 -------------");

        int c = 30;
        int d = 26;
        c += d;
        System.out.println("c = " + c);
        d -= 5; // d = d - 5;
        System.out.println("d = " + d);
        c *= 3; // c = c * 3;
        System.out.println("c = " + c);
        d /= 3; // d = d / 3;
        System.out.println("d = " + d);

        System.out.println("N°3 -------------");

        int e = 1 * 5 + 2;
        System.out.println("e = " + e);

        int f = 1 * (5 + 2);
        System.out.println("f = " + f);

        int g = ((2 * 5) - 2 / (4 - 2)) - 1;
        System.out.println("g = " + g);

    }

}
