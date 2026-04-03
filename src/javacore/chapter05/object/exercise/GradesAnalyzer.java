package javacore.chapter05.object.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class GradesAnalyzer {

    public static double getAverage(int[] gradesArray) {
        double sum = 0;
        for (double grade : gradesArray) {
            sum += grade;
        }
        return sum / gradesArray.length;
    }

    public static double getMinGrade(int[] gradesArray) {
        double minGrade = gradesArray[0];
        for (int grade : gradesArray) {
            if (grade < minGrade) {
                minGrade = grade;
            }
        }

        return minGrade;
    }

    public static double getMaxGrade(int[] gradesArray) {
        double maxGrade = gradesArray[0];
        for (int grade : gradesArray) {
            if (grade > maxGrade) {
                maxGrade = grade;
            }
        }

        return maxGrade;
    }

    public static int getGradeCountAboveThreshold(int[] gradesArray, int threshold) {
        int count = 0;

        for (int grade : gradesArray) {
            if (grade > threshold) {
                count++;
            }
        }

        return count;
    }

    public static int getGradeCountBetweenRange(int[] gradesArray, int from, int to) {
        int count = 0;
        for (int grade : gradesArray) {
            if (grade >= from && grade <= to) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.print("Veuillez saisir le nombre de notes que vous souhaitez enregistrer entre 2 et 30 notes : ");
        try(Scanner scanner = new Scanner(System.in)) {
            int gradesNumber = 0;
            if (scanner.hasNextInt()) {
                gradesNumber = scanner.nextInt();
                if (gradesNumber < 2 || gradesNumber > 30) {
                    System.err.print("Vous n'avez pas saisie un nombre de notes valide.");
                }
            } else {
                System.err.print("Il faut saisir un nombre, et pas une autre valeur.");
            }

            int[] gradesArray = new int[gradesNumber];


            System.out.print("Veuillez maintenant saisir les notes que vous voulez enregistrer (entre 0 et 20) : ");
            for (int gradesIndex = 0; gradesIndex < gradesArray.length; gradesIndex++) {
                if (scanner.hasNextInt()) {
                    gradesArray[gradesIndex] = scanner.nextInt();
                    if (gradesArray[gradesIndex] < 0 || gradesArray[gradesIndex] > 20) {
                        System.err.print("Vous n'avez pas saisie une note valide.");
                    }
                }
                else {
                    System.err.print("Il faut saisir un nombre, et pas une autre valeur.");
                }
            }
            System.out.println(Arrays.toString(gradesArray));

            double average = getAverage(gradesArray);
            System.out.println("Moyenne générale : " + average);

            double minGrade = getMinGrade(gradesArray);
            System.out.println("Note la plus basse contenue dans le tableau : " + minGrade);

            double maxGrade = getMaxGrade(gradesArray);
            System.out.println("Note la plus haute contenue dans le tableau : " + maxGrade);

            int threshold = 12;
            int gradeCountAboveThreshold = getGradeCountAboveThreshold(gradesArray, threshold);
            double gradeCountAboveThresholdPercent = (double) gradeCountAboveThreshold / gradesArray.length * 100;
            System.out.println("Nombres de notes > " + threshold + " = " + gradeCountAboveThreshold + " (soit " + gradeCountAboveThresholdPercent + "%)");

            int from = 0;
            int to = 5;
            int gradeCountBetweenRange = getGradeCountBetweenRange(gradesArray, from, to);
            double gradeCountBetweenRangePercent = (double) gradeCountBetweenRange / gradesArray.length * 100;
            System.out.println("Nombre de notes dans l'intervalle [" + from + " - " + to + "] = " + gradeCountBetweenRange + " (soit " + gradeCountBetweenRangePercent + "%)");
        }

    }

}
