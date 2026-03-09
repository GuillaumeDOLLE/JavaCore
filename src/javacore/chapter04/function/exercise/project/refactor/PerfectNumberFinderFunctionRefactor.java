package javacore.chapter04.function.exercise.project.refactor;

public class PerfectNumberFinderFunctionRefactor {

    public static void displayPerfectNumber(int cPotentialPerfectNumber) {
        System.out.printf("%d is a perfect number.%n", cPotentialPerfectNumber);
    }

    public static boolean isPerfectNumber(int cPotentialPerfectNumber) {
        int sumDivisors = 0;

        for (int PotentialDivisor = 1; PotentialDivisor < cPotentialPerfectNumber && sumDivisors <= cPotentialPerfectNumber; PotentialDivisor++) {
            if (cPotentialPerfectNumber % PotentialDivisor == 0) {
                sumDivisors += PotentialDivisor;
            }
        }

        return sumDivisors == cPotentialPerfectNumber;
    }

    public static void main(String[] args) {

        int start = 2;
        int end = 100000;
        int foundPerfectNumber = 0;

        for (int cPotentialPerfectNumber = start; cPotentialPerfectNumber <= end; cPotentialPerfectNumber++) {
            if (isPerfectNumber(cPotentialPerfectNumber)) {
                foundPerfectNumber++;
                displayPerfectNumber(cPotentialPerfectNumber);
            }
        }

        System.out.printf("There is %d perfect numbers between %d and %d.%n", foundPerfectNumber, start, end);
    }

}
