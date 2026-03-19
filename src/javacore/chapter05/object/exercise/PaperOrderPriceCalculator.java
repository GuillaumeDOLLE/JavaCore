package javacore.chapter05.object.exercise;

import java.util.Scanner;

public class PaperOrderPriceCalculator {

    public static void main(String[] args) {

        int sheetQuantity;
        int amountPaperOrderMin = 200;
        int amountPaperOrderMax = 200_000;

        double price = 0;

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

        if (remainingSheets > 30_000) {
            int sheetsInHighestBracket = sheetQuantity - 30_000;
            price += sheetsInHighestBracket * 0.0025;
            remainingSheets -= sheetsInHighestBracket;
        }
        if (remainingSheets > 10_000) {
            int sheetsInMiddleBracket = remainingSheets - 10_000;
            price += sheetsInMiddleBracket * 0.005;
            remainingSheets -= sheetsInMiddleBracket;
        }
        if (remainingSheets <= 10_000) {
            price += remainingSheets * 0.01;
        }

        System.out.println("Prix de la commande : " + price);

    }

}
