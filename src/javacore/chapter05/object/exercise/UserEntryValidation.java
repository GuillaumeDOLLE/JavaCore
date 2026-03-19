package javacore.chapter05.object.exercise;

import java.util.Scanner;

public class UserEntryValidation {

    public static void main(String[] args) {

        String today;

        Scanner scan = new Scanner(System.in);

        System.out.print("Entrez le jour de la semaine : ");
        do {
            today = scan.next();
        } while (!today.equalsIgnoreCase("jeudi"));

    }

}
