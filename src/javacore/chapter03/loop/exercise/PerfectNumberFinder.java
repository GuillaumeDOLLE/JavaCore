package javacore.chapter03.loop.exercise;

public class PerfectNumberFinder {

    public static void main(String[] args) {

        int start = 2;
        int end = 100000;
        int foundPerfectNumber = 0;

        for (int currentNumber = start ; currentNumber <= end ; currentNumber++) {

            // addition of all divisor for the currentNumber
            int sumDivisors = 0;

            // in the condition of the loop, I check if sum is already higher so there is no point to continue
            for (int divisor = 1 ; divisor < currentNumber && sumDivisors <= currentNumber ; divisor++) {
                if (currentNumber % divisor == 0) {
                    sumDivisors += divisor;
                }
            }

            if (sumDivisors == currentNumber) {
                foundPerfectNumber++;
                System.out.printf("%d is a perfect number.%n", currentNumber);
            }
        }
        System.out.printf("There is %d perfect numbers between %d and %d.%n", foundPerfectNumber, start, end);
    }

}
