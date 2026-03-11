package javacore.chapter04.function.exercise.project.refactor;

public class PerfectNumberFinderFunctionRefactor {

    public static boolean isPerfectNumber(int potentialPerfectNumber) {
        int sumDivisors = 0;

        for (int potentialDivisor = 1; potentialDivisor < potentialPerfectNumber && sumDivisors <= potentialPerfectNumber; potentialDivisor++) {
            if (potentialPerfectNumber % potentialDivisor == 0) {
                sumDivisors += potentialDivisor;
            }
        }

        return sumDivisors == potentialPerfectNumber;
    }

    public static void main(String[] args) {

        int start = 2;
        int end = 100000;
        int foundPerfectNumber = 0;

        for (int cPotentialPerfectNumber = start; cPotentialPerfectNumber <= end; cPotentialPerfectNumber++) {
            if (isPerfectNumber(cPotentialPerfectNumber)) {
                foundPerfectNumber++;
                System.out.printf("%d is a perfect number.%n", cPotentialPerfectNumber);
            }
        }

        System.out.printf("There is %d perfect numbers between %d and %d.%n", foundPerfectNumber, start, end);
    }

}
