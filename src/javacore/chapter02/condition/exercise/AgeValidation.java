package javacore.chapter02.condition.exercise;

import java.time.LocalDate;
import java.util.Date;

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

        // Inputs
        final int USER_BIRTH_DAY = 18; // < 10, 10, > 10
        final int USER_BIRTH_MONTH = 2; // < 2, 2, > 2
        final int USER_BIRTH_YEAR = 2008; // < 2008, 2008, > 2008

        final int MONTHS_PER_YEAR = 12;
        int daysAverageMonth = 30;
        final int HOURS_PER_DAY = 24;
        final int MINUTES_PER_HOUR = 60;
        final int SECONDS_PER_MINUTE = 60;

        final int ADULT_IN_YEARS = 18;

        // Conversion
        int daysConvertedInSeconds = HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
        int monthsConvertedInSeconds = daysConvertedInSeconds * daysAverageMonth;
        long yearsConvertedInSeconds = monthsConvertedInSeconds * MONTHS_PER_YEAR;


        int userBirthDayInSeconds = USER_BIRTH_DAY * daysConvertedInSeconds;
        int userBirthMonthInSeconds = USER_BIRTH_MONTH * monthsConvertedInSeconds;
        long userBirthYearInSeconds = USER_BIRTH_YEAR * yearsConvertedInSeconds;
        long userBirthSeconds = userBirthDayInSeconds + userBirthMonthInSeconds + userBirthYearInSeconds;


        int currentDaysConvertedInSeconds = currentDay * daysConvertedInSeconds;
        int currentMonthsConvertedInSeconds = currentMonth * monthsConvertedInSeconds;
        long currentYearsConvertedInSeconds = currentYear * yearsConvertedInSeconds;
        long currentSeconds = currentDaysConvertedInSeconds + currentMonthsConvertedInSeconds + currentYearsConvertedInSeconds;

        // calc
        long secondsSinceUserBirthday = currentSeconds - userBirthSeconds;

        long majorityInSeconds = ADULT_IN_YEARS * yearsConvertedInSeconds;
        System.out.println("seconds for someone to be a young adult : " + majorityInSeconds);

        // 2nd version with seconds conversion before calc
        if (secondsSinceUserBirthday < majorityInSeconds) {
            long secondsUntilAdult = majorityInSeconds - secondsSinceUserBirthday;
            // output
            System.out.printf("You are a minor, Only %d seconds left to be an adult !%n", secondsUntilAdult);
        }
        else {
            System.out.println("You are an adult.");
        }

        // 1st version
        if ((currentYear - USER_BIRTH_YEAR > 18) || (currentYear - USER_BIRTH_YEAR == 18) && (USER_BIRTH_MONTH < currentMonth || (USER_BIRTH_MONTH == currentMonth && USER_BIRTH_DAY <= currentDay))) {
            System.out.println("You are an adult.");
        }
        else {
            System.out.println("You are a minor.");
        }

        // 1st version with seconds conversion after calc
        if (currentYear - USER_BIRTH_YEAR < 18) {
            System.out.println("You are a minor.");
        }
        else if (currentYear - USER_BIRTH_YEAR > 18) {
            System.out.println("You are an adult.");
        }
        else {
            if (USER_BIRTH_MONTH > currentMonth) {
                int monthsConvertedInDaysUntilAdult = (USER_BIRTH_MONTH - currentMonth) * daysAverageMonth;
                int daysUntilAdult = USER_BIRTH_DAY - currentDay;
                int daysConvertedInSecondsUntilAdult = monthsConvertedInDaysUntilAdult * daysConvertedInSeconds + daysUntilAdult * daysConvertedInSeconds;
                System.out.printf("You are a minor. You will be an adult in %d seconds.%n", daysConvertedInSecondsUntilAdult);
            }
            else if (USER_BIRTH_MONTH < currentMonth) {
                System.out.println("You are an adult.");
            }
            else {
                if (USER_BIRTH_DAY > currentDay) {
                    int daysUntilAdult = USER_BIRTH_DAY - currentDay;
                    int daysConvertedInSecondsUntilAdult = daysUntilAdult * HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
                    System.out.printf("You are a minor. You will be an adult in %d seconds.%n", daysConvertedInSecondsUntilAdult);
                }
                else {
                    System.out.println("You are an adult.");
                }
            }
        }

        // Instructions impacted by leap years : no impact because I already use the civil calendar which implement leap years
        // The only issue I see that might happen is if someone is born on a leap year the 29th of february.
        // If that happens I think the right way to handle this is to consider the end of the year to be the 1st of march.

    }

}
