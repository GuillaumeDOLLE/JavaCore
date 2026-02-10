package javacore.chapter02.condition.exercise;

public class AgeValidation {

    public static void main(String[] args) {

        /**
         * Début d'un code que nous ne comprenons pas à ce stade de la formation...
         */

        // Récupération de la date courante de la machine exécutant ce programme
        java.time.LocalDate currentDate = java.time.LocalDate.now();

        int currentDay   = currentDate.getDayOfMonth(); // Jour courant (entre 1 et 31)
        int currentMonth = currentDate.getMonthValue(); // Mois courant (entre 1 et 12)
        int currentYear  = currentDate.getYear();       // Année courante (202X)

        System.out.println("Nous somme le " + currentDay + "/" + currentMonth + "/" + currentYear);

        /**
         * Fin d'un code que nous ne comprenons pas, mais dont nous pouvons utiliser les variables !
         */

        int userBirthDay = 1; // < 10, 10, > 10
        int userBirthMonth = 1; // < 2, 2, > 2
        int userBirthYear = 2009; // < 2008, 2008, > 2008

        // 30 < 10, 12 < 2, 2026 - 2008 = 18



        if ((currentYear - userBirthYear > 18) || (currentYear - userBirthYear == 18) && (userBirthMonth < currentMonth || (userBirthMonth == currentMonth && userBirthDay <= currentDay))) {
            System.out.println("You are an adult.");
        }
        else {
            System.out.println("You are a minor.");
        }

        // Nested if
        if (currentYear - userBirthYear > 18) {
            System.out.println("You are an adult.");
        }
        else if (currentYear - userBirthYear == 18) {
            if (userBirthMonth < currentMonth) {
                System.out.println("You are an adult.");
            }
            else if (userBirthMonth == currentMonth) {
                if (userBirthDay <= currentDay) {
                    System.out.println("You are an adult.");
                }
                else {
                    System.out.println("You are a minor.");
                }
            }
            else {
                System.out.println("You are a minor.");
            }
        }
        else {
            System.out.println("You are a minor.");
        }
    }

}
