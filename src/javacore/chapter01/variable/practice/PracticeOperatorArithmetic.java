package javacore.chapter01.variable.practice;

public class PracticeOperatorArithmetic {

    public static void main(String[] args) {

        int a = 10;

        int b = 10;

        int c = a + b;

        System.out.println("Le résultat de " + a + " + " + b + " est égal à : " + c);

        int d = 10 * 3;
        int e = 10 / 5;

        System.out.println(d);
        System.out.println(e);

        int f = 3 / 2;

        System.out.println(f);

        double g = 3.0 / 2.0;
        System.out.println(g);

        double h = 3 / 2;
        System.out.println(h);

        // int i = 10 / 0;

        int j = (20 + 2) * 3;
        int k = 20 * (2 + 3);
        System.out.println(j);
        System.out.println(k);

        k += 10;
        System.out.println(k);

        k *= 10;
        System.out.println(k);

        k++;
        System.out.println(k);

        // k--;
        // k -= 1;
        k = k - 1;
        System.out.println(k);

    }

}
