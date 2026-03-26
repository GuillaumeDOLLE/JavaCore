package javacore.chapter05.object.exercise;

import java.util.Scanner;

public class PaperOrderPriceCalculator {

    public static final int SHEET_QUANTITY_MIN = 200;
    public static final int SHEET_QUANTITY_MAX = 200_000;
    public static final int FIRST_TIER_LIMIT = 0;
    public static final int SECOND_TIER_LIMIT = 10_000;
    public static final int THIRD_TIER_LIMIT = 30_000;
    public static final int FREE_SHIPPING_THRESHOLD = 200;
    public static final double SHIPPING_AMOUNT = 9.99;
    public static final double VAT_RATE = 0.2;

    public static int promptSheetQuantity(Scanner scan) {
        System.out.print("Bonjour, combien de feuilles souhaitez vous commander ? (Minimum = " + SHEET_QUANTITY_MIN + " | Maximum = " + SHEET_QUANTITY_MAX + ") : ");

        final int LIMIT_ATTEMPTS = 5;
        int attempts = 1;
        int sheetQuantity;
        boolean loopCondition;

        do {

            sheetQuantity = scan.nextInt();
            if (isValidSheetQuantity(sheetQuantity)) {
                System.out.println("Votre commande de " + sheetQuantity + " feuilles a bien été enregistré.");
                return sheetQuantity;
            }
            else {
                System.out.println("Cette valeur est invalide, veuillez saisir une valeur correcte.");
                attempts++;
                loopCondition = attempts <= LIMIT_ATTEMPTS;
                if (!loopCondition) {
                    System.out.println("Vous avez épuisé toutes vos tentatives de commandes, au revoir.");
                    sheetQuantity = -1;
                }
            }
        } while (loopCondition);

        return sheetQuantity;
    }

    public static boolean isValidSheetQuantity(int sheetQuantity) {
        return sheetQuantity >= SHEET_QUANTITY_MIN && sheetQuantity <= SHEET_QUANTITY_MAX;

    }

    public static double computeSheetsSubtotal(int sheetQuantity) {
        int remainingSheets = sheetQuantity;
        double sheetsSubtotal = 0;

        if (remainingSheets > THIRD_TIER_LIMIT) {
            int sheetsInThirdBracket = remainingSheets - THIRD_TIER_LIMIT;
            sheetsSubtotal += sheetsInThirdBracket * 0.0025;
            remainingSheets -= sheetsInThirdBracket;
        }
        if (remainingSheets > SECOND_TIER_LIMIT) {
            int sheetsInSecondBracket = remainingSheets - SECOND_TIER_LIMIT;
            sheetsSubtotal += sheetsInSecondBracket * 0.005;
            remainingSheets -= sheetsInSecondBracket;
        }
        if (remainingSheets > FIRST_TIER_LIMIT) {
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

        if (sheetQuantity > 0) {
            System.out.println("Prix de la commande hors taxe : " + finalTotalExclTax +
                    "\nPrix de la commande toute taxes comprises : " + totalInclTax);
        }

    }

}
