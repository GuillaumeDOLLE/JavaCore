package javacore.chapter03.loop.exercise;

public class FibonacciCalculator {

    public static void main(String[] args) {

        // F(n) = F(n-1) + F(n-2)

        long previousTerm = 0; // F(n-2)
        long currentTerm = 1;  // F(n-1)

        int limitNumber = 50;

        // loop through all from 2 to 50 (already have 0 and 1)
        for (int countTerm = 2 ; countTerm < limitNumber ; countTerm++) {

            System.out.println("countTerm = " + countTerm);

            long nextTerm = previousTerm + currentTerm; // F(n) = F(n-1) + F(n-2)
            System.out.println("next " + nextTerm);

            previousTerm = currentTerm; // F(n-2) becomes F(n-1) after a turn
            currentTerm = nextTerm; // F(n-1) becomes F(n) after a turn

        }
    }

}
