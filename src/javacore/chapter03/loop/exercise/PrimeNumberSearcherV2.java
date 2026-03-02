package javacore.chapter03.loop.exercise;

public class PrimeNumberSearcherV2 {

    public static void main(String[] args) {

        int potentialPrimeNumber = 1;
        int primeNumberFound = 1;
        int countAnalysedNumbers = 0;
        int countIterations = 0;
        System.out.println("Liste des 50 premiers Nombres Premiers : ");

        while(primeNumberFound <= 50) {

            countAnalysedNumbers++;
            boolean isCurrentNumberPrime = true;

            for (int potentialDivisor = 2; potentialDivisor <= potentialPrimeNumber - 1; potentialDivisor++) {

                countIterations++;

                if (potentialPrimeNumber % potentialDivisor == 0) {
                    isCurrentNumberPrime = false;
                    break;
                }

            }

            if (isCurrentNumberPrime) {
                System.out.println("-> " + potentialPrimeNumber + " est le Nombre Premier N°" + primeNumberFound);
                primeNumberFound++;
            }

            potentialPrimeNumber++;
        }

        System.out.println("Pour les " + (primeNumberFound - 1) + " premiers Nombres Premiers, il y a " + countAnalysedNumbers + " nombres analysés, et " + countIterations + " itérations.");
        // 50     : 227     nombres analysés | sans break -> 25_425        itérations | avec break -> 5_144       itérations
        // 100    : 523     nombres analysés | sans break -> 135_981       itérations | avec break -> 24_370      itérations
        // 1000   : 7_907   nombres analysés | sans break -> 31_248_465    itérations | avec break -> 3_703_646   itérations
        // 10_000 : 104_723 nombres analysés | sans break -> 1_188_328_985 itérations | avec break -> 496_902_444 itérations
        // Cela varie de façon exponentielle
    }

}
