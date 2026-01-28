package javacore.chapter02.condition.exercise;

public class FirstBooleanCondition {

    public static void main(String[] args) {

        byte age = 30;
        boolean isAdult = false;

        if (age >= 18) {
            System.out.println("Vous etes majeur");
        }
        else {
            System.out.println("Vous etes mineur");
        }

    }

}
