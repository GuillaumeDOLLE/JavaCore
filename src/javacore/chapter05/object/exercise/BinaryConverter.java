package javacore.chapter05.object.exercise;

import java.math.BigInteger;

public class BinaryConverter {

    public static void main(String[] args) {

        String binaryText = "10110110";
        int result = 0;
        int index = 0;
        for (int indexToPow = binaryText.length() - 1; indexToPow > 0; indexToPow--) {
            char c = binaryText.charAt(index);
            double n = Integer.parseInt(String.valueOf(c));
            result += (int) (n * Math.pow(2, indexToPow));
            index++;
        }

        System.out.println("binaryText (" + binaryText + ") in decimal is equal to : " + result);


        // 3. Je vérifie grâce à un convertisseur avec une recherche internet, ou alors je peux utiliser la méthode interdite pour vérifier.
        int checkedResult = Integer.parseInt(binaryText, 2);
        System.out.println(checkedResult);

    }

}
