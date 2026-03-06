package javacore.chapter04.function.exercise.project.refactor;

import java.math.BigDecimal;

public class FibonacciCalculatorFunctionRefactor {

    public static int calculateFibonacciSequence(BigDecimal FIRST_TERM, BigDecimal SECOND_TERM, int evenTermsCount, int limitNumber) {

        // fibonacci suit init values for the 3rd term
        BigDecimal previousTerm = FIRST_TERM;
        BigDecimal currentTerm = SECOND_TERM;

        for (int countTerm = 2 ; countTerm < limitNumber ; countTerm++) {
            BigDecimal nextTerm = previousTerm.add(currentTerm);

            BigDecimal checkEvenDivisor = new BigDecimal("2");

            if (nextTerm.remainder(checkEvenDivisor).equals(BigDecimal.ZERO)) {
                evenTermsCount++;
            }
            displayFibonacciSequence(countTerm, nextTerm);
            previousTerm = currentTerm;
            currentTerm = nextTerm;
        }
        return evenTermsCount;
    }

    public static void displayFibonacciSequence(int countTerm, BigDecimal nextTerm) {
        System.out.printf("The term F(%d) of the fibonacci sequence is : %.0f.%n", countTerm, nextTerm);
    }

    public static void displayEvenTermsCount(int evenTermsCount, int limitNumber) {
        System.out.printf("There is %d even terms from F(0) to F(%d).%n", evenTermsCount, limitNumber - 1);
    }

    public static void main(String[] args) {

        // init values
        final BigDecimal FIRST_TERM = new BigDecimal("0");
        final BigDecimal SECOND_TERM = new BigDecimal("1");
        System.out.println("The term F(0) of the Fibonacci sequence is : " + FIRST_TERM);
        System.out.println("The term F(1) of the Fibonacci sequence is : " + SECOND_TERM);

        int limitNumber = 1000;
        int evenTermsCount = 0;

        // loop through all from countTerm to limitNumber (already have the 2 first terms)
        evenTermsCount = calculateFibonacciSequence(FIRST_TERM, SECOND_TERM, evenTermsCount, limitNumber);

        displayEvenTermsCount(evenTermsCount, limitNumber);
    }

}
