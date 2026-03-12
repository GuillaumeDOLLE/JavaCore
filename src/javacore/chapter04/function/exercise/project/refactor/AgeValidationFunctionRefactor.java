package javacore.chapter04.function.exercise.project.refactor;

public class AgeValidationFunctionRefactor {

    // Inputs
    static  final int USER_BIRTH_DAY  = 13; // < 10, 10, > 10
    static final int USER_BIRTH_MONTH = 3; // < 2, 2, > 2
    static final int USER_BIRTH_YEAR  = 2008; // < 2008, 2008, > 2008

    static final int MONTHS_PER_YEAR    = 12;
    static final int DAYS_AVERAGE_MONTH = 30;
    static final int HOURS_PER_DAY      = 24;
    static final int MINUTES_PER_HOUR   = 60;
    static final int SECONDS_PER_MINUTE = 60;

    static final long DAYS_CONVERTED_IN_SECONDS   = HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
    static final long MONTHS_CONVERTED_IN_SECONDS = DAYS_CONVERTED_IN_SECONDS * DAYS_AVERAGE_MONTH;
    static final long YEARS_CONVERTED_IN_SECONDS  = MONTHS_CONVERTED_IN_SECONDS * MONTHS_PER_YEAR;

    static final int ADULT_IN_YEARS = 18;

    public static void main(String[] args) {

        /**
         * Début d'un code que nous ne comprenons pas à ce stade de la formation...
         */

        // Récupération de la date courante de la machine exécutant ce programme
        java.time.LocalDate currentDate = java.time.LocalDate.now();

        int currentDay = currentDate.getDayOfMonth(); // Jour courant (entre 1 et 31)
        int currentMonth = currentDate.getMonthValue(); // Mois courant (entre 1 et 12)
        int currentYear = currentDate.getYear();       // Année courante (202X)

        System.out.println("Nous somme le " + currentDay + "/" + currentMonth + "/" + currentYear);

        /**
         * Fin d'un code que nous ne comprenons pas, mais dont nous pouvons utiliser les variables !
         */

        long currentSeconds = convertDateToSeconds(currentDay, currentMonth, currentYear);
        long userBirthSeconds = convertDateToSeconds(USER_BIRTH_DAY, USER_BIRTH_MONTH, USER_BIRTH_YEAR);

        // calc
        long secondsSinceUserBirthday = currentSeconds - userBirthSeconds;

        long majorityInSeconds = getMajorityInSeconds();
        System.out.println("seconds for someone to be a young adult : " + majorityInSeconds);

        // 2nd version with seconds conversion before calc
        if (secondsSinceUserBirthday < majorityInSeconds) {
            long secondsUntilAdult = majorityInSeconds - secondsSinceUserBirthday;
            // output
            System.out.printf("You are a minor, Only %d seconds left to be an adult !%n", secondsUntilAdult);
        } else {
            System.out.println("You are an adult.");
        }

        // 1st version
        int ageCategory = checkAdult(USER_BIRTH_DAY, USER_BIRTH_MONTH, USER_BIRTH_YEAR,
                currentDay, currentMonth, currentYear);

        if (ageCategory == 1) {
            System.out.println("You are an adult.");
        }
        else {
            System.out.println("You are a minor.");
        }
    }

    public static int checkAdult(int userBirthDay, int userBirthMonth, int userBirthYear, int cDay, int cMonth, int cYear) {
        if ((cYear - userBirthYear > 18) || (cYear - userBirthYear == 18) &&
                (cMonth > userBirthMonth || (cMonth == userBirthMonth && cDay >= userBirthDay))) {
            return 1;
        }
        return 0;
    }

    public static long convertDateToSeconds(int day, int month, int year) {
        // cast to long because of the value might need a long type
        return (long) day * DAYS_CONVERTED_IN_SECONDS + (long) month * MONTHS_CONVERTED_IN_SECONDS + year * YEARS_CONVERTED_IN_SECONDS;
    }

    public static long getMajorityInSeconds() {
        return ADULT_IN_YEARS * YEARS_CONVERTED_IN_SECONDS;
    }
}
