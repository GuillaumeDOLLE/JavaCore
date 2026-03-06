package javacore.chapter04.function.exercise.project.refactor;

public class ArmstrongNumbersFunctionRefactor {



    public static int countDigits(int number, int countDigits) {
        for (int tempCopyNumber = number ; tempCopyNumber > 0 ; countDigits++) {
            tempCopyNumber /= 10;
        }
        return countDigits;
    }

    public static int browseDigit(int number, int countDigits, int sumArmstrong) {
        for (int tempCopyNumber = number ; tempCopyNumber > 0 ; tempCopyNumber /= 10 ) {
            int digit = tempCopyNumber % 10;
            sumArmstrong += (int) Math.pow(digit, countDigits);
        }
        return sumArmstrong;
    }

    public static void main(String[] args) {

        int countArmstrongNumber = 0;
        // loop through all numbers
        for (int cPotentialArmstrongNumber = 1 ; countArmstrongNumber < 10 ; cPotentialArmstrongNumber++) {

            // Armstrong calc result
            int sumArmstrong = 0;
            // To count Digits for each number
            int countDigits = 0;

            // Count digits loop
            countDigits += countDigits(cPotentialArmstrongNumber, countDigits);

            // To browse each digit
            sumArmstrong += browseDigit(cPotentialArmstrongNumber, countDigits, sumArmstrong);

            if (sumArmstrong == cPotentialArmstrongNumber) {
                countArmstrongNumber++;
                System.out.println(cPotentialArmstrongNumber + " is an Armstrong number");
            }

        }

    }

}
