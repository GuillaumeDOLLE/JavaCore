package javacore.chapter03.loop.exercise;

public class MultiplicationTables {

    public static void main(String[] args) {

        int multiply = 10;

        for (int table = 1 ; table < multiply ; table++ ) {

            System.out.print("Table de " + table + " : ");

            for (int count = 1 ; count <= multiply ; count++) {
                    int result = table * count;
                    System.out.print(result + " ");
            }

            System.out.println();

        }

    }

}
