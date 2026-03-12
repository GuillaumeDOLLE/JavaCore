package javacore.chapter04.function.exercise.project.refactor;

import java.math.BigDecimal;

public class FibonacciCalculatorFunctionRefactor {

    public static final BigDecimal EVEN_DIVISOR = new BigDecimal("2");

    public static BigDecimal computeNextTerm(BigDecimal previousTerm, BigDecimal currentTerm) {
        return previousTerm.add(currentTerm);
    }

    public static boolean isEven(BigDecimal number) {
        return number.remainder(EVEN_DIVISOR).equals(BigDecimal.ZERO);
    }

    public static void main(String[] args) {

        // init values
        final BigDecimal FIRST_TERM = new BigDecimal("0");
        final BigDecimal SECOND_TERM = new BigDecimal("1");
        System.out.println("The term F(0) of the Fibonacci sequence is : " + FIRST_TERM);
        System.out.println("The term F(1) of the Fibonacci sequence is : " + SECOND_TERM);

        // fibonacci suit init values for the 3rd term
        BigDecimal previousTerm = FIRST_TERM;
        BigDecimal currentTerm = SECOND_TERM;

        int limitNumber = 1000;
        int evenTermsCount = 0;

        // loop through all from countTerm to limitNumber (already have the 2 first terms)
        for (int countTerm = 2; countTerm < limitNumber; countTerm++) {
            BigDecimal nextTerm = computeNextTerm(previousTerm, currentTerm);

            if(isEven(nextTerm)) {
                evenTermsCount++;
            }

            System.out.printf("The term F(%d) of the fibonacci sequence is : %.0f.%n", countTerm, nextTerm);
            previousTerm = currentTerm;
            currentTerm = nextTerm;
        }
        System.out.printf("There is %d even terms from F(0) to F(999).%n", evenTermsCount);
    }

}
