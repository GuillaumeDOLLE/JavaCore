package javacore.chapter03.loop.exercise;

public class MultiplicationTables {

    public static void main(String[] args) {

        int multiply = 10;

        for (int table = 1 ; table < multiply ; table++ ) {

            System.out.print("Table de " + table + " : ");

            for (int count = 1 ; count <= multiply ; count++) {

                if (table == 1) {
                    int result = table * count;
                    System.out.print(result + " ");

                }
                if (table == 2) {
                    int result = table * count;
                    System.out.print(result + " ");
                }
                if (table == 3) {
                    int result = table * count;
                    System.out.print(result + " ");
                }
                if (table == 4) {
                    int result = table * count;
                    System.out.print(result + " ");
                }
                if (table == 5) {
                    int result = table * count;
                    System.out.print(result + " ");
                }
                if (table == 6) {
                    int result = table * count;
                    System.out.print(result + " ");
                }
                if (table == 7) {
                    int result = table * count;
                    System.out.print(result + " ");
                }
                if (table == 8) {
                    int result = table * count;
                    System.out.print(result + " ");
                }
                if (table == 9) {
                    int result = table * count;
                    System.out.print(result + " ");
                }
            }

            System.out.println();

        }

    }

}
