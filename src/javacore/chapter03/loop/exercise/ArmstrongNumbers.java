package javacore.chapter03.loop.exercise;

public class ArmstrongNumbers {

    public static void main(String[] args) {

        int countArmstrongNumber = 0;
        // loop through all numbers
        for (int cPotentialArmstrongNumber = 1 ; countArmstrongNumber < 10 ; cPotentialArmstrongNumber++) {

            // Armstrong calc result
            int sumArmstrong = 0;
            // To count Digits for each number
            int countDigits = 0;

            // Count digits loop
            for (int tempCopyNumber = cPotentialArmstrongNumber ; tempCopyNumber > 0 ; countDigits++) {
                tempCopyNumber /= 10;
            }

            // To browse each digit
            for (int tempCopyNumber = cPotentialArmstrongNumber ; tempCopyNumber > 0 ; tempCopyNumber /= 10 ) {
                int digit = tempCopyNumber % 10;
                sumArmstrong += (int) Math.pow(digit, countDigits);
            }

            if (sumArmstrong == cPotentialArmstrongNumber) {
                countArmstrongNumber++;
                System.out.println(cPotentialArmstrongNumber + " is an Armstrong number");
            }

        }

    }

}
