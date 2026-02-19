package javacore.chapter03.loop.exercise;

public class PrimeNumberSearcherV1 {

    public static void main(String[] args) {

        int limitNumber = 100;
        int foundPrimeNumber = 0;


        // loop through all numbers from 1 to 100
        for (int currentNumber = 2 ; currentNumber <= limitNumber ; currentNumber++) {
            System.out.println("current number : " + currentNumber);

            // Assuming it is prime
            boolean isPrimeNumber = true;

            for (int divisor = 2 ; divisor < currentNumber ; divisor++){
                if (currentNumber % divisor == 0) {
                    // If a divisor else than 1 or self : not prime
                    isPrimeNumber = false;
                    // There is no need for more loop turns if a divisor is found
                    break;
                }
            }

            if (isPrimeNumber) {
                foundPrimeNumber += 1;
                System.out.printf("%d is a prime number.%n", currentNumber);
            }

        }
        System.out.printf("There is %d prime numbers between 1 and 100.%n", foundPrimeNumber);


        // --------------------------- BONUS 1 -------------------------------

//        int foundPrimeNumber = 0;
//        int totalAnalysedNumbers = 0;
//        int currentNumber = 2;
//
//        while (foundPrimeNumber < 50) {
//
//            boolean isPrimeNumber = true;
//
//            totalAnalysedNumbers += 1;
//
//            for (int divisor = 2 ; divisor < currentNumber ; divisor++) {
//                if (currentNumber % divisor == 0) {
//                    isPrimeNumber = false;
//                    break;
//                }
//            }
//            if (isPrimeNumber) {
//                foundPrimeNumber += 1;
//                System.out.printf("%d is a prime number.%n", currentNumber);
//            }
//            currentNumber++;
//        }
//        System.out.printf("There is %d numbers that have been analysed to get the 50 first prime numbers.%n", totalAnalysedNumbers);

    }

}
