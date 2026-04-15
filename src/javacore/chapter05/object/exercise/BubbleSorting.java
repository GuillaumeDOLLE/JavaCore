package javacore.chapter05.object.exercise;

import java.util.Arrays;

public class BubbleSorting {

    public static void main(String[] args) {

        int[] numbers = {30, 25, 85, 6, 43, 58, 97, 78, 94, 27, 9, 38, 41, 35, 52, 10, 16, 22, 96, 74, 44, 55, 82, 28, 83, 69, 90, 89, 26, 7, 47, 98, 50, 42, 68, 91, 70, 65, 79, 4, 75, 49, 61, 39, 48, 72, 36, 18, 1, 15, 77, 99, 33, 24, 13, 19, 73, 17, 14, 86, 54, 45, 76, 21, 100, 63, 60, 56, 93, 87, 81, 8, 29, 34, 53, 37, 71, 67, 57, 66, 11, 46, 95, 20, 88, 64, 59, 84, 12, 92, 80, 40, 23, 3, 2, 32, 31, 5, 62, 51};

        /*
        Bubble Sorting
        Forces : Simplicité (comparer deux voisins, échanger si besoin, recommencer), pas de notions "compliquées"
                 Facilement optimisable (si pendant un passage il n'y a pas d'échange alors le tableau est déjà trié.
                 Stable
        Faiblesses : Performance (beaucoup trop de comparaisons et d'échanges), grand tableau = tri lent, échanges parfois inutiles.
         */
//        for (int i = 0; i < numbers.length; i++) {
//
//            for (int index = 0; index < numbers.length - 1; index++) {
//                if (numbers[index] >= numbers[index + 1]) {
//                    int tempValue = numbers[index];
//                    numbers[index] = numbers[index + 1];
//                    numbers[index + 1] = tempValue;
//                }
//            }
//
//        }
//
//        // Selective sorting (find the min number and swap it with index value)
//        for (int i = 0; i < numbers.length; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[j] < numbers[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            int tempValue = numbers[i];
//            numbers[i] = numbers[minIndex];
//            numbers[minIndex] = tempValue;
//        }

        // Tri par insertion
        for (int i = 1; i < numbers.length; i++) {
            // nombre courant
            int cNumber = numbers[i];
            // index précédent
            int prevIndex = i - 1;

            // tant qu'un nombre précédent est supérieur au nombre courant et son index n'est pas inférieur à 0
            while (prevIndex >= 0 && numbers[prevIndex] > cNumber) {
                // on "décale" les nombres précédents pour insérer le nombre que l'on veut trier
                numbers[prevIndex + 1] = numbers[prevIndex];
                // on décrémente l'index précédent de 1 car on remonte le tableau pour trouver la bonne position
                prevIndex--;
            }
            // on insère le nombre courant à la bonne position dans la partie déjà triée
            numbers[prevIndex + 1] = cNumber;
        }

        // Tri rapide
        // Très utile pour les grands tableaux, plus rapide que les autres tri mais beaucoup plus complexe à comprendre et à implémenter.
        // Nécessite de la récursion ou des sous tableaux
        // Utilise un pivot pour diviser le tableau et comparer les valeurs dans chaque partie du tableau par rapport au pivot.
        // Un nouveau pivot est mis en place pour chaque partie et ainsi de suite

        System.out.println(Arrays.toString(numbers));
    }

}
