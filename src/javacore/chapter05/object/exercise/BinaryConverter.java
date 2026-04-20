package javacore.chapter05.object.exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class BinaryConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre binaire (composé uniquement de 0 et de 1, ayant maximum 64 bits) :");
        String binaryTextEntry = scanner.nextLine();
        if (isValid(binaryTextEntry)) {
            BigInteger result = convertBinaryToDecimal(binaryTextEntry);

            System.out.println("binaryText (" + binaryTextEntry + ") in decimal is equal to : " + result);
        }
        else {
            System.out.println("Ce n'était pas un nombre binaire, dommage.");
        }

        // 3. Je vérifie grâce à un convertisseur avec une recherche internet, ou alors je peux utiliser la méthode interdite pour vérifier.

        // La méthode interdite ne fonctionne pas avec BigInteger.

        // J'avais un problème de cast (long) sur mon Math.pow qui me retirait 1 sur mon result car je dépassais la valeur maximale d'un nombre long
        // J'avais aussi indexToPow > 0 et non pas égal donc je perdais 1 sur le dernier bit.



    }

    public static boolean isValid(String userBinaryTextEntry) {
        return userBinaryTextEntry.matches("[0-1]{1,64}");
    }

    public static BigInteger convertBinaryToDecimal(String binaryText) {
        BigInteger result = BigInteger.valueOf(0);
        int index = 0;
        for (int indexToPow = binaryText.length() - 1; indexToPow >= 0; indexToPow--) {
            char c = binaryText.charAt(index);

            BigInteger n = BigInteger.valueOf(Integer.parseInt(String.valueOf(c)));

            result = result.add(n.multiply(BigInteger.valueOf(2).pow(indexToPow)));
            index++;
        }

        return result;
    }

}
