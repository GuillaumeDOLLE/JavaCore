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

        int userBirthDay = 22; // < 10, 10, > 10
        int userBirthMonth = 3; // < 2, 2, > 2
        int userBirthYear = 2008; // < 2008, 2008, > 2008

        if ((currentYear - userBirthYear > 18) || (currentYear - userBirthYear == 18) && (userBirthMonth < currentMonth || (userBirthMonth == currentMonth && userBirthDay <= currentDay))) {
            System.out.println("You are an adult.");
        }
        else {
            System.out.println("You are a minor.");
        }

        // Nested if - adult
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
                    int daysUntilAdult = userBirthDay - currentDay;
                    System.out.printf("You are a minor. You will be an adult in %d days.%n", daysUntilAdult);
                }
            }
            else {
                int monthsConvertedInDaysUntilAdult = (userBirthMonth - currentMonth) * 30;
                int daysUntilAdult = userBirthDay - currentDay;
                int timeUntilAdult = daysUntilAdult + monthsConvertedInDaysUntilAdult;
                System.out.printf("You are a minor. You will be an adult in %d days.%n", timeUntilAdult);
            }
        }
        else {
            System.out.println("You are a minor.");
        }

        // Nested if - minor
        if (currentYear - userBirthYear < 18) {
            System.out.println("You are a minor.");
        }
        else if (currentYear - userBirthYear == 18) {
            if (userBirthMonth > currentMonth) {
                int monthsConvertedInDaysUntilAdult = (userBirthMonth - currentMonth) * 30;
                int daysUntilAdult = userBirthDay - currentDay;
                int timeUntilAdult = daysUntilAdult + monthsConvertedInDaysUntilAdult;
                System.out.printf("You are a minor. You will be an adult in %d days.%n", timeUntilAdult);
            }
            else if (userBirthMonth == currentMonth) {
                if (userBirthDay > currentDay) {
                    int daysUntilAdult = userBirthDay - currentDay;
                    System.out.printf("You are a minor. You will be an adult in %d days.%n", daysUntilAdult);
                }
                else {
                    System.out.println("You are an adult.");
                }
            }
            else {
                System.out.println("You are an adult.");
            }
        }
        else {
            System.out.println("You are an adult.");
        }

        // Instructions impacted by leap years : no impact because I already use the civil calendar which implement leap years
        // The only issue I see that might happen is if someone is born on a leap year the 29th of february.
        // If that happens I think the right way to handle this is to consider the end of the year to be the 1st of march.


    }

}
