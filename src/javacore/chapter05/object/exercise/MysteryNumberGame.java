package javacore.chapter05.object.exercise;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MysteryNumberGame {

    final static int LIMIT_ATTEMPTS = 7;

    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(101);
        System.out.println(number);

        Scanner scanner = new Scanner(System.in);
        int result = -1;
        int attempts = 0;
        do {
            attempts++;
            result = readValue(scanner);
            if (isValidNumber(result)) {
                if (result < number) {
                    System.out.println("C'est plus grand !");
                }
                else if (result > number) {
                    System.out.println("C'est plus petit !");
                }
                else {
                    System.out.println("C'est le bon nombre, GG !");
                    break;
                }
                System.out.println("Il vous reste " + (LIMIT_ATTEMPTS - attempts) + " tentatives.");
            }

        } while (attempts < LIMIT_ATTEMPTS);
        scanner.close();
    }

    public static Integer readValue(Scanner scanner) {
        try {
            String value = scanner.nextLine().trim();
            return parseInt(value);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean isValidNumber(Integer value) {
        return value != null && value >= 0 && value <= 100;
    }


    // ChatGPT bug mais je crois que si on divise toujours la poire en 2, en 7 tentatives on finit toujours par trouver le bon nombre à force de diviser.

}
