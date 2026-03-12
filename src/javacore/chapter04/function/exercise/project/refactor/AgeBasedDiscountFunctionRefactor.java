package javacore.chapter04.function.exercise.project.refactor;

public class AgeBasedDiscountFunctionRefactor {

    static final double JUNIOR_DISCOUNT_RATE = 0.75;
    static final double SENIOR_DISCOUNT_RATE = 0.25;
    static final int JUNIOR_AGE_THRESHOLD = 25;
    static final int SENIOR_AGE_THRESHOLD = 65;

    public static void main(String[] args) {

        // Forfait basique : 50€
        // Jeune -25% (25 ans & moins)
        // Senior -75% (65 ans & plus)

        // 18, 25, 30, 65, 70
        int age = 70;

        // 12.5, 37.5, 50 ou (50*0.75), (50*0.25), 50
        double basePrice = 50;

        double price = getPriceBasedOnAge(age, basePrice);

        System.out.println("Client age : " + age + " -> ticket price : " + price + " euros.");
    }

    public static double getPriceBasedOnAge(int age, double basePrice) {
        if (age <= JUNIOR_AGE_THRESHOLD) return basePrice * JUNIOR_DISCOUNT_RATE; // -25%
        if (age >= SENIOR_AGE_THRESHOLD) return basePrice * SENIOR_DISCOUNT_RATE; // -75%
        return basePrice;
    }

}
