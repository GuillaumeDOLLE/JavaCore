package javacore.chapter04.function.exercise.project.refactor;

public class AgeBasedDiscountFunctionRefactor {

    public static void main(String[] args) {

        // Forfait basique : 50€
        // Jeune -25% (25 ans & moins)
        // Senior -75% (65 ans & plus)

        // 18, 25, 30, 65, 70
        int age = 70;

        // 12.5, 37.5, 50 ou (50*0.75), (50*0.25), 50
        double basePrice = 50;

        double price = calcPrice(age, basePrice);

        displayPriceMessage(age, price);
    }

    public static double calcPrice(int age, double basePrice) {
        if (age <= 25) return basePrice * 0.75; // -25%
        if (age >= 65) return basePrice * 0.25; // -75%
        return basePrice;
    }

    public static void displayPriceMessage(int age, double price) {
        System.out.println("Client age : " + age + " -> ticket price : " + price + " euros."); // Less precise than og to not have conditions
    }

}
