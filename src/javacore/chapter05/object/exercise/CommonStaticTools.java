package javacore.chapter05.object.exercise;

import java.util.Arrays;

public class CommonStaticTools {

    public static void main(String[] args) {

        /*
        1. La classe Math avec
        Math.max / Math.min(a, b) pour comparer 2 valeurs
        Math.round(), Math.floor(), Math.ceil() pour arrondir
        Math.random() pour générer un nombre aléatoire

        Permet de remplacer des if

        La classe String avec
        String.valueOf(...) (static) pour convertir n'importe quoi en texte
        Integer.parseInt(String) pour convertir un String en nombre

        La classe Arrays avec
        Arrays.sort(array) pour trier un tableau
        Arrays.toString(array) pour afficher un tableau avec tous ses éléments internes
        Arrays.copyOf(...) pour copier un tableau (et éviter des boucles avec array[i] = newArray[i]
        Arrays.equals(a, b) pour comparer

        Il y en a d'autres qu'on a pas encore vu comme Collections pour les List

        Mais aussi Stream pour filtrer les list et remplacer les boucles également

        Les méthodes static ne remplacent pas les structures du langage, elles les complètent intelligemment.
         */


        /*
        2. La méthode Arrays.sort est littéralement parfaite pour cet exercice car elle prend un tableau et tri les éléments à l'intérieur en ordre croissant.
         */
        int[] array = {1, 4, 7, 3, 2, 9, 8, 6, 5};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // -> [1, 2, 3, 4, 5, 6, 7, 8, 9] Mon tableau est trié !!!

        int[] numbers = {30, 25, 85, 6, 43, 58, 97, 78, 94, 27, 9, 38, 41, 35, 52, 10, 16, 22, 96, 74, 44, 55, 82, 28, 83, 69, 90, 89, 26, 7, 47, 98, 50, 42, 68, 91, 70, 65, 79, 4, 75, 49, 61, 39, 48, 72, 36, 18, 1, 15, 77, 99, 33, 24, 13, 19, 73, 17, 14, 86, 54, 45, 76, 21, 100, 63, 60, 56, 93, 87, 81, 8, 29, 34, 53, 37, 71, 67, 57, 66, 11, 46, 95, 20, 88, 64, 59, 84, 12, 92, 80, 40, 23, 3, 2, 32, 31, 5, 62, 51};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers)); // Pour le BubbleSorting

        /*
        3. La méthode Arrays.copyOf(array, array.length) permet de copier un tableau afin d'en créer un nouveau avec une taille plus ou moins grande.
         */

        // au lieu de faire ça
        double grade = 13; // dans mon exo grade est récupéré grâce au Scanner
        double[] gradesArray = {grade};
        double[] newGradesArray = new double[gradesArray.length + 1];

        // copy previous grades
        for (int j = 0; j < gradesArray.length; j++) {
            newGradesArray[j] = gradesArray[j];
        }
        double potentialNewGrade = Math.random();
        newGradesArray[newGradesArray.length - 1] = potentialNewGrade;
        gradesArray = newGradesArray;
        System.out.println(Arrays.toString(gradesArray));

        // on peut faire ça directement
        gradesArray = Arrays.copyOf(gradesArray, gradesArray.length + 1);
        gradesArray[gradesArray.length - 1] = potentialNewGrade;
        System.out.println(Arrays.toString(gradesArray));

        /*
        4. Les méthodes pour calculer des racines carrées et des puissances sont utilisées avec la classe Math
        Math.sqrt(x) pour la racinée carrée de x et Math.pow(x, y) pour la valeur de x à la puissance de y
         */
        int number = 9;
        int pow = 3;

        double squareNumber = Math.sqrt(number);
        System.out.println(squareNumber);

        double resultPowNumber = Math.pow(number, pow);
        System.out.println(resultPowNumber);

        /*
        5. Morale à retenir : Il est bien de connaitre la logique derrière l'algorithmie utilisée dans nos programmes Java,
        mais on ne peut pas tout connaitre donc rien ne sert de réinventer la roue, il faut utiliser les méthodes déjà créées
        pour des cas d'utilisation spécifiques comme ici avec la classe Arrays et la classe Math. Un développeur ne peut pas
        TOUT connaitre mais il sait où chercher pour arriver à ses fins.
         */
    }

}
