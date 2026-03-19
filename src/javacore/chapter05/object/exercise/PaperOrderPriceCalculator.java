package javacore.chapter05.object.exercise;

import java.util.Scanner;

public class PaperOrderPriceCalculator {

    public static void main(String[] args) {

        final int MIDDLE_TIER_LIMIT = 10_000;
        final int HIGH_TIER_LIMIT = 30_000;
        final int FREE_SHIPPING_THRESHOLD = 200;
        final double SHIPPING_AMOUNT = 9.99;
        final double VAT_RATE = 0.2;

        int sheetQuantity;
        int amountPaperOrderMin = 200;
        int amountPaperOrderMax = 200_000;

        double totalExclTax = 0;
        double totalInclTax = 0;

        Scanner scan = new Scanner(System.in);

        // 10 000 feuilles à 0.01€
        // 10 001 à 30 000 0.005€
        // 30 001 et + 0.0025€
        // Min 200 Max 200 000
        // TVA 20%
        // Frais livraison 9.99€ si < 200€ de commande

        System.out.print("Bonjour, combien de feuilles souhaitez vous commander ? (Minimum = 200 | Maximum = 200000) : ");

        do {
            sheetQuantity = scan.nextInt();
            if (sheetQuantity < amountPaperOrderMin || sheetQuantity > amountPaperOrderMax) {
                System.out.println("Cette valeur est invalide, veuillez saisir une valeur correcte.");
            }

        } while (amountPaperOrderMin > sheetQuantity || sheetQuantity > amountPaperOrderMax);

        System.out.println("Votre commande de " + sheetQuantity + " feuilles a bien été enregistré.");

        scan.close();

        int remainingSheets = sheetQuantity;

        if (remainingSheets > HIGH_TIER_LIMIT) {
            int sheetsInHighestBracket = sheetQuantity - HIGH_TIER_LIMIT;
            totalExclTax += sheetsInHighestBracket * 0.0025;
            remainingSheets -= sheetsInHighestBracket;
        }
        if (remainingSheets > MIDDLE_TIER_LIMIT) {
            int sheetsInMiddleBracket = remainingSheets - MIDDLE_TIER_LIMIT;
            totalExclTax += sheetsInMiddleBracket * 0.005;
            remainingSheets -= sheetsInMiddleBracket;
        }
        if (remainingSheets <= MIDDLE_TIER_LIMIT) {
            totalExclTax += remainingSheets * 0.01;
        }

        if (totalExclTax < FREE_SHIPPING_THRESHOLD) {
            totalExclTax += SHIPPING_AMOUNT;
        }

        double taxAmount = totalExclTax * VAT_RATE;
        totalInclTax = totalExclTax + taxAmount;

        System.out.println("Prix de la commande hors taxe : " + totalExclTax +
                "\nPrix de la commande toute taxes comprises : " + totalInclTax);

    }

}
