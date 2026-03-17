package javacore.chapter04.function.exercise;

import java.math.BigDecimal;

public class RecursiveFibonacci {

    public static final BigDecimal EVEN_DIVISOR = new BigDecimal("2");

    public static void computeNextTerm(BigDecimal previousTerm, BigDecimal currentTerm, int countTerm, final int LIMIT_NUMBER) {
        if (countTerm < LIMIT_NUMBER) {
            BigDecimal nextTerm = previousTerm.add(currentTerm);

            System.out.println("The term F(" + (countTerm) + ") of the Fibonacci sequence is : " + nextTerm);
            countTerm++;

            computeNextTerm(currentTerm, nextTerm, countTerm, LIMIT_NUMBER);
        }
        return;
    }

    public static void main(String[] args) {

        // 48 because we already have F(0) and F(1) hardcoded by definition
        final int LIMIT_NUMBER = 50;

        // init values
        final BigDecimal FIRST_TERM = new BigDecimal("0");
        final BigDecimal SECOND_TERM = new BigDecimal("1");
        System.out.println("The term F(0) of the Fibonacci sequence is : " + FIRST_TERM);
        System.out.println("The term F(1) of the Fibonacci sequence is : " + SECOND_TERM);

        // fibonacci suit init values for the 3rd term
        BigDecimal previousTerm = FIRST_TERM;
        BigDecimal currentTerm = SECOND_TERM;

        int countTerm = 2;

        computeNextTerm(previousTerm, currentTerm, countTerm, LIMIT_NUMBER);

    }

}
