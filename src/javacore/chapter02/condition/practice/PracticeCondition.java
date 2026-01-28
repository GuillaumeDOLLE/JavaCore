package javacore.chapter02.condition.practice;

public class PracticeCondition {

    public static void main(String[] args) {

        int age = 15;

        if ( age < 18 ) {
            System.out.println("Vous êtes mineur");
        } else if ( age == 18 ) {
            System.out.println("Vous êtes tout juste majeur");
        } else {
            System.out.println("Vous êtes majeur");
        }

        int carHorsePower = 900;

        if ( age >= 18 ) {
            System.out.println("Vous etes majeur");
        }
        else if (carHorsePower > 50) {
            System.out.println("Votre voiture est puissante");
        }
        else {
            System.out.println("Vous êtes piéton");
        }

        if ( age < 18 ) {
            System.out.println("Vous êtes mineur");
        }

        if ( age == 18 ) {
            System.out.println("Vous êtes tout juste majeur");
        }

        if ( age > 18 ) {
            System.out.println("Vous êtes majeur");
        }

    }

}
