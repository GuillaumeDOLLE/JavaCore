package javacore.chapter05.object.exercise;

import java.util.Scanner;

public class PaperOrderPriceCalculator {

    public static final int SHEET_QUANTITY_MIN = 200;
    public static final int SHEET_QUANTITY_MAX = 200_000;
    public static final int MIDDLE_TIER_LIMIT = 10_000;
    public static final int HIGH_TIER_LIMIT = 30_000;
    public static final int FREE_SHIPPING_THRESHOLD = 200;
    public static final double SHIPPING_AMOUNT = 9.99;
    public static final double VAT_RATE = 0.2;

    public static int promptSheetQuantity(Scanner scan) {
        System.out.print("Bonjour, combien de feuilles souhaitez vous commander ? (Minimum = " + SHEET_QUANTITY_MIN + " | Maximum = " + SHEET_QUANTITY_MAX + ") : ");

        int attempts = 0;
        int limitAttempts = 5;
        int sheetQuantity;

        do {
            sheetQuantity = scan.nextInt();
            if (isInvalidSheetQuantity(sheetQuantity)) {
                System.out.println("Cette valeur est invalide, veuillez saisir une valeur correcte.");
            }
            attempts++;
            if (attempts >= limitAttempts) {
                System.out.println("Vous avez épuisé toutes vos tentatives de commandes, au revoir.");
                return 0;
            }
        } while (isInvalidSheetQuantity(sheetQuantity));

        System.out.println("Votre commande de " + sheetQuantity + " feuilles a bien été enregistré.");

        return sheetQuantity;
    }

    public static boolean isInvalidSheetQuantity(int sheetQuantity) {
        return sheetQuantity < SHEET_QUANTITY_MIN || sheetQuantity > SHEET_QUANTITY_MAX;

    }

    public static double computeSheetsSubtotal(int sheetQuantity) {
        int remainingSheets = sheetQuantity;
        double sheetsSubtotal = 0;

        if (remainingSheets > HIGH_TIER_LIMIT) {
            int sheetsInHighestBracket = sheetQuantity - HIGH_TIER_LIMIT;
            sheetsSubtotal += sheetsInHighestBracket * 0.0025;
            remainingSheets -= sheetsInHighestBracket;
        }
        if (remainingSheets > MIDDLE_TIER_LIMIT) {
            int sheetsInMiddleBracket = remainingSheets - MIDDLE_TIER_LIMIT;
            sheetsSubtotal += sheetsInMiddleBracket * 0.005;
        }
        if (remainingSheets <= MIDDLE_TIER_LIMIT) {
            sheetsSubtotal += remainingSheets * 0.01;
        }
        return sheetsSubtotal;
    }

    public static double applyShippingFee(double totalExclTax) {
        if (totalExclTax < FREE_SHIPPING_THRESHOLD) {
            totalExclTax += SHIPPING_AMOUNT;
        }

        return totalExclTax;
    }

    public static double applyVAT(double price) {
        double taxAmount = price * VAT_RATE;
        return price + taxAmount;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int sheetQuantity = promptSheetQuantity(scan);
        scan.close();

        double totalExclTax = computeSheetsSubtotal(sheetQuantity);

        double finalTotalExclTax = applyShippingFee(totalExclTax);

        double totalInclTax = applyVAT(finalTotalExclTax);

        if (sheetQuantity != 0) {
            System.out.println("Prix de la commande hors taxe : " + finalTotalExclTax +
                    "\nPrix de la commande toute taxes comprises : " + totalInclTax);
        }

    }

}
