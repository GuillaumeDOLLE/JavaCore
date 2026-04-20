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
            if (isValid(result)) {
                if (result < number) {
                    System.out.println("C'est plus grand !\nIl vous reste " + (LIMIT_ATTEMPTS - attempts) + " tentatives.");
                }
                else if (result > number) {
                    System.out.println("C'est plus petit !\nIl vous reste " + (LIMIT_ATTEMPTS - attempts) + " tentatives.");
                }
                else {
                    System.out.println("C'est le bon nombre, GG !");
                    break;
                }
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

    public static boolean isValid(Integer value) {
        return value != null && value >= 0 && value < 101;
    }

}
