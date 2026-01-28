package javacore.chapter02.condition.exercise;

public class AgeCategorization {

    public static void main(String[] args) {

        // 9, 10, 17, 18, 24, 25, 64, 65, 70
        int age = 70;

        boolean isChild = age < 10;
        boolean isTeenager = 10 <= age && age < 18;
        boolean isYoungAdult = 18 <= age && age < 25;
        boolean isAdult = 25 <= age && age < 65;
        boolean isSenior = age >= 65; // non utilisé mais je le laisse pour la logique

        if (isChild) {
            System.out.println("Tu as " + age + " ans, tu es encore un(e) enfant.");
        }
        else if (isTeenager) {
            System.out.println("Tu as " + age + " ans, tu es un(e) adolescent(e).");
        }
        else if (isYoungAdult) {
            System.out.println("Vous avez " + age + " ans, vous etes un(e) jeune adulte.");
        }
        else if (isAdult) {
            System.out.println("Vous avez " + age + " ans, vous etes un(e) adulte.");
        }
        else {
            System.out.println("Vous avez " + age + " ans, vous etes un(e) senior.");
        }


    }

}
