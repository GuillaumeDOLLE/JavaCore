package javacore.chapter04.function.exercise.project.refactor;

public class PerfectNumberFinderFunctionRefactor {

    // TODO: refactor this
    public static int findAndAddAllDivisors(int cPotentialPerfectNumber) {
        // reset sum to 0 for each turn
        int sumDivisors = 0;
        // in the condition of the loop, I check if sum is already higher so there is no point to continue
        for (int potentialDivisor = 1 ; potentialDivisor < cPotentialPerfectNumber && sumDivisors <= cPotentialPerfectNumber ; potentialDivisor++) {
            if (cPotentialPerfectNumber % potentialDivisor == 0) {
                // Here the potentialDivisor is a real divisor, so I add it to the sum of divisors
                sumDivisors += potentialDivisor;
            }
        }
        // return sumDivisors to use it to compare it with the potentialPerfectNumber in another function
        return sumDivisors;
    }

    public static int loopThroughAllPotentialPerfectNumbers(int start, int end) {
        int foundPerfectNumber = 0;
        for (int cPotentialPerfectNumber = start ; cPotentialPerfectNumber <= end ; cPotentialPerfectNumber++) {
            int sumDivisors = findAndAddAllDivisors(cPotentialPerfectNumber);

            foundPerfectNumber = displayPerfectNumber(cPotentialPerfectNumber, sumDivisors, foundPerfectNumber);
        }
        return foundPerfectNumber;
    }

    public static int displayPerfectNumber(int cPotentialPerfectNumber, int sumDivisors, int foundPerfectNumber) {
        if (sumDivisors == cPotentialPerfectNumber) {
            foundPerfectNumber++;
            System.out.printf("%d is a perfect number.%n", cPotentialPerfectNumber);
        }
        return foundPerfectNumber;
    }

    public static void main(String[] args) {

        int start = 2;
        int end = 100000;

        int foundPerfectNumber = loopThroughAllPotentialPerfectNumbers(start, end);
        System.out.printf("There is %d perfect numbers between %d and %d.%n", foundPerfectNumber, start, end);
    }

}
