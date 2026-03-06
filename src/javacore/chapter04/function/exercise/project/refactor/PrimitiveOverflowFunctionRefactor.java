package javacore.chapter04.function.exercise.project.refactor;

public class PrimitiveOverflowFunctionRefactor {

    public static void main(String[] args) {

        short hourSeconds = 3600;
        displaySecondsMessage(1, "Nombre de secondes dans une heure :", hourSeconds);

        int daySeconds = hourSeconds * 24;
        displaySecondsMessage(2, "Nombre de secondes dans un jour :", daySeconds);

        int weekSeconds = daySeconds * 7;
        displaySecondsMessage(3, "Nombre de secondes dans une semaine :", weekSeconds);

        int monthSeconds = daySeconds * 30;
        displaySecondsMessage(4, "Nombre de secondes dans un mois :", monthSeconds);

        int yearSeconds = daySeconds * 365;
        displaySecondsMessage(5, "Nombre de secondes dans une année :", yearSeconds);
    }

    public static void displaySecondsMessage(int number, String message, int value) {
        System.out.println(number + ". ----------");
        System.out.println(message + " " + value);
    }

}
