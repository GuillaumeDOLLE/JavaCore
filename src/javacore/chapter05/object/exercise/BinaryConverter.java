package javacore.chapter05.object.exercise;

import java.math.BigInteger;

public class BinaryConverter {

    public static void main(String[] args) {

        String binaryText = "1011001010110111101011001001011010101001011111010111001010101101";
        BigInteger result = BigInteger.valueOf(0);
        int index = 0;
        for (int indexToPow = binaryText.length() - 1; indexToPow >= 0; indexToPow--) {
            char c = binaryText.charAt(index);

            BigInteger n = BigInteger.valueOf(Integer.parseInt(String.valueOf(c)));

            result = result.add(n.multiply(BigInteger.valueOf(2).pow(indexToPow)));
            index++;
        }

        System.out.println("binaryText (" + binaryText + ") in decimal is equal to : " + result);


        // 3. Je vérifie grâce à un convertisseur avec une recherche internet, ou alors je peux utiliser la méthode interdite pour vérifier.

        // La méthode interdite ne fonctionne pas avec BigInteger.

        // J'avais un problème de cast (long) sur mon Math.pow qui me retirait 1 sur mon result car je dépassais la valeur maximale d'un nombre long
        // J'avais aussi indexToPow > 0 et non pas égal donc je perdais 1 sur le dernier bit.

    }

}
