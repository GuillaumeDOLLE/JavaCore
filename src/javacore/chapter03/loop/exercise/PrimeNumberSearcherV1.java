package javacore.chapter03.loop.exercise;

public class PrimeNumberSearcherV1 {

    public static void main(String[] args) {

        int maxNumber = 100;
        int countPrimeNumber = 0;

        // loop through all numbers from 1 to 100
        for (int currentNumber = 1 ; currentNumber <= maxNumber ; currentNumber++) {
            System.out.println("current number : " + currentNumber);

            // int divisor;
            // for (divisor = 2 ; divisor < currentNumber && currentNumber % divisor != 0 ; divisor++);

            int divisor = 2;
            // loop to search for divisible numbers that will leave 0 and inferior to our currentNumber
            while (divisor < currentNumber && currentNumber % divisor != 0) {
                divisor++;
            }

            // check prime
            if (divisor == currentNumber) {
                countPrimeNumber += 1;
                System.out.printf("%d is a prime number.%n", currentNumber);
            }

        }
        System.out.printf("There is %d prime numbers between 1 and 100.%n", countPrimeNumber);

    }

}
