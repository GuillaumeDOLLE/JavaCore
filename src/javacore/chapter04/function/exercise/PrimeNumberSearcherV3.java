package javacore.chapter04.function.exercise;

public class PrimeNumberSearcherV3 {

    public static void main(String[] args) {

        System.out.println("0 et 1 ne sont pas des nombres premier par définition.");
        int primeNumberFound = 1;
        int cPotentialPrimeNumber = 2;

        while (primeNumberFound < 50) {
            // true or false from function stocked here
            boolean isCNumberPrime = isPrimeNumber(cPotentialPrimeNumber);

            if (isCNumberPrime) {
                System.out.println("-> " + cPotentialPrimeNumber + " est le Nombre Premier N°" + primeNumberFound);
                primeNumberFound++;
            }

            cPotentialPrimeNumber++;
        }

    }

    public static boolean isPrimeNumber(int number) {

        for (int potentialDivisor = 2; potentialDivisor < number; potentialDivisor++) {

            if (number % potentialDivisor == 0) {
                return false;
            }

        }
        // if there is no divisor other than 1 and the number itself
        return true;
    }

}
