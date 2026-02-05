package javacore.chapter02.condition.exercise;

public class ObfuscatedCodeV1 {

    public static void main(String[] args) {

        // 1 = eco, 2 = standard, 3 = premium
        final int VEHICLE_TYPE = 3;

        // price per km
        double pricePerKmEco = 0.10; // Eco
        double pricePerKmStandard = 0.20; // Standard
        double pricePerKmPremium = 0.35; // Premium

        double distance = 100; // km

        boolean deduction = true; // (I do not know why)
        double deductionRate = 0.03; // deduction rate (3%)

        // Price between distance and price per km with vehicleType condition
        double totalPrice = 0;

        if (VEHICLE_TYPE == 1) { // eco type
            totalPrice = distance * pricePerKmEco;
        }
        if (VEHICLE_TYPE == 2) { // standard type
            totalPrice = distance * pricePerKmStandard;
        }
        if (VEHICLE_TYPE == 3) { // premium type
            totalPrice = distance * pricePerKmPremium;
        }
        if (deduction) {
            totalPrice = totalPrice - (distance * deductionRate);
        }

        System.out.printf("Total price per %.3f km : " + totalPrice + "€", distance);

    }

}
