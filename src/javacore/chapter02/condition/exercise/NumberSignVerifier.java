package javacore.chapter02.condition.exercise;

public class NumberSignVerifier {

    public static void main(String[] args) {

        double number = 0;

        if (number > 0) {
            System.out.println("La valeur de " + number + " est positive");
        }
        else if (number < 0) {
            System.out.println("La valeur de " + number + " est négative");
        }
        else {
            System.out.println("La valeur de " + number + " est neutre");
        }

        // Bonus 1 : Je n'ai pas besoin de changer mes conditions, les chiffres après la virgule sont bien pris en
        // compte dans tous les cas même si le 0 dans mon if n'est pas initialisé comme étant un double.

        // Bonus 2
        if (number > 0) {
            System.out.println("La valeur de " + number + " est positive");
        }
        else if (number < 0) {
            System.out.println("La valeur de " + number + " est négative");
        }
        else if (number == 0) {
            System.out.println("La valeur de " + number + " est neutre");
        }
    }

}
