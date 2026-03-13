package javacore.chapter04.function.exercise;

import java.math.BigDecimal;

public class RecursiveFibonacci {

    public static final BigDecimal EVEN_DIVISOR = new BigDecimal("2");

    public static void computeNextTerm(BigDecimal previousTerm, BigDecimal currentTerm, int limitNumber, int countTerm) {
        BigDecimal nextTerm = previousTerm.add(currentTerm);

        countTerm++;
        System.out.println("The term F(" + (countTerm + 1) + ") of the Fibonacci sequence is : " + nextTerm);
        if (countTerm >= limitNumber) {
            return;
        }

        previousTerm = currentTerm;
        currentTerm = nextTerm;

        computeNextTerm(previousTerm, currentTerm, limitNumber, countTerm);
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

        // 48 because we already have F(0) and F(1) hardcoded by definition
        int limitNumber = 48;
        int countTerm = 0;

        computeNextTerm(previousTerm, currentTerm, limitNumber, countTerm);

    }

}
