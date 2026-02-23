package javacore.chapter03.loop.exercise;

import java.math.BigDecimal;

public class FibonacciCalculator {

    public static void main(String[] args) {

        // init values
        final BigDecimal FIRST_TERM = new BigDecimal("0");
        final BigDecimal SECOND_TERM = new BigDecimal("1");
        System.out.println("The term F(0) of the Fibonacci sequence is : " + FIRST_TERM);
        System.out.println("The term F(1) of the Fibonacci sequence is : " + SECOND_TERM);

        // copy F(0) & F(1) to find F(2)
        BigDecimal previousTerm = FIRST_TERM;
        BigDecimal currentTerm = SECOND_TERM;

        int limitNumber = 1000;
        int evenTermsCount = 0;

        // loop through all from countTerm to limitNumber (already have the 2 first terms)
        for (int countTerm = 2 ; countTerm < limitNumber ; countTerm++) {

            // F(n) = F(n-1) + F(n-2)
            BigDecimal nextTerm = previousTerm.add(currentTerm);

            // Check even terms
            BigDecimal checkEvenDivisor = new BigDecimal("2");
            // number % 2 == 0 ? yes even / no odd
            if (nextTerm.remainder(checkEvenDivisor).equals(BigDecimal.ZERO)) {
                evenTermsCount++;
            }

            System.out.printf("The term F(%d) of the fibonacci sequence is : %.0f.%n", countTerm, nextTerm);
            previousTerm = currentTerm;
            currentTerm = nextTerm;
        }
        System.out.printf("There is %d even terms from F(0) to F(999).%n", evenTermsCount);
    }

}
