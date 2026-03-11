package javacore.chapter04.function.exercise;

public class FrenchNetSalaryCalculator {

    // taxable percent for each bracket
    static final double BRACKET_1_PERCENT = 0.0;
    static final double BRACKET_2_PERCENT = 11.0;
    static final double BRACKET_3_PERCENT = 30.0;
    static final double BRACKET_4_PERCENT = 41.0;
    static final double BRACKET_5_PERCENT = 45.0;

    // Upper bound of taxable brackets, I handle conditions with these.
    static final int BRACKET_1_MIN = 0;
    static final int BRACKET_2_MIN = 11294;
    static final int BRACKET_3_MIN = 28797;
    static final int BRACKET_4_MIN = 82341;
    static final int BRACKET_5_MIN = 177106;

    public static double calculateAnnualGrossSalary(double hourlyGrossSalary) {
        double dailyGrossSalary = hourlyGrossSalary * 7.7;
        double weeklyGrossSalary = dailyGrossSalary * 5;
        double monthlyGrossSalary = weeklyGrossSalary * 4;
        return monthlyGrossSalary * 12;
    }

    public static double applySocialCharges(double annualGrossSalary, double socialChargePercentage) {
        double socialChargesAmount =  annualGrossSalary * socialChargePercentage / 100;
        return annualGrossSalary - socialChargesAmount;
    }

    public static double applyTaxAllowance(double annualNetSalary, double taxAllowancePercentage) {
        double maxDeductionAmount = 10_000;
        double deductionAmount = annualNetSalary * taxAllowancePercentage / 100;
        if (deductionAmount >= maxDeductionAmount) {
            return annualNetSalary - maxDeductionAmount;
        }
        return annualNetSalary - annualNetSalary * taxAllowancePercentage / 100;
    }

    public static double applyRevenueTax(double annualNetSalary) {
        double remainingNetTaxableSalary = annualNetSalary;
        double totalTaxAmount = 0;
        if (remainingNetTaxableSalary > BRACKET_5_MIN) {

            // taxable amount on fifth bracket
            double fifthBracketAmount = remainingNetTaxableSalary - BRACKET_5_MIN;

            // tax amount
            double fifthTaxBracket = fifthBracketAmount * BRACKET_5_PERCENT / 100;

            // subtract remaining salary with the amount taxed in this bracket to go in the next if (cascade)
            remainingNetTaxableSalary = BRACKET_5_MIN;

            totalTaxAmount += fifthTaxBracket;
        }

        if (remainingNetTaxableSalary > BRACKET_4_MIN) {

            double fourthBracketAmount = remainingNetTaxableSalary - BRACKET_4_MIN;
            double fourthTaxBracket = fourthBracketAmount * BRACKET_4_PERCENT / 100;
            remainingNetTaxableSalary = BRACKET_4_MIN;

            totalTaxAmount += fourthTaxBracket;

        }

        if (remainingNetTaxableSalary > BRACKET_3_MIN) {

            double thirdBracketAmount = remainingNetTaxableSalary - BRACKET_3_MIN;;
            double thirdTaxBracket = thirdBracketAmount * BRACKET_3_PERCENT / 100;
            remainingNetTaxableSalary = BRACKET_3_MIN;

            totalTaxAmount += thirdTaxBracket;

        }

        if (remainingNetTaxableSalary > BRACKET_2_MIN) {

            double secondBracketAmount = remainingNetTaxableSalary - BRACKET_2_MIN;
            double secondTaxBracket = secondBracketAmount * BRACKET_2_PERCENT / 100;
            remainingNetTaxableSalary = BRACKET_2_MIN;

            totalTaxAmount += secondTaxBracket;

        }

        if (remainingNetTaxableSalary > BRACKET_1_MIN) {

            double firstBracketAmount = remainingNetTaxableSalary - BRACKET_1_MIN;
            double firstTaxBracket = firstBracketAmount * BRACKET_1_PERCENT / 100;

            totalTaxAmount += firstTaxBracket;

        }

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
        double taxAllowancePercentage = 10;

        double minFrenchHourlyWage = 11.07;
        double mediaFrenchHourlySalary = 17.50;
        double averageFrenchHourlySalary = 22.50;
        double wealthFrenchThresholdHourlySalary = 35;

        double annualGrossSalary = calculateAnnualGrossSalary(wealthFrenchThresholdHourlySalary);
        System.out.printf("Annual gross salary : %.2f€%n", annualGrossSalary);

        double annualNetSalary = applySocialCharges(annualGrossSalary, socialChargePercentage);
        System.out.printf("Annual net salary after social charges : %.2f€%n", annualNetSalary);

        double annualNetSalaryAfterTaxAllowance = applyTaxAllowance(annualNetSalary, taxAllowancePercentage);
        System.out.printf("Annual net salary after tax allowance : %.2f€%n", annualNetSalaryAfterTaxAllowance);

        double annualNetSalaryAfterRevenueTaxes = applyRevenueTax(annualNetSalaryAfterTaxAllowance);
        System.out.printf("Annual net salary after revenue taxes : %.2f€%n", annualNetSalaryAfterRevenueTaxes);
    }

}
