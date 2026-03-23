package javacore.chapter05.object.exercise;

import java.util.Scanner;

public class VowelCounter {

    public static void main(String[] args) {

        String vowels = "aeiouy";
        int vowelsACounter = 0;
        int vowelsECounter = 0;
        int vowelsICounter = 0;
        int vowelsOCounter = 0;
        int vowelsUCounter = 0;
        int vowelsYCounter = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir un texte : ");
        String userEntryText = scanner.nextLine().trim().toLowerCase();

        for (int index = 0; index < userEntryText.length(); index++) {
            char cr = userEntryText.charAt(index);
            for (int i = 0; i < vowels.length(); i++) {
                if (cr == vowels.charAt(i)) {
                    if (cr == 'a') {
                        vowelsACounter++;
                    }
                    if (cr == 'e') {
                        vowelsECounter++;
                    }
                    if (cr == 'i') {
                        vowelsICounter++;
                    }
                    if (cr == 'o') {
                        vowelsOCounter++;
                    }
                    if (cr == 'u') {
                        vowelsUCounter++;
                    }
                    if (cr == 'y') {
                        vowelsYCounter++;
                    }

                }
            }
        }

        System.out.println("Voici le compteur de chaque voyelle :\n- a = " + vowelsACounter + "\n- e = "
                + vowelsECounter + "\n- i = " + vowelsICounter + "\n- o = " + vowelsOCounter + "\n- u = " +
                vowelsUCounter + "\n- y = " + vowelsYCounter);

    }

}
