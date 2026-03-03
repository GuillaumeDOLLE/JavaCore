package javacore.chapter04.function.exercise;

public class FactorizationExercise {

    static public void main(String[] args) {

        // Afficher les nombres de 1 à 5
        displayNumbers(1, 5);

        // Afficher la table de multiplication de 2
        displayMultiplicationTable(2);

        // Afficher la table de multiplication de 3
        displayMultiplicationTable(3);

        // Afficher la table de multiplication de 6
        displayMultiplicationTable(6);

        // Afficher les carrés des nombres de 1 à 5
        displaySquareNumbers(1, 5);

        // Afficher les carrés des nombres de 6 à 10
        displaySquareNumbers(6, 10);

    }

    public static void displayNumbers(int number1, int number2) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Nombre : " + i);
        }
    }

    public static void displayMultiplicationTable(int number) {

        System.out.println("Table de multiplication de " + number + " :");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number *i));
        }

    }

    public static void displaySquareNumbers(int number1, int number2) {

        System.out.println("Carrés des nombres de " + number1 + " à " + number2);
        for (int i = number1; i <= number2; i++) {
            System.out.println(i + " au carré = " + (i * i));
        }
    }

}
