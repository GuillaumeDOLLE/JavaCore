package javacore.chapter03.loop.exercise;

public class MultiplicationTables {

    public static void main(String[] args) {

        int multiply = 10;

        for (int table = 1 ; table < multiply ; table++ ) {

            System.out.println("Table de " + table + " : ");

            for (int count = 1 ; count <= multiply ; count++) {

                if (table == 1) {
                    int result = table * count;
                    System.out.printf("1 * %d = %d.%n", count, result );
                }
                if (table == 2) {
                    int result = table * count;
                    System.out.printf("2 * %d = %d.%n", count, result);
                }
                if (table == 3) {
                    int result = table * count;
                    System.out.printf("3 * %d = %d.%n", count, result);
                }
                if (table == 4) {
                    int result = table * count;
                    System.out.printf("4 * %d = %d.%n", count, result);
                }
                if (table == 5) {
                    int result = table * count;
                    System.out.printf("5 * %d = %d.%n", count, result);
                }
                if (table == 6) {
                    int result = table * count;
                    System.out.printf("6 * %d = %d.%n", count, result);
                }
                if (table == 7) {
                    int result = table * count;
                    System.out.printf("7 * %d = %d.%n", count, result);
                }
                if (table == 8) {
                    int result = table * count;
                    System.out.printf("8 * %d = %d.%n", count, result);
                }
                if (table == 9) {
                    int result = table * count;
                    System.out.printf("9 * %d = %d.%n", count, result);
                }
            }


        }

    }

}
