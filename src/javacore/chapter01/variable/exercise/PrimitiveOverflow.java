package javacore.chapter01.variable.exercise;

public class PrimitiveOverflow {

    public static void main(String[] args) {

        System.out.println("1. ----------");

        short hourSeconds = 3600;
        System.out.println("Nombre de secondes dans une heure :" + ' ' + hourSeconds);

        System.out.println("2. ----------");
        int daySeconds = hourSeconds * 24;
        System.out.println("Nombre de secondes dans un jour :" + ' ' + daySeconds);

        System.out.println("3. ----------");
        int weekSeconds = daySeconds * 7;
        System.out.println("Nombre de secondes dans une semaine :" + ' ' + weekSeconds);

        System.out.println("4. ----------");
        int monthSeconds = daySeconds * 30;
        System.out.println("Nombre de secondes dans un mois :" + ' ' + monthSeconds);

        System.out.println("5. ----------");
        int yearSeconds = daySeconds * 365;
        System.out.println("Nombre de secondes dans une annee :" + ' ' + yearSeconds);
    }

}
