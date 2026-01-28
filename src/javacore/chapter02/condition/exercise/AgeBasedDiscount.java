package javacore.chapter02.condition.exercise;

public class AgeBasedDiscount {

    public static void main(String[] args) {

        // Forfait basique : 50€
        // Jeune -25% (25 ans & moins)
        // Senior -75% (65 ans & plus)

        // 18, 25, 30, 65, 70
        int age = 70;

        // 12.5, 37.5, 50 ou (50*0.75), (50*0.25), 50
        double price = 50;

        if (age <= 25) {
            price = price * 0.75;
            System.out.println("L'age du client est inférieur ou égal à 25, donc le prix du billet est de : " + price + " euros");
        }
        else if (age >= 65) {
            price = price * 0.25;
            System.out.println("L'age du client est supérieur ou égal à 65, donc le prix du billet est de : " + price + " euros");
        }
        else {
            System.out.println("L'age du client est strictement supérieur à 25 et strictement inférieur à 65, donc le prix du billet est de : " + price + " euros");
        }

    }

}
