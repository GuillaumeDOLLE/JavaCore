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
            int potentialGradesNumber = 0;
            boolean isValidEntry = false;
            while (!isValidEntry) {
                String userEntry = scanner.nextLine();
                try {
                    potentialGradesNumber = Integer.parseInt(userEntry);

                    if (potentialGradesNumber < 2 || potentialGradesNumber > 30) {
                        System.err.println("Vous n'avez pas saisie un nombre de notes valide.");
                    }
                    else {
                        isValidEntry = true;
                    }
                } catch (NumberFormatException err) {
                    System.err.println("Il faut saisir un nombre, et pas une autre valeur.\nVeuillez réessayer : ");
                }
            }

            int[] gradesArray = new int[potentialGradesNumber];

            System.out.print("Veuillez maintenant saisir les notes que vous voulez enregistrer (entre 0 et 20) : ");

            int gradesIndex = 0;
            while (gradesIndex < gradesArray.length) {
                String userPotentialGrade = scanner.nextLine();

                try {
                    int potentialNextGrade = Integer.parseInt(userPotentialGrade);

                    if (potentialNextGrade < 0 || potentialNextGrade > 20) {
                        System.err.println("Vous n'avez pas saisie une note valide.\nVeuillez réessayer : ");
                    }
                    else {
                        gradesArray[gradesIndex] = potentialNextGrade;
                        gradesIndex++;
                    }
                } catch (NumberFormatException err) {
                    System.err.println("Il faut saisir un nombre, et pas une autre valeur.\nVeuillez réessayer : ");
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
