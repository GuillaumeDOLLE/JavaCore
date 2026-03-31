package javacore.chapter05.object.exercise;

import java.sql.Array;

public class PrimeNumberSearcherV4 {

    public static void main(String[] args) {

        /**
         * Pseudo code logique crible d'ératosthène
         * Règle implicite du crible : éliminer les multiples des nombres à partir de 2 (0 n'a pas de multiple et 1 éliminerait tous les nombres)
         *
         *
         * tableau de boolean = [true, true, true, true...] (on considère tous les nombres comme premier)
         *
         * 0 et 1 ne sont pas des nombres premier (règle du crible)
         * donc les 2 premières valeur du tableau sont FALSE
         *
         * on cherche le premier nombre premier et on élimine tous ses multiples
         * 2 est le premier candidat comme dit auparavant selon la règle implicite donc c'est un nombre premier,
         * 2 -> 2 * 2 false, 2 * 3 false, 2 * 4 false etc...
         *
         * 3 est premier car non éliminé dans les multiples de 2 donc 3 * 3 false, 3 * 4 false...
         *
         * et ainsi desuite pour tous les autres nombres jusqu'à la racine carrée de la limite N imposée.
         * Racine carrée car les multiples auront déjà été éliminé.
         *
         * -----> Limite N = ?
         * Créer le tableau de taille N + 1
         * Toutes les valeurs sont set à TRUE
         * index 0 et 1 à FALSE
         *
         * boucle pour chaque nombre i de 2 jusqu'à racine carrée de N
         *      si i = TRUE (considéré premier)
         *          boucle pour chaque multiple de i (à partir de i², jusqu'à N) et pas racine carrée de N car il faut éliminer TOUS les multiples
         *              multiple de i = FALSE (non premier)
         *
         *
         * boucle pour i de 2 jusqu'à N
         *      afficher i comme nombre premier
         *
         */

        int limitNumber = 10_000;

        boolean[] potentialPrimeNumbers = new boolean[limitNumber + 1];
        for (int i = 0; i < potentialPrimeNumbers.length; i++) {
            potentialPrimeNumbers[i] = true;
        }

        potentialPrimeNumbers[0] = false;
        potentialPrimeNumbers[1] = false;

        for (int i = 2; i < Math.sqrt(potentialPrimeNumbers.length); i++) {
            if (potentialPrimeNumbers[i]) {
                for (int j = i * i; j < potentialPrimeNumbers.length; j += i) {
                    potentialPrimeNumbers[j] = false;
                }
            }
        }

        for (int i = 2; i < potentialPrimeNumbers.length; i++) {
            if (potentialPrimeNumbers[i]) {
                System.out.println("prime number : " + i);
            }
        }
    }

}

/**
 *
 * CODE IA
 *
 * public class CribleEratosthene {
 *
 *     public static boolean[] crible(int limite) {
 *         boolean[] estPremier = new boolean[limite + 1];
 *
 *         // On met tout à true au départ
 *         Arrays.fill(estPremier, true);
 *
 *         // 0 et 1 ne sont pas premiers
 *         if (limite >= 0) estPremier[0] = false;
 *         if (limite >= 1) estPremier[1] = false;
 *
 *         // Crible
 *         for (int i = 2; i * i <= limite; i++) {
 *             if (estPremier[i]) {
 *                 for (int j = i * i; j <= limite; j += i) {
 *                     estPremier[j] = false;
 *                 }
 *             }
 *         }
 *
 *         return estPremier;
 *     }
 *
 *     public static void main(String[] args) {
 *         int limite = 100;
 *         boolean[] estPremier = crible(limite);
 *
 *         System.out.println("Nombres premiers jusqu'à " + limite + " :");
 *         for (int i = 2; i <= limite; i++) {
 *             if (estPremier[i]) {
 *                 System.out.print(i + " ");
 *             }
 *         }
 *     }
 * }
 *
 *
 *
 * Différences avec le i * i plus précis quand on travaille avec des entiers alors que Math.sqrt implique les double
 *
 * Je dois rajouter <= à la place de < dans mes conditions
 *
 * Initialisation du tableau -> Arrays.fill(potentialPrimeNumbers, true) au lieu de ma boucle
 *
 * Nommage OK mais un peu long -> boolean[] isPrime;
 */
