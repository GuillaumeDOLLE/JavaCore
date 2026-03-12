package javacore.chapter04.function.exercise;

public class FrenchNetSalaryCalculator {

    // taxable percent for each bracket
    static final double BRACKET_1_RATE = 0.0;
    static final double BRACKET_2_RATE = 11.0;
    static final double BRACKET_3_RATE = 30.0;
    static final double BRACKET_4_RATE = 41.0;
    static final double BRACKET_5_RATE = 45.0;

    // Upper bound of taxable brackets, I handle conditions with these.
    static final int BRACKET_1_THRESHOLD = 0;
    static final int BRACKET_2_THRESHOLD = 11294;
    static final int BRACKET_3_THRESHOLD = 28797;
    static final int BRACKET_4_THRESHOLD = 82341;
    static final int BRACKET_5_THRESHOLD = 177106;

    static final int MAX_DEDUCTION_AMOUNT = 10000;

    public static double getAnnualGrossSalary(double hourlyGrossSalary, double dailyWorkedHours, double weeklyWorkedDays,
                                              double monthlyWorkedWeeks, double annuallyWorkedMonths) {
        return hourlyGrossSalary * dailyWorkedHours * weeklyWorkedDays *
                monthlyWorkedWeeks * annuallyWorkedMonths;
    }

    public static double applySocialCharges(double annualGrossSalary, double socialChargePercentage) {
        double socialChargesAmount =  annualGrossSalary * socialChargePercentage / 100;
        return annualGrossSalary - socialChargesAmount;
    }

    public static double applyTaxAllowance(double annualNetSalary, double taxAllowancePercentage) {
        double deductionAmount = annualNetSalary * taxAllowancePercentage / 100;
        if (deductionAmount >= MAX_DEDUCTION_AMOUNT) {
            return annualNetSalary - MAX_DEDUCTION_AMOUNT;
        }
        return annualNetSalary - annualNetSalary * taxAllowancePercentage / 100;
    }

    public static double getTaxBracket(double remainingNetTaxableSalary, int bracketThreshold, double bracketRate) {

        if (remainingNetTaxableSalary > bracketThreshold) {
            double bracketAmount = remainingNetTaxableSalary - bracketThreshold;
            return bracketAmount * bracketRate / 100;
        }
        return 0;
    }

    public static double getRemainingSalary(double salary, double threshold) {
        if (salary > threshold) {
            return threshold;
        }
        return salary;
    }
    
    public static double applyRevenueTax(double annualNetSalary) {
        double remainingNetTaxableSalary = annualNetSalary;
        double totalTaxAmount = 0;

        double fifthTaxBracket = getTaxBracket(remainingNetTaxableSalary, BRACKET_5_THRESHOLD, BRACKET_5_RATE);
        remainingNetTaxableSalary = getRemainingSalary(remainingNetTaxableSalary, BRACKET_5_THRESHOLD);

        double fourthTaxBracket = getTaxBracket(remainingNetTaxableSalary, BRACKET_4_THRESHOLD, BRACKET_4_RATE);
        remainingNetTaxableSalary = getRemainingSalary(remainingNetTaxableSalary, BRACKET_4_THRESHOLD);

        double thirdTaxBracket = getTaxBracket(remainingNetTaxableSalary, BRACKET_3_THRESHOLD, BRACKET_3_RATE);
        remainingNetTaxableSalary = getRemainingSalary(remainingNetTaxableSalary, BRACKET_3_THRESHOLD);

        double secondTaxBracket = getTaxBracket(remainingNetTaxableSalary, BRACKET_2_THRESHOLD, BRACKET_2_RATE);
        remainingNetTaxableSalary = getRemainingSalary(remainingNetTaxableSalary, BRACKET_2_THRESHOLD);

        double firstTaxBracket = getTaxBracket(remainingNetTaxableSalary, BRACKET_1_THRESHOLD, BRACKET_1_RATE);

        totalTaxAmount = fifthTaxBracket + fourthTaxBracket + thirdTaxBracket + secondTaxBracket + firstTaxBracket;

        return annualNetSalary - totalTaxAmount;
    }

    public static void main(String[] args) {
        boolean isWorker = false;
        double socialChargePercentage = 0;
        if (isWorker) {
            socialChargePercentage = 23;
        }
        else {
            socialChargePercentage = 25;
        }
        double hourlyGrossSalary = 25;
        double dailyWorkedHours = 7.7;
        double weeklyWorkedDays = 5;
        double monthlyWorkedWeeks = 4;
        double annuallyWorkedMonths = 12;
        double taxAllowancePercentage = 10;

        double minFrenchHourlyWage = 11.07;
        double mediaFrenchHourlySalary = 17.50;
        double averageFrenchHourlySalary = 22.50;
        double wealthFrenchThresholdHourlySalary = 35;

        double annualGrossSalary = getAnnualGrossSalary(wealthFrenchThresholdHourlySalary, dailyWorkedHours, weeklyWorkedDays,
                monthlyWorkedWeeks, annuallyWorkedMonths);
        System.out.printf("Annual gross salary : %.2f€%n", annualGrossSalary);

        double annualNetSalary = applySocialCharges(annualGrossSalary, socialChargePercentage);
        System.out.printf("Annual net salary after social charges : %.2f€%n", annualNetSalary);

        double annualNetSalaryAfterTaxAllowance = applyTaxAllowance(annualNetSalary, taxAllowancePercentage);
        System.out.printf("Annual net salary after tax allowance : %.2f€%n", annualNetSalaryAfterTaxAllowance);

        double annualNetSalaryAfterRevenueTaxes = applyRevenueTax(annualNetSalaryAfterTaxAllowance);
        System.out.printf("Annual net salary after revenue taxes : %.2f€%n", annualNetSalaryAfterRevenueTaxes);
    }

}
