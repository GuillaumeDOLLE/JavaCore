package javacore.chapter01.variable.exercise;

public class VariablesPermutation {

    public static void main(String[] args) {

        int a = 1995;
        int b = 2000;

        int c = a;
        a = b;
        b = c;

        System.out.println(b + " est mon année de naissance, " + a + " est celle de ma soeur.");

    }

}
